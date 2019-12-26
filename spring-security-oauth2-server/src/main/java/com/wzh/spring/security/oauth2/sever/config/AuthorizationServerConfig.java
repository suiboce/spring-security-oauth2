package com.wzh.spring.security.oauth2.sever.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author wzh
 * @date 2019/10/29 - 11:40
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    ClientDetailsService clientDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;

    //令牌生成方案  默认在内存中生成普通令牌
    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    // 配置客户端详情信息服务 客户端通过client_id和client_secret来访问资源
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")// client_id
                .secret(passwordEncoder.encode("secret"))// client_secret
                .authorizedGrantTypes("authorization_code")// 授权类型,共有authorization_code,password,client_credentials,implicit,refresh_token五种
                .scopes("app")// 授权范围
                .autoApprove(false)// false跳转到授权页面  true 直接发令牌
                .redirectUris("http://www.baidu.com");// 注册回调地址
    }

    // 令牌访问服务
    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setClientDetailsService(clientDetailsService);//客户端信息服务
        tokenServices.setTokenStore(tokenStore());// 令牌生成方案
        tokenServices.setRefreshTokenValiditySeconds(7200);//令牌默认有效期2小时
        tokenServices.setAccessTokenValiditySeconds(259200);// 刷新令牌默认有效期3天
        tokenServices.setSupportRefreshToken(true);// 设置刷新令牌
        return tokenServices;
    }

    // 授权码模式
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }

    // 令牌访问端点
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)//密码模式需要
                .authorizationCodeServices(authorizationCodeServices())//授权码模式需要
                .tokenStore(tokenStore())//令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);//允许POST提交
    }

    // 令牌访问策略
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")     //oauth/token_key公开
                .checkTokenAccess("permitAll()")  //oauth/check_token公开
                .allowFormAuthenticationForClients();//允许表单认证，申请令牌
    }
}

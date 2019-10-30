package com.wzh.spring.security.oauth2.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author wzh
 * @date 2019/10/29 - 18:10
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .and()
                // Session 创建策略
                // ALWAYS 总是创建HttpSession
                // NEVER,不会创建HttpSession，但是如果存在，就可以使用
                // IF_REQUIRED 在需要的时候创建
                // STATELESS 永远不会创建HttpSession 不会使用HttpSession来获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 以下为配置所需保护的资源路径及权限，需要与认证服务器配置的授权部分对应
                .antMatchers("/").hasAuthority("System")
                .antMatchers("/view/**").hasAuthority("SystemContentView");
    }
}

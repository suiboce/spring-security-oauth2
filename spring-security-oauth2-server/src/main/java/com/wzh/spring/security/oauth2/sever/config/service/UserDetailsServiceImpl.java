package com.wzh.spring.security.oauth2.sever.config.service;

import com.wzh.spring.security.oauth2.sever.domain.TbPermission;
import com.wzh.spring.security.oauth2.sever.domain.TbUser;
import com.wzh.spring.security.oauth2.sever.service.TbPermissionService;
import com.wzh.spring.security.oauth2.sever.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义用户认证与授权
 * @author wzh
 * @date 2019/10/29 - 15:08
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TbPermissionService tbPermissionService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.selectByUsername(s);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            // 获取用户授权
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId().intValue());
            tbPermissions.forEach(tbPermission -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(tbPermission.getEnname()));
            });
            // 由框架完成认证工作
            return new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
        }
        return null;
    }
}

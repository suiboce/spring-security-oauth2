package com.wzh.spring.security.oauth2.sever.service.impl;

import com.wzh.spring.security.oauth2.sever.domain.TbPermission;
import com.wzh.spring.security.oauth2.sever.domain.TbUser;
import com.wzh.spring.security.oauth2.sever.service.TbPermissionService;
import com.wzh.spring.security.oauth2.sever.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wzh
 * @date 2019/12/26 - 15:10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TbPermissionService tbPermissionService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(s);
        if (tbUser != null) {
            // 获取用户授权
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            List<SimpleGrantedAuthority> collect = tbPermissions.stream().map(TbPermission::getEnname).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            // 由框架完成认证工作
            return User.withUsername(tbUser.getUsername()).password(tbUser.getPassword()).authorities(collect).build();
        }
        return null;
    }
}

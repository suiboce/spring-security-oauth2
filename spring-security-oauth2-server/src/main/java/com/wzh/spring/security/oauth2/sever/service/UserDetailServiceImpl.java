package com.wzh.spring.security.oauth2.sever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author wzh
 * @date 2019/12/26 - 15:10
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //实际UserDetails根据s用户名去数据库查询，将结果放入UserDetails中，系统会去比较
        System.out.println("username:"+s);
        UserDetails userDetails = User.withUsername("zhangsan")
                .password(bCryptPasswordEncoder.encode("123456")).roles("VIP1","VIP3").build();
        return userDetails;
    }
}

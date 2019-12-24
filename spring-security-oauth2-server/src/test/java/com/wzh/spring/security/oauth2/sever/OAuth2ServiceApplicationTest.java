package com.wzh.spring.security.oauth2.sever;

import com.wzh.spring.security.oauth2.sever.config.service.TbUserService;
import com.wzh.spring.security.oauth2.sever.domain.TbPermission;
import com.wzh.spring.security.oauth2.sever.mapper.TbPermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wzh
 * @date 2019/10/29 - 13:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2ServiceApplicationTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
    @Autowired
    TbPermissionMapper tbPermissionMapper;
    @Autowired
    TbUserService tbUserService;
    @Test
    public void test1(){
        List<TbPermission> tbPermissions = tbPermissionMapper.selectByUserId(1L);
        tbPermissions.forEach(System.out::println);
    }

    @Test
    public void test2(){
        System.out.println(tbUserService.getByUsername("admin"));
    }
}

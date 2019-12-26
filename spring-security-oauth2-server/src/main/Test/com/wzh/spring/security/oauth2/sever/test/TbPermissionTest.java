package com.wzh.spring.security.oauth2.sever.test;

import com.wzh.spring.security.oauth2.sever.mapper.TbPermissionMapper;
import com.wzh.spring.security.oauth2.sever.mapper.TbRoleMapper;
import com.wzh.spring.security.oauth2.sever.mapper.TbUserMapper;
import com.wzh.spring.security.oauth2.sever.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wzh
 * @date 2019/12/26 - 15:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TbPermissionTest {
    @Autowired
    TbPermissionMapper tbPermissionMapper;
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    TbRoleMapper tbRoleMapper;

    @Test
    public void test(){
        System.out.println(tbUserService.getByUsername("admin"));
    }

    @Test
    public void test2(){
        System.out.println(tbUserService.getByUsername("admin"));
    }
}

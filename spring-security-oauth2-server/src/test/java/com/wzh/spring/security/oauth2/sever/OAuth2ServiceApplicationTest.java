package com.wzh.spring.security.oauth2.sever;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wzh
 * @date 2019/10/29 - 13:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2ServiceApplicationTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}

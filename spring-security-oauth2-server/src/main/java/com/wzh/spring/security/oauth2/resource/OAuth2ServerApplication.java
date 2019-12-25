package com.wzh.spring.security.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wzh
 * @date 2019/10/29 - 11:22
 */
@SpringBootApplication
@MapperScan(basePackages = "com.wzh.spring.security.oauth2.resource.mapper")
public class OAuth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class,args);
    }
}

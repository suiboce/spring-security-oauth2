package com.wzh.spring.security.oauth2.resource.service;

import com.wzh.spring.security.oauth2.resource.domain.TbUser;

/**
@author wzh
@date 2019/12/23 - 18:38
*/
public interface TbUserService{
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    TbUser getByUsername(String username);
}

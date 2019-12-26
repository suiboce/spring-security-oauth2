package com.wzh.spring.security.oauth2.sever.service;

import com.wzh.spring.security.oauth2.sever.domain.TbUser;

/**
@author wzh
@date 2019/12/26 - 15:38
*/
public interface TbUserService{

    TbUser getByUsername(String username);
}

package com.wzh.spring.security.oauth2.sever.service;

import com.wzh.spring.security.oauth2.sever.domain.TbPermission;

import java.util.List;

/**
@author wzh
@date 2019/12/26 - 15:38
*/
public interface TbPermissionService{

    List<TbPermission> selectByUserId(Long uid);
}

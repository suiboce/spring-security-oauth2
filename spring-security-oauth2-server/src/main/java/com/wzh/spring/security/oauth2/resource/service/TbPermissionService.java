package com.wzh.spring.security.oauth2.resource.service;

import com.wzh.spring.security.oauth2.resource.domain.TbPermission;

import java.util.List;

/**
@author wzh
@date 2019/12/23 - 18:38
*/
public interface TbPermissionService{

    List<TbPermission> selectByUserId(Long userId);
}

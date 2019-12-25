package com.wzh.spring.security.oauth2.resource.service.impl;

import com.wzh.spring.security.oauth2.resource.mapper.TbRolePermissionMapper;
import com.wzh.spring.security.oauth2.resource.service.TbRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
@author wzh
@date 2019/12/23 - 18:38
*/
@Service
public class TbRolePermissionServiceImpl implements TbRolePermissionService {

    @Resource
    private TbRolePermissionMapper tbRolePermissionMapper;

}

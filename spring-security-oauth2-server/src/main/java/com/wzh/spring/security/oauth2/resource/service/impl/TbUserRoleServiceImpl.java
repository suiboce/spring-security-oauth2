package com.wzh.spring.security.oauth2.resource.service.impl;

import com.wzh.spring.security.oauth2.resource.mapper.TbUserRoleMapper;
import com.wzh.spring.security.oauth2.resource.service.TbUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
@author wzh
@date 2019/12/23 - 18:38
*/
@Service
public class TbUserRoleServiceImpl implements TbUserRoleService {

    @Resource
    private TbUserRoleMapper tbUserRoleMapper;

}

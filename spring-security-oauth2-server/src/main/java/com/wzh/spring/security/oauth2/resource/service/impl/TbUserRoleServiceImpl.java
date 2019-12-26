package com.wzh.spring.security.oauth2.sever.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wzh.spring.security.oauth2.sever.mapper.TbUserRoleMapper;
import com.wzh.spring.security.oauth2.sever.service.TbUserRoleService;
/**
@author wzh
@date 2019/12/26 - 15:38
*/
@Service
public class TbUserRoleServiceImpl implements TbUserRoleService{

    @Resource
    private TbUserRoleMapper tbUserRoleMapper;

}

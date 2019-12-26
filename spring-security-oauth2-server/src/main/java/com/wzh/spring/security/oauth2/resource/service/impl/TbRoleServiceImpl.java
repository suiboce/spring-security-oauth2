package com.wzh.spring.security.oauth2.sever.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wzh.spring.security.oauth2.sever.mapper.TbRoleMapper;
import com.wzh.spring.security.oauth2.sever.service.TbRoleService;
/**
@author wzh
@date 2019/12/26 - 15:38
*/
@Service
public class TbRoleServiceImpl implements TbRoleService{

    @Resource
    private TbRoleMapper tbRoleMapper;

}

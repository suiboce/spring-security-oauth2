package com.wzh.spring.security.oauth2.sever.service.impl;

import com.wzh.spring.security.oauth2.sever.domain.TbPermission;
import com.wzh.spring.security.oauth2.sever.mapper.TbPermissionMapper;
import com.wzh.spring.security.oauth2.sever.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
@author wzh
@date 2019/12/26 - 15:38
*/
@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long uid) {
        return tbPermissionMapper.selectByUid(uid);
    }
}

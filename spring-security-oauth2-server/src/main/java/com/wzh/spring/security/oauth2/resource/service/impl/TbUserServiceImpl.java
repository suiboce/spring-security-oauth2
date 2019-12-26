package com.wzh.spring.security.oauth2.sever.service.impl;

import com.wzh.spring.security.oauth2.sever.domain.TbUser;
import com.wzh.spring.security.oauth2.sever.mapper.TbUserMapper;
import com.wzh.spring.security.oauth2.sever.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
@author wzh
@date 2019/12/26 - 15:38
*/
@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        return tbUserMapper.selectOne(new TbUser().setUsername(username));
    }
}

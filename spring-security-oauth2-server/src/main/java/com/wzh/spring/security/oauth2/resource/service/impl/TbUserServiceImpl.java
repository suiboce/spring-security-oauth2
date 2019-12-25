package com.wzh.spring.security.oauth2.resource.service.impl;

import com.wzh.spring.security.oauth2.resource.domain.TbUser;
import com.wzh.spring.security.oauth2.resource.mapper.TbUserMapper;
import com.wzh.spring.security.oauth2.resource.service.TbUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
@author wzh
@date 2019/12/23 - 18:38
*/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username",username);
        return tbUserMapper.selectOneByExample(example);
    }
}

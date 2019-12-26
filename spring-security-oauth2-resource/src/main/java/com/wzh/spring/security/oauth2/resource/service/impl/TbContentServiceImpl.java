package com.wzh.spring.security.oauth2.resource.service.impl;

import com.wzh.spring.security.oauth2.resource.domain.TbContent;
import com.wzh.spring.security.oauth2.resource.mapper.TbContentMapper;
import com.wzh.spring.security.oauth2.resource.service.TbContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
@author wzh
@date 2019/12/24 - 16:35
*/
@Service
public class TbContentServiceImpl implements TbContentService {

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }
}

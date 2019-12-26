package com.wzh.spring.security.oauth2.resource.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wzh.spring.security.oauth2.resource.mapper.TbContentCategoryMapper;
import com.wzh.spring.security.oauth2.resource.service.TbContentCategoryService;
/**
@author wzh
@date 2019/12/24 - 16:35
*/
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

}

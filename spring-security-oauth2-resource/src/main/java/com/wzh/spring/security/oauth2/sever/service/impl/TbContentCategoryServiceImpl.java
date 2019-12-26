package com.wzh.spring.security.oauth2.sever.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wzh.spring.security.oauth2.sever.mapper.TbContentCategoryMapper;
import com.wzh.spring.security.oauth2.sever.service.TbContentCategoryService;
/**
@author wzh
@date 2019/12/24 - 16:35
*/
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

}

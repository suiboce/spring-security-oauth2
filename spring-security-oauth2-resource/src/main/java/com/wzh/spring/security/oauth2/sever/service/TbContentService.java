package com.wzh.spring.security.oauth2.sever.service;

import com.wzh.spring.security.oauth2.sever.domain.TbContent;

import java.util.List;

/**
@author wzh
@date 2019/12/24 - 16:35
*/
public interface TbContentService {

    List<TbContent> selectAll();
}

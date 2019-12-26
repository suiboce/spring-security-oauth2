package com.wzh.spring.security.oauth2.sever.mapper;

import com.wzh.spring.security.oauth2.sever.domain.TbPermission;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
@author wzh
@date 2019/12/26 - 15:38
*/
public interface TbPermissionMapper extends MyMapper<TbPermission> {

    List<TbPermission> selectByUid(Long uid);
}

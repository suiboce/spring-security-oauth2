package com.wzh.spring.security.oauth2.resource.mapper;

import com.wzh.spring.security.oauth2.resource.domain.TbPermission;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
@author wzh
@date 2019/12/23 - 18:38
*/
public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission>  selectByUserId(Long userId);
}

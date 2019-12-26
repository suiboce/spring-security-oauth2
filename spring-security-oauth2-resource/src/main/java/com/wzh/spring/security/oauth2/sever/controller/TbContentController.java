package com.wzh.spring.security.oauth2.sever.controller;

import com.wzh.spring.security.oauth2.sever.domain.TbContent;
import com.wzh.spring.security.oauth2.sever.dto.ResponseResult;
import com.wzh.spring.security.oauth2.sever.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzh
 * @date 2019/12/24 - 16:36
 */
@RestController
public class TbContentController {

    @Autowired
    TbContentService tbContentService;

    @GetMapping("/view")
    @PreAuthorize("hasAuthority('SystemContentView')")
    public ResponseResult<List<TbContent>> list(){
        return new ResponseResult<>(HttpStatus.OK.value(),HttpStatus.OK.toString(),tbContentService.selectAll());
    }
}

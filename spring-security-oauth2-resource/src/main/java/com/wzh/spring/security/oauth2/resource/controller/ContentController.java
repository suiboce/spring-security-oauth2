package com.wzh.spring.security.oauth2.resource.controller;

import com.wzh.spring.security.oauth2.resource.domain.Content;
import com.wzh.spring.security.oauth2.resource.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzh
 * @date 2019/10/30 - 11:05
 */
@RestController
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping("/")
    public List<Content> selectAll(){
        return contentService.selectAll();
    }
}

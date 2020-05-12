package com.test.demo1.controller;

import com.github.pagehelper.PageInfo;
import com.test.demo1.dao.UserEntity;
import com.test.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author geweijian
 * @data 2019-02-25
 */
@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("save")
    public String save() {
        userService.save(UserEntity.builder().name("哈哈哈哈哈").build());
        return "1";
    }

    @GetMapping("query")
    public PageInfo<UserEntity> query(Integer offset, Integer limit) {
        return userService.query(offset, limit);
    }
}

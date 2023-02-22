package com.orange.demo.user.controller;

import com.orange.common.result.Result;
import com.orange.demo.user.entity.User;
import com.orange.demo.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 16:34
 * @description: 测试异步任务
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public Result<?> listAllUsers(){
        List<User> users = userService.listAllUsers();
        return Result.success(users);
    }
}

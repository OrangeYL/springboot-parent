package com.orange.demo.transactional;

import com.orange.common.result.Result;
import com.orange.demo.user.entity.User;
import com.orange.demo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/22 18:53
 * @description: 测试事务注解@Transactional回滚
 */
@RestController
@RequestMapping("/trans")
public class TController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public Result<?> testTrans(){
        List<User> users = getUserList();
        userService.saveBatch(users);
        return Result.success("操作成功");
    }

    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        User u1 = new User("张甘甘", 24, "广东省深圳市南山区");
        User u2 = new User("李三三", 24, "广东省深圳市南山区");
        users.add(u1);
        users.add(u2);
        return users;
    }
}

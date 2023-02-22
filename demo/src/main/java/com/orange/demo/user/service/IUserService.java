package com.orange.demo.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.common.result.Result;
import com.orange.demo.user.entity.User;

import java.util.List;

/**
 * @author Li ZhiCheng
 * @since 2022-10-08
 */
public interface IUserService extends IService<User> {

    /**
     * 查询所有用户
     **/
    public List<User> listAllUsers();

    public Result<?> saveBatch(List<User> users);
}

package com.orange.demo.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.demo.user.entity.User;
import com.orange.demo.user.mapper.UserMapper;
import com.orange.demo.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Li ZhiCheng
 * @since 2022-10-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public List<User> listAllUsers() {
        List<User> users = this.baseMapper.selectList(null);
        return users;
    }
}

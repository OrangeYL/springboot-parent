package com.orange.demo.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.common.exception.BizException;
import com.orange.common.result.Result;
import com.orange.demo.user.entity.User;
import com.orange.demo.user.mapper.UserMapper;
import com.orange.demo.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> saveBatch(List<User> users){
        if(users.size() > 0){
            users.forEach(item ->{
                if(item.getName().equals("李三三")){
                    throw new BizException("该用户已存在！");
                }
                this.baseMapper.insert(item);
            });
        }
        return Result.success("操作成功！");
    }
}

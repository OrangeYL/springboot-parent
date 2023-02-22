package com.orange.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Li ZhiCheng
 * @since 2022-10-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

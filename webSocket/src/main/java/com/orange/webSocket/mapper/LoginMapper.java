package com.orange.webSocket.mapper;

import com.orange.webSocket.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/27 16:22
 * @description:
 */
@Mapper
public interface LoginMapper {

    public Staff getPasswordByName(@Param("name") String name);

    public Staff getNameById(@Param("id") int id);
}

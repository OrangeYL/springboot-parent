package com.orange.webSocket.service.impl;

import com.orange.webSocket.entity.Staff;
import com.orange.webSocket.mapper.LoginMapper;
import com.orange.webSocket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/27 16:31
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public String getPasswordByName(String name) {
        Staff staff = loginMapper.getPasswordByName(name);
        String password = null;
        if(staff != null){
            password = staff.getPassword();
        }
        return password;
    }

    @Override
    public Integer getIdByName(String name) {
        Staff staff = loginMapper.getPasswordByName(name);
        Integer id = null;
        if(staff != null){
            id = staff.getStaffId();
        }
        return id;
    }

    @Override
    public String getNameById(int id) {
        Staff staff = loginMapper.getNameById(id);
        String name = null;
        if(staff != null){
            name = staff.getUsername();
        }
        return name;
    }
}

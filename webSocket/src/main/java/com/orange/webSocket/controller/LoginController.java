package com.orange.webSocket.controller;

import com.orange.webSocket.entity.User;
import com.orange.webSocket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author: Li ZhiCheng
 * @create: 2023-02-2023/2/27 16:37
 * @description:
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginservice;

    //登录验证
    @RequestMapping("/loginValidate")
    public String loginValidate(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession){
        if(username == null || username.equals(""))
            return "login";
        String realPassword=loginservice.getPasswordByName(username);
        if(password.equals(realPassword))
        {
            int id = loginservice.getIdByName(username);
            httpSession.setAttribute("id", id);
            return "chatroom";
        }else
            return "fail";
    }
    //进入登录页
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        return "login";
    }

    @RequestMapping(value="/currentUser",method = RequestMethod.GET)
    @ResponseBody
    public User currentUser(HttpSession httpSession){
        int id = (Integer) httpSession.getAttribute("id");
        String name = loginservice.getNameById(id);
        return new User(id, name);
    }
}

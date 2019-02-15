package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.entity.User;
import com.chen.service.UserService;

@Controller
public class LoginController {
	UserService userService;
	
	@RequestMapping(value = "/hello.do")
    public String hello(){
        System.out.println("接收到请求 ，Hello");
        return "hi";
    }

    @RequestMapping(value = "/login.do")
    public String login(String name, String password){
        try {
            User user = userService.userLogin(name, password);
            if(user == null){
                System.out.println("登陆失败");
            }else {
                System.out.println("登陆成功");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("登录失败");
        }
        return null;
    }

}

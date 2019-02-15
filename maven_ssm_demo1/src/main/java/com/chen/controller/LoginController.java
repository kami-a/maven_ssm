package com.chen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.entity.User;
import com.chen.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "hello.do")
    public String hello(){
        System.out.println("接收到请求 ，Hello");
        return "hi";
    }

    @RequestMapping(value = "login.do")
    public String login(String name, String password){
        try {
            User user = userService.userLogin(name, password);
            if(user == null){
                System.out.println("登陆失败1");
            }else {
                System.out.println("登陆成功");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("登录失败2");
        }
        return null;
    }
    @RequestMapping(value = "add.do")
    public int userAdd(String name,String password) {
    	User user = new User(name, password);
    	try {
			int a=userService.userAdd(user);
			if(a==0) {
				System.out.println("fail");
				return a;
			}else {
				System.out.println("success");
				return a;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
            System.out.println("添加失败2");
		}
    	return 0;
    }
}

package com.chen.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chen.entity.User;
import com.chen.service.UserService;
import com.chen.util.JsonUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	//自动装载UserService接口，对其进行实现
	@Autowired
	UserService userService;

	private static Logger logger = LogManager.getLogger(UserController.class);
	//登录模块
    @RequestMapping(value = "/login.do")
    public String login(String name, String password,HttpServletRequest request,Model model){
        try {
            User user = userService.userLogin(name, password);
            if(user == null){
                logger.info("登陆失败，账号密码为空或密码不正确");
                return "fail";
            }else {
                logger.info("登陆成功");
                String returnMsg = JSONObject.toJSONString(user);
                //输入保持session
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("username", user.getName());
                model.addAttribute(returnMsg);
                return "success";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            logger.warn("登录失败,系统异常");
        }
        return "fail";
    }
    
    //注册模块
    @RequestMapping(value = "/regedit.do")
    public String userAdd(@ModelAttribute("form")User user,Model model) {
    	
    	try {
			int a=userService.userAdd(user);
			if(a==0) {
				logger.info("注册失败");
				return "fail";
			}else {
				logger.info("注册成功");
				String returnMsg = JsonUtil.userToJson(user);
				model.addAttribute("returnMsg",returnMsg);
				return "success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
            logger.warn("注册失败，系统异常");
		}
    	return "fail";
    }
	
	//取出所有用户信息
	@RequestMapping(value="/showAll.do")
	@ResponseBody
	public String showAll(Model model) {
		String returnMsg="";
	try {
		List<User> users = userService.showAll();
		returnMsg = JSONObject.toJSONString(users);
		System.out.println(returnMsg);
		model.addAttribute(returnMsg);
  	} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println(e.getMessage());
  	}
	  return returnMsg;
	}

}

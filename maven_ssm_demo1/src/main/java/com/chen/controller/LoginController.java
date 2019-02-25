package com.chen.controller;

import java.util.List;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

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
public class LoginController {
	@Autowired
	UserService userService;

    @RequestMapping(value = "login.do")
    public String login(String name, String password,HttpServletResponse response){
        try {
            User user = userService.userLogin(name, password);
            if(user == null){
                System.out.println("登陆失败1");
            }else {
                System.out.println("登陆成功");
                String returnMsg = JsonUtil.userToJson(user);
                Writer writer = response.getWriter();
                writer.write(returnMsg);
                writer.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("登录失败2");
        }
        return null;
    }
    @RequestMapping(value = "regedit.do")
    public String userAdd(@ModelAttribute("form")User user,HttpServletResponse response,Model model) {
    	
    	try {
			int a=userService.userAdd(user);
			if(a==0) {
				System.out.println("fail");
				return "fail";
			}else {
				System.out.println("success");
				String returnMsg = JsonUtil.userToJson(user);
//                Writer writer = response.getWriter();
//                writer.write(returnMsg);
//                writer.close();
				model.addAttribute("returnMsg",returnMsg);
				return "index";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
            System.out.println("添加失败2");
		}
    	return null;
    }
	
	
	  @RequestMapping(value="showAll.do")
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
			e.printStackTrace();
		}
		  return returnMsg;
	  }
	 
	 
}

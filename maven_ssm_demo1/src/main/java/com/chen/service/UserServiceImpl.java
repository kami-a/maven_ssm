package com.chen.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.UserDao;
import com.chen.entity.User;
import com.mysql.cj.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	//实现登录
	public User userLogin(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(name+" "+password);
		if (StringUtils.isNullOrEmpty(name)) {
			logger.info("name can not be empty");
			return null;
		}
		if (StringUtils.isNullOrEmpty(password)) {
			logger.info("password can not be empty");
			return null;
		}
		User user=userDao.selectUserByName(name);
		if (user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
	
	//实现添加账号
	@Override
	public int userAdd(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user.toString());
		if (user==null||"".equals(user.toString())) {
			logger.info("注册 账号密码不可为空");
			return 0;
		}
		int a = userDao.insertUser(user);
		return a;
	}
	
	//实现取数据
	@Override
	public List<User> showAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectAllUser();
	}
}

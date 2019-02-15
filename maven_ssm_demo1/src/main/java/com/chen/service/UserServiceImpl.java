package com.chen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.UserDao;
import com.chen.entity.User;
import com.mysql.cj.core.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	public User userLogin(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(name+" "+password);
		if (StringUtils.isNullOrEmpty(name)) {
			System.out.println("name can not be empty");
			return null;
		}
		if (StringUtils.isNullOrEmpty(password)) {
			System.out.println("password can not be empty");
			return null;
		}
		User user=userDao.selectUserByName(name);
		return user;
	}
	@Override
	public int userAdd(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user.toString());
		if (user==null||"".equals(user)) {
			System.out.println("user can not be empty");
			return 0;
		}
		int a = userDao.insertUser(user);
		return a;
	}

}

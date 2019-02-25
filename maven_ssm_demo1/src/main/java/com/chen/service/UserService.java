package com.chen.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.chen.entity.User;

@Service
public interface UserService {
	public User userLogin(String name,String password) throws Exception;
	public int userAdd(User user) throws Exception;
	public List<User> showAll() throws Exception;
}

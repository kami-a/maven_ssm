package com.chen.service;

import org.springframework.stereotype.Service;

import com.chen.entity.User;

@Service
public interface UserService {
	public User userLogin(String name,String password) throws Exception;
}

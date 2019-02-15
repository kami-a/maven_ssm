package com.chen.dao;

import java.util.List;

import com.chen.entity.User;

public interface UserDao {
	/**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser (User user,int id) throws Exception;
     /**
      * 刪除用戶
      * @param id
      * @return
      * @throws Exception
      */
    public int deleteUser(int id) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User selectUserById(int id) throws Exception;
    
    /**
     * 根据name查询用户信息
     * @param name
     * @return
     * @throws Exception
     */
    public User selectUserByName(String name) throws Exception;
     /**
      * 查询所有的用户信息
      * @return
      * @throws Exception
      */
    public List<User> selectAllUser() throws Exception;
}

package com.wz.notebookstore.service;

import java.util.List;

import com.wz.notebookstore.model.User;

public interface UserService {
	Integer updUserById(User user);
	Integer addUser(User user);
	User selectUserById(Integer user_id);
	List<User> selectAllUser();
	List<User> selectLikeName(String user_name);	
	boolean delUserById(Integer user_id);
	User login(String user_name,String user_password);
	/*
	 * 返回：1成功；0用户名不存在；-1密码错误
	 */
	int validateLogin(String userName, String userPassword);
	String selectPasswordByName(String name);
}

package com.wz.notebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wz.notebookstore.dao.UserDao;
import com.wz.notebookstore.model.User;
import com.wz.notebookstore.service.UserService;

@Service
public  class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public Integer updUserById(User user) {
		// TODO Auto-generated method stub
		return userDao.updUserById(user);
	}

	@Override
	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User selectUserById(Integer user_id) {
		// TODO Auto-generated method stub
		return userDao.selUserById(user_id);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.selAllUser();
	}

	@Override
	public List<User> selectLikeName(String user_name) {
		// TODO Auto-generated method stub
		return userDao.selUserByName(user_name);
	}

	@Override
	public boolean delUserById(Integer user_id) {
		if(userDao.delUserById(user_id) > 0)
			return true;
		return false;
	}

	@Override
	public User login(String user_name, String user_password) {
		User user = userDao.login(user_name, user_password);
		if(null == user) {
			System.out.println("登陆失败");
			return null;
		}
		return user;
	}

	@Override
	public int validateLogin(String userName, String userPassword) {
		String password = userDao.selectPasswordByName(userName);
		if(null == password || "".equals(password)) {
			return 0;
		}
		if(!userPassword.equals(password)) {
			return -1;
		}
		return 1;
	}

	@Override
	public String selectPasswordByName(String name) {
		return userDao.selectPasswordByName(name);
	}
	
}

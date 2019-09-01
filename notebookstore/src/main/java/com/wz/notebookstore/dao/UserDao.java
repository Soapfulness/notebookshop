package com.wz.notebookstore.dao;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.wz.notebookstore.dao.UserDao;
import com.wz.notebookstore.dao.UserProvider;
import com.wz.notebookstore.model.User;

@Mapper
public interface UserDao {
	@InsertProvider(type=UserProvider.class, method="addUser")
	Integer addUser(User user);
	
	@DeleteProvider(type=UserProvider.class, method="delUserById")
	Integer delUserById(Integer userId);
	
	@UpdateProvider(type=UserProvider.class, method="updUserById")
	Integer updUserById(User user) ;
	
	@SelectProvider(type=UserProvider.class, method="selUserById")
	User selUserById(Integer UserId);
	
	@SelectProvider(type=UserProvider.class, method="selUserByName")
	List<User> selUserByName(String userName);
	
	@SelectProvider(type=UserProvider.class, method="selAllUser")
	List<User> selAllUser();
	
	@SelectProvider(type=UserProvider.class, method="login")
	User login(String user_name, String user_password);
	
	@SelectProvider(type=UserProvider.class, method="selectPasswordByName")
	String selectPasswordByName(String userName);

}

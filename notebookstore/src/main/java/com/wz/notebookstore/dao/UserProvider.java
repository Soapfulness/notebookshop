package com.wz.notebookstore.dao;

import org.apache.ibatis.jdbc.SQL;


import com.wz.notebookstore.model.User;



public class UserProvider {
	public String addUser(User user) {
		SQL sql = new SQL();
		sql.INTO_COLUMNS("user_name,user_password,user_email,user_gender,user_telephone,user_image,user_address");
		sql.INSERT_INTO("`user`");
		sql.INTO_VALUES("#{userName},#{userPassword},#{userEmail},#{userGender},#{userTelephone},#{userImage},#{userAddress}");
		return sql.toString();
	}
	
	public String delUserById(Integer userId) {
		SQL sql = new SQL();
		sql.DELETE_FROM("`user`");
		sql.WHERE("user_id = " + userId);
		return sql.toString();
	}

	public String updUserById(User user) {
		SQL sql = new SQL();
		sql.UPDATE("`user`");
		if(user.getUserEmail().trim().length() > 0)
			sql.SET("user_email = '" + user.getUserEmail() + "'");
		if(user.getUserName().trim().length() > 0)
			sql.SET("user_name = '" + user.getUserName() + "'");
		if(user.getUserPassword().trim().length() > 0)
			sql.SET("user_password = '" + user.getUserPassword() + "'");
		if(user.getUserGender().trim().length() > 0)
			sql.SET("user_gender = '" + user.getUserGender() + "'");
		if(user.getUserTelephone().trim().length() > 0)
			sql.SET("user_telephone = '" + user.getUserTelephone() + "'");
		sql.WHERE("user_id = " + user.getUserId());
		return sql.toString();
	}
	
	public String selUserById() {
		SQL sql = new SQL();
		sql.SELECT("user_id,user_name,user_password,user_email,user_gender,user_telephone,user_image,user_address");
		sql.FROM("user");
		sql.WHERE("user_id = #{user_id}" );
		return sql.toString();
	}
	
	public String selUserByName(String userName) {
		SQL sql = new SQL();
		sql.SELECT("user_id userId,`user_name` userName,user_password userPassword,user_email userEmail,user_gender userGender,user_telephone userTelephone");
		sql.FROM("user");
		sql.WHERE("user_name like '%" + userName + "%'");
		return sql.toString();
	}
	
	public String selAllUser() {
		SQL sql = new SQL();
		sql.SELECT("user_id userId,`user_name` userName,user_password userPassword,user_email userEmail,user_gender userGender,user_telephone userTelephone");
		sql.FROM("user");
		sql.WHERE("1=1");
		return sql.toString();
	}
	
	public String login(String user_name, String user_password) {
		SQL sql = new SQL();
		sql.SELECT("user_id userId,`user_name` userName,user_password userPassword,user_email userEmail,user_gender userGender,user_telephone userTelephone");
		sql.FROM("user");
		sql.WHERE("`user_password` = '" + user_password + "' AND `user_name` = '" + user_name + "'");
		return sql.toString();
	}
	
	public String selectPasswordByName(String userName) {
		SQL sql = new SQL();
		sql.SELECT("user_password userPassword");
		sql.FROM("user");
		sql.WHERE("user_name = '" + userName + "'");
		return sql.toString();
	}
}

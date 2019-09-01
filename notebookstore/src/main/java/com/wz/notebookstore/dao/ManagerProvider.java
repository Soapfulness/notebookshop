package com.wz.notebookstore.dao;

import org.apache.ibatis.jdbc.SQL;

import com.wz.notebookstore.model.Manager;
public class ManagerProvider {

	public String selectAll(Integer managerValue) {
		SQL sql = new SQL();
		sql.SELECT("manager_id managerId,manager_name managerName,manager_password managerPassword,manager_value managerValue");
		sql.FROM("manager");
		sql.WHERE("manager_value < #{managerValue}");
		return sql.toString();
	}
	
	public String login(Manager manager) {
		SQL sql = new SQL();
		sql.SELECT("COUNT(manager_id)");
		sql.FROM("manager");
		sql.WHERE("manager_name='" + manager.getManagerName() + "' AND manager_password='" + manager.getManagerPassword() + "'");
		return sql.toString();
	}

	public String addManager(Manager manager) {
		SQL sql = new SQL();
		sql.INTO_COLUMNS("manager_name,manager_password,manager_value");
		sql.INSERT_INTO("manager");
		sql.INTO_VALUES("#{managerName}, #{managerPassword}, #{managerValue}");
		return sql.toString();
	}

	public String delManagerById(Integer managerId) {
		SQL sql = new SQL();
		sql.DELETE_FROM("manager");
		sql.WHERE("manager_id=#{managerId}");
		return sql.toString();
	}

	public String updateById(Manager manager) {
		SQL sql = new SQL();
		sql.UPDATE("manager");
		if(manager.getManagerName().trim().length()>0)
			sql.SET("manager_name = #{managerName}");
		if(manager.getManagerPassword().trim().length()>0)
			sql.SET("manager_password = #{managerPassword}");
		if(manager.getManagerValue()>0)
			sql.SET("manager_value = #{managerValue}");
		sql.WHERE("manager_id = #{managerId}");
		return sql.toString();
	}

	public String selectManagerById() {
		SQL sql = new SQL();
		sql.SELECT("manager_id,manager_name,manager_password,manager_value");
		sql.FROM("manager");
		sql.WHERE("manager_id = #{manager_id}");
		return sql.toString();
	}

	public String selectManagerByName(String managerName) {
		SQL sql = new SQL();
		sql.SELECT("manager_id managerId,manager_name managerName,manager_password managerPassword,manager_value managerValue");
		sql.FROM("manager");
		sql.WHERE("manager_name Like '%" + managerName + "%'");
		return sql.toString();
	}
	
	
	
	public String updatePasswordById(Manager manager) {
		SQL sql=new SQL();
		sql.UPDATE("manager");
		sql.SET("manager_password = #{managerPassword}");
		sql.WHERE("manager_id = #{managerId}");
		return sql.toString();
	}
	
	public String selectManByName(String managerName) {
		SQL sql=new SQL();
		sql.SELECT("manager_id managerId, manager_name managerName, manager_password managerPassword, manager_value managerValue");
		sql.FROM("manager");
		sql.WHERE("manager_name = #{managerName}");
		return sql.toString();
	}
}

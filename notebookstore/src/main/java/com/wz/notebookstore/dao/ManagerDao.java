package com.wz.notebookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.wz.notebookstore.model.Manager;

@Mapper
public interface ManagerDao {
	
	@SelectProvider(type=ManagerProvider.class,method="selectAll")
	List<Manager> selectAll(Integer managerValue);
	
	@SelectProvider(type=ManagerProvider.class, method="login")
	Integer login(Manager manager);
	
	@InsertProvider(type=ManagerProvider.class,method="addManager")
	Integer addManager(Manager manager);
	
	@DeleteProvider(type=ManagerProvider.class,method="delManagerById")
	boolean delManagerById(Integer mangerId);
	
	@UpdateProvider(type=ManagerProvider.class,method="updateById")
	Integer updateManagerById(Manager manager);
	
	@SelectProvider(type=ManagerProvider.class,method="selectManagerById")
	Manager selectManagerById(Integer managerId);
	
	@SelectProvider(type=ManagerProvider.class,method="selectManagerByName")
	List<Manager> selectManagerByName(String managerName);
	
	
	
	@UpdateProvider(type=ManagerProvider.class,method="updatePasswordById")
	Integer updatePasswordById(Manager manager);
	
	@SelectProvider(type=ManagerProvider.class,method="selectManByName")
	Manager selectManByName(String managerName);

}

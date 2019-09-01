package com.wz.notebookstore.service;

import java.util.List;

import com.wz.notebookstore.model.Manager;

public interface ManagerService {
	List<Manager> selectAll(Integer managerValue);
	List<Manager> selectLikeName(String managerName);
	Manager selectManagerById(Integer id);
	boolean deleteManager(Integer id);
	Integer addManager(Manager manager);
	Integer updateManager(Manager manager);
	
	
	boolean updatePasswordById(Manager manager);
	Manager selectManByName(String managerName);
	boolean login(Manager manager);
}

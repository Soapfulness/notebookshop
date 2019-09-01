package com.wz.notebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.notebookstore.dao.ManagerDao;
import com.wz.notebookstore.model.Manager;
import com.wz.notebookstore.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDao managerDao;
	
	@Override
	public List<Manager> selectAll(Integer managerValue) {
		// TODO Auto-generated method stub
		return managerDao.selectAll(managerValue);
	}

	@Override
	public List<Manager> selectLikeName(String managerName) {
		// TODO Auto-generated method stub
		return managerDao.selectManagerByName(managerName);
	}

	@Override
	public Manager selectManagerById(Integer id) {
		// TODO Auto-generated method stub
		return managerDao.selectManagerById(id);
	}

	@Override
	public boolean deleteManager(Integer id) {
		// TODO Auto-generated method stub
		return managerDao.delManagerById(id);
	}

	@Override
	public Integer addManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.addManager(manager);
	}

	@Override
	public Integer updateManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.updateManagerById(manager);
	}

	@Override
	public boolean updatePasswordById(Manager manager) {
		if(managerDao.updatePasswordById(manager) > 0)
			return true;
		return false;
	}

	@Override
	public Manager selectManByName(String managerName) {
		return managerDao.selectManByName(managerName);
	}

	@Override
	public boolean login(Manager manager) {
		int result = managerDao.login(manager);
		if(result == 1)
			return true;
		return false;
	}
	

}
package com.wz.notebookstore.model;

import java.io.Serializable;

public class Manager implements Serializable {
	private int managerId;//管理员id
	private String managerName;//管理员名字
	private String managerPassword;//管理员密码
	private int managerValue;//管理员权限级别
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
	public int getManagerValue() {
		return managerValue;
	}
	public void setManagerValue(int managerValue) {
		this.managerValue = managerValue;
	}
	public Manager(int managerId, String managerName, String managerPassword, int managerValue) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerPassword = managerPassword;
		this.managerValue = managerValue;
	}
	public Manager() {
		super();
	}
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerPassword="
				+ managerPassword + ", managerValue=" + managerValue + "]";
	}
	
	public Manager(String managerName, String managerPassword) {
		super();
		this.managerName = managerName;
		this.managerPassword = managerPassword;
	}
	
}

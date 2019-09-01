package com.wz.notebookstore.model;

import java.io.Serializable;

public class User implements Serializable {

	private int userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userGender;
	private String userTelephone;
	private String userImage;
	private String userAddress;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}	
	
	public User() {
		super();
	}
	
	public User(int userId, String userName, String userPassword, String userEmail, String userGender,
			String userTelephone, String userImage, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userTelephone = userTelephone;
		this.userImage = userImage;
		this.userAddress = userAddress;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userGender=" + userGender + ", userTelephone=" + userTelephone + ", userImage="
				+ userImage + ", userAddress=" + userAddress + "]";
	}
	
	
}

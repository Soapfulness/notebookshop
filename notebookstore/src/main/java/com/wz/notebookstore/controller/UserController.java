package com.wz.notebookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wz.notebookstore.model.User;
import com.wz.notebookstore.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
//	@GetMapping(value= {""})
//	public String managerValueDiv(Model model) {
//		List<User> userList=new ArrayList<User>();
//		userList=userService.selectAllUser();
//		if(null==userList||userList.size()==0) {
//			model.addAttribute("","查询失败:没有任何用户");
//			return "";
//		}
//		model.addAttribute("userList",userList);
//		return "";
//	}
	
//	@RequestMapping(value = {""})
//	public String addUser(String userName,String userPassword,String userEmail,String userGender,String userTelephone,String userImage,String userAddress,Model model) {
//		User user = new User(userName,userPassword,userEmail,userGender,userTelephone,userImage,userAddress);	
//		if(null!=user.getUserName()|| null!=user.getUserPassword() || null!=user.getUserEmail()||null!=user.getUserGender()||null!=user.getUserTelephone()||null!=user.getUserImage()||null!=user.getUserAddress()) {
//			if(userService.addUser(user)>0) {
//				return "";
//			}
//			model.addAttribute("errormsg", "添加用户失败！");
//			return "/error/errormsg";
//		}
//		model.addAttribute("errormsg", "添加用户失败！");
//		return "/error/errormsg";
//	}
	
//	@RequestMapping(value = {""})
//	public String delUserById(Integer userId,Model model) {
//		if(null!=userId && userId>0) {
//			if(userService.delUserById(userId)) {
//				model.addAttribute("userId",userId);
//				return "";
//			}
//			model.addAttribute("errormsg", "删除该用户失败！");
//			return "/error/errormsg";
//		}
//		model.addAttribute("errormsg", "删除该用户失败！");
//		return "/error/errormsg";
//	}
	
//	@RequestMapping(value = {""})
//	public String updUserById(String userName,String userPassword,String userEmail,String userGender,String userTelephone,String userImage,String userAddress,Model model) {
//		User user= new User(userId, userName, userPassword, userEmail, userGender, userTelephone, userImage, userAddress)
//		if(userService.updUserById(user)>0) {
//			List<User> userList = new ArrayList<User>();
//			if(null==userList || userList.size()==0) {
//				model.addAttribute("errormsg", "查询失败：没有您要查找的用户");
//				return "/error/errormsg";
//			}
//			model.addAttribute("userList",userList);
//			return "";
//		}
//		model.addAttribute("errormsg", "修改操作失败！");
//		return "/error/errormsg";
//	}
	
//	@RequestMapping(value = {"/selectStyle"})
//	public String selectStyleByName(Model model,String UserName) {
//		List<User> userList = new ArrayList<User>();		
//		if(null != UserName && !"".equals(UserName)) {
//			userList=userService.selectLikeName(UserName);
//			if(null!=userList && userList.size()>0) {
//				model.addAttribute("userList", userList);
//			}else {
//				model.addAttribute("errormsg", "查询失败");
//				return "/error/errormsg";
//			}
//		}else {
//			userList = userService.selectAllUser();
//			if(null == userList || userList.size() == 0) {
//				model.addAttribute("errormsg", "查询失败");
//				return "/error/errormsg";
//			}
//			model.addAttribute("userList", userList);			
//			return "";
//		}
//		return "";
//	}
	
	@RequestMapping(value="/userLogin")
	public String userLogin(Model model, HttpSession session, String userName, String userPassword) {
		switch(userService.validateLogin(userName, userPassword)) {
			case -1:
				model.addAttribute("errormsg","登陆失败：用户名或密码错误！");
				model.addAttribute("back", "/toLogin");
				model.addAttribute("backmsg", "登陆页面");
				return "error";
			case 0:
				model.addAttribute("errormsg","登陆失败：用户名不存在！");
				model.addAttribute("back", "/toLogin");
				model.addAttribute("backmsg", "登陆页面");
				return "error";
			case 1:
				break;
		}
		User user = userService.login(userName, userPassword);
		if(null == user) {
			model.addAttribute("errormsg","登陆失败：未知的用户！");
			model.addAttribute("back", "/toLogin");
			model.addAttribute("backmsg", "登陆页面");
			return "error";
		}
		session.setAttribute("login", user);
		return "index";
	}
	
	@RequestMapping(value="/register")
	public String register(Model model, String userName, String gender, String userTelephone, String userEmail, String userPassword) {
		String p = userService.selectPasswordByName(userName);
		if(null!=p && !"".equals(p)) {
			model.addAttribute("errormsg","注册失败：用户名已存在！");
			model.addAttribute("back", "/toRegister");
			model.addAttribute("backmsg", "注册页面");
			return "error";
		}
		User user = new User(0, userName, userPassword, userEmail, gender, userTelephone, "", "");
		if(userService.addUser(user) <= 0) {
			model.addAttribute("errormsg","注册失败：未知的用户！");
			model.addAttribute("back", "/toRegister");
			model.addAttribute("backmsg", "注册页面");
			return "error";
		}
		model.addAttribute("successmsg","注册成功：欢迎您！");
		model.addAttribute("back", "/toLogin");
		model.addAttribute("backmsg", "登陆页面");
		return "success";
	}
	
	@RequestMapping(value = {"/selUserByNameAJAX"})
	@ResponseBody
	public List<User> selUserByNameAJAX(@RequestBody(required=false) String userName) {
		List<User> userList = new ArrayList<User>();		
		if(null != userName && !"".equals(userName)) {
			userList=userService.selectLikeName(userName);
			return userList;
		}else {
			userList = userService.selectAllUser();
			return userList;
		}
	}
	
	@RequestMapping(value = {"/addUserAJAX"})
	@ResponseBody
	public String addUserAJAX(@RequestBody User user) {	
		if(userService.addUser(user) > 0) {
			return "true";
		}
		return "添加用户失败！";
	}
	
	@RequestMapping(value = {"/delUserByIdAJAX"})
	@ResponseBody
	public String delUserByIdAJAX(@RequestBody String userid) {
		Integer userId = Integer.parseInt(userid);
		if(null!=userId && userId>0) {
			if(userService.delUserById(userId)) {
				return "true";
			}
		}
		return "删除用户失败！";
	}
	
	@RequestMapping(value = {"/updUserByIdAJAX"})
	@ResponseBody
	public String updUserByIdAJAX(@RequestBody User user) {
		if(userService.updUserById(user)>0) {
			return "true";
		}
		return "修改用户失败！";
	}
	
	@RequestMapping(value= {"/selectAllUserAJAX"})
	@ResponseBody
	public List<User> selectAllUserAJAX() {
		List<User> userList=new ArrayList<User>();
		userList=userService.selectAllUser();
		if(null==userList||userList.size()==0) {
			return null;
		}
		return userList;
	}

}

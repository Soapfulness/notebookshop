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

import com.wz.notebookstore.model.Manager;
import com.wz.notebookstore.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	/*
	 * @GetMapping(value= {""}) public String managerValueDiv(Model model) {
	 * List<Manager> managerList=new ArrayList<Manager>();
	 * managerList=managerService.selectAll();
	 * if(null==managerList||managerList.size()==0) {
	 * model.addAttribute("","查询失败:没有任何员工"); return ""; }
	 * model.addAttribute("managerList",managerList); return ""; }
	 */
	
	/*
	 * @RequestMapping(value = {"/addManager"}) public String addManager(String
	 * managerName,String managerPassword,int managerValue,Model model) { Manager
	 * manager = new Manager(managerName,managerPassword,managerValue);
	 * if(null!=manager.getManagerName()|| null!=manager.getManagerPassword() ||
	 * null!=(Object)manager.getManagerValue()) {
	 * if(managerService.addManager(manager)>0) { return ""; }
	 * model.addAttribute("errormsg", "添加管理員失败！"); return "/error/errormsg"; }
	 * model.addAttribute("errormsg", "添加管理員失败！"); return "/error/errormsg"; }
	 */
	
	/*
	 * @RequestMapping(value = {""}) public String deleteManagerById(Integer
	 * managerId,Model model) { if(null!=managerId && managerId>0) {
	 * if(managerService.deleteManager(managerId)) {
	 * model.addAttribute("managerId",managerId); return ""; }
	 * model.addAttribute("errormsg", "删除该員工失败！"); return "/error/errormsg"; }
	 * model.addAttribute("errormsg", "删除該員工失败！"); return "/error/errormsg"; }
	 */
	
//	@RequestMapping(value = {"/updateManagerById"})
//	public String updateManagerById(Integer managerId,String managerName,String managerPassword,Integer managerValue,Model model) {
//		Manager manager= new Manager(managerId,managerName,managerPassword,managerValue);	
//		if(managerService.updateManager(manager)>0) {
//			List<Manager> managerList = new ArrayList<Manager>();
//			if(null==managerList || managerList.size()==0) {
//				model.addAttribute("errormsg", "查询失败：没有您要查找的管理員");
//				return "/error/errormsg";
//			}
//			model.addAttribute("managerList",managerList);
//			return "";
//		}
//		model.addAttribute("errormsg", "修改操作失败！");
//		return "/error/errormsg";
//	}

	
	@RequestMapping(value = "/managerRegister")
	public String register(Model model, String userName, String gender, String userTelephone, String userEmail, String userPassword) {	
		return "manager_index";
	}
	
	@RequestMapping(value = "/managerLogout")
	public String logout(HttpSession session) {	
		session.removeAttribute("login");
		return "index";
	}

	
	@RequestMapping(value = {"/managerValueDivAJAX"})
	@ResponseBody
	public List<Manager> managerValueDivAJAX(@RequestBody String managerValue) {
		List<Manager> managerList=new ArrayList<Manager>();
		managerList=managerService.selectAll(Integer.parseInt(managerValue));
		if(null==managerList||managerList.size()==0) {			
			return null;
		}
		return managerList;
	}
	
	
	@RequestMapping(value = {"/deleteManagerByIdAJAX"})
	@ResponseBody
	public String deleteManagerByIdAJAX(@RequestBody String managerid) {
		int managerId = Integer.parseInt(managerid);
		if( managerId>0) {
			if(managerService.deleteManager(managerId)) {
				return "true";
			}
			return "删除失败！";
		}
		return "删除失败！";
	}
	
	@RequestMapping(value = {"/updateManagerByIdAJAX"})
	@ResponseBody
	public String updateManagerByIdAJAX(@RequestBody Manager manager) {	
		if(managerService.updateManager(manager)>0) {
			List<Manager> managerList = new ArrayList<Manager>();
			if(null==managerList || managerList.size()==0) {
				return "修改失败！";
			}
			return "true";
		}
		return "修改失败！";
	}
	
	@RequestMapping(value = {"/addManagerAJAX"})
	@ResponseBody
	public String addManagerAJAX(@RequestBody Manager manager) {	
		if(null!=manager.getManagerName()|| null!=manager.getManagerPassword() || manager.getManagerValue()>=0) {
			if(managerService.addManager(manager)>0) {
				return "true";
			}
			return "添加失败！";
		}
		return "添加失败！";
	}
	
	@RequestMapping(value = {"/selectManagerByNameAJAX"})
	@ResponseBody
	public List<Manager> selectManagerByNameAJAX(@RequestBody(required=false)String managerName) {
		List<Manager> managerList = new ArrayList<Manager>();		
		if(null != managerName && !"".equals(managerName)) {
			managerList=managerService.selectLikeName(managerName);
			return managerList;
		}
		return null;
	}
	
	
	
	
	@RequestMapping(value = {"/updatePasswordById"})
	@ResponseBody
	public String updatePasswordById(@RequestBody Manager manager) {	
		if(managerService.updatePasswordById(manager)) {
			return "{\"data\": \"密码修改成功！\"}";
		}
		return "{\"data\": \"密码修改失败！\"}";
	}
	
	@RequestMapping(value = "/managerLogin")
	public String login(Model model, HttpSession session, String managerName, String managerPassword) {	
		Manager manager = new Manager(0, managerName, managerPassword, 0);
		if(managerService.login(manager)) {
			manager = managerService.selectManByName(managerName);
			session.setAttribute("manager", manager);
			return "manager_index";
		}else {
			model.addAttribute("errormsg", "登陆失败：用户名或密码错误！");
			model.addAttribute("back", "/toManagerLogin");
			model.addAttribute("backmsg", "管理员登陆页面");
			return "error";
		}
	}

}

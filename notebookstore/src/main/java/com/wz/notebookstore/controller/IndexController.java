package com.wz.notebookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	
	
	@RequestMapping(value = "/")
	public String toIndex() {		
		return "index";
	}
	
	@RequestMapping(value = "/toLogin")
	public String toLogin() {		
		return "login";
	}
	
	@RequestMapping(value = "/toRegister")
	public String toRegister() {		
		return "register";
	}
	
	@RequestMapping(value = "/toManagerLogin")
	public String toManagerLogin() {		
		return "manager_login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "index";
	}
	
	@RequestMapping(value = "/contact")
	public String toContact() {		
		return "contact";
	}
	
	@RequestMapping(value = "/wishlist")
	public String toWishList() {		
		return "wishlist";
	}
	
	
	@RequestMapping(value = "/ajaxtest")
	@ResponseBody
	public String ajaxtest(@RequestBody(required = false) String json) {	
		System.out.println("---------------ajax init-----------------");
		if(null != json)
			System.out.println(json);
		return "ok";
	}

}

package com.wz.notebookstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wz.notebookstore.model.Cover;
import com.wz.notebookstore.model.Product;
import com.wz.notebookstore.model.Style;
import com.wz.notebookstore.model.User;
import com.wz.notebookstore.service.PackService;

@Controller
public class PackController {
	
	@Autowired
	private PackService packService;
	
	@RequestMapping(value = "/checkout")
	public String checkout(Model model, String id) {
		Integer userId = Integer.parseInt(id);
		List<Cover> cover = packService.selectCoverByUserId(userId);
		List<Style> style = packService.selectStyleByUserId(userId);
		model.addAttribute("cover", cover);
		model.addAttribute("style", style);
		return "checkout";
	}
	
	@RequestMapping(value = "/addPack")
	public String addPack(Model model, HttpSession session, String product, String id) {
		Integer proId = Integer.parseInt(id);
		User user = (User)session.getAttribute("login");
		if(null == user) {
			model.addAttribute("errormsg","添加商品到购物车失败：必须登陆后操作！");
			model.addAttribute("back", "/toLogin");
			model.addAttribute("backmsg", "登陆页面");
			return "error";
		}
		Integer userId = user.getUserId();
		if(packService.addPack(product, proId, userId)) {
			model.addAttribute("successmsg","商品已经添加到您的购物车中！");
			model.addAttribute("back", "/product?product=all");
			model.addAttribute("backmsg", "浏览商品");
			return "success";
		}
		model.addAttribute("errormsg","添加商品到购物车失败：未知的错误！");
		model.addAttribute("back", "/product?product=all");
		model.addAttribute("backmsg", "浏览商品");
		return "error";
	}
	
	@RequestMapping(value = "/removeProduct")
	@ResponseBody
	public String removeProduct(HttpSession session, @RequestBody Product product) {
		User user = (User)session.getAttribute("login");
		if(null == user) {
			return "{\"data\": \"从购物车移除商品失败：必须登陆后操作！\"}";
		}
		Integer userId = user.getUserId();
		if(packService.removeProduct(product.getProduct(), product.getId(), userId))
			return "{\"data\": \"商品已经从购物车移除啦~\"}";
		return "{\"data\": \"从购物车移除商品失败！\"}";
	}
	
	@RequestMapping(value = "/addPackAJAX")
	@ResponseBody
	public String addPackAJAX(HttpSession session, @RequestBody Product product) {
		User user = (User)session.getAttribute("login");
		if(null == user) {
			return "{\"data\": \"添加商品到购物车失败：必须登陆后操作！\"}";
		}
		Integer userId = user.getUserId();
		if(packService.addPack(product.getProduct(), product.getId(), userId)) {
			return "{\"data\": \"商品已经添加到购物车啦~\"}";
		}
		return "{\"data\": \"添加商品到购物车失败！\"}";
	}
	
	@RequestMapping(value = "/clearPack")
	public String clearPack(Model model, HttpSession session) {
		User user = (User)session.getAttribute("login");
		if(null == user) {
			model.addAttribute("errormsg","清空购物车失败：必须登陆后操作！");
			model.addAttribute("back", "/toLogin");
			model.addAttribute("backmsg", "登陆页面");
			return "error";
		}
		Integer userId = user.getUserId();
		if(packService.clearPack(userId)) {
			return "checkout";
		}
		model.addAttribute("errormsg","清空购物车失败：未知的错误！");
		model.addAttribute("back", "/checkout?id=" + userId);
		model.addAttribute("backmsg", "我的购物车");
		return "error";
	}

}

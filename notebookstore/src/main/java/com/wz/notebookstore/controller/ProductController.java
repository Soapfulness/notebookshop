package com.wz.notebookstore.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wz.notebookstore.model.Cover;
import com.wz.notebookstore.model.Style;
import com.wz.notebookstore.service.CoverService;
import com.wz.notebookstore.service.StyleService;


@Controller
public class ProductController {
	@Autowired
	private CoverService coverService;
	
	@Autowired
	private StyleService styleService;
	
//	@RequestMapping(value = {"/selectAllProduct"})
//	public String  selectAllCover(Model model) {
//		List<Cover> coverList = new ArrayList<Cover>();
//		coverList = coverService.selectAllCover();
//		if(null == coverList || coverList.size() == 0) {
//			model.addAttribute("errormsg", "查询失败：没有任何封面！");
//			model.addAttribute("back", "/");
//			model.addAttribute("backmsg", "首页");
//			return "error";
//		}
//		model.addAttribute("coverList", coverList);
//		List<Style> styleList = new ArrayList<Style>();
//		styleList = styleService.selectAllStyle();
//		if(null == styleList || styleList.size() == 0) {
//			model.addAttribute("errormsg", "查询失败：没有任何内页！");
//			model.addAttribute("back", "/");
//			model.addAttribute("backmsg", "首页");
//			return "error";
//		}
//		model.addAttribute("styleList", coverList);
//		return "";
//	}
//	
//	
//
//	@RequestMapping(value = {"/selectCover"})
//	public String selectCoverByName(Model model,String coverName) {
//		List<Cover> coverList = new ArrayList<Cover>();		
//		if(null != coverName && !"".equals(coverName)) {
//			coverList=coverService.selectCoverByName(coverName);
//			if(null!=coverList && coverList.size()>0) {
//				model.addAttribute("coverList", coverList);
//			}else {
//				model.addAttribute("errormsg", "查询失败：该名字的封面没有，请输入正确的封面名字");
//				return "/error/errormsg";
//			}
//		}else {
//			coverList = coverService.selectAllCover();
//			if(null == coverList || coverList.size() == 0) {
//				model.addAttribute("errormsg", "查询失败:没有任何封面");
//				return "/error/errormsg";
//			}
//			model.addAttribute("coverList", coverList);			
//			return "";
//		}
//		return "";
//	}
//	
//	@RequestMapping(value = {"/selectStyle"})
//	public String selectStyleByName(Model model,String styleName) {
//		List<Style> styleList = new ArrayList<Style>();		
//		if(null != styleName && !"".equals(styleName)) {
//			styleList=styleService.selectStyleByName(styleName);
//			if(null!=styleList && styleList.size()>0) {
//				model.addAttribute("styleList", styleList);
//			}else {
//				model.addAttribute("errormsg", "查询失败：该名字的内页没有，请输入正确的封面名字");
//				return "/error/errormsg";
//			}
//		}else {
//			styleList = styleService.selectAllStyle();
//			if(null == styleList || styleList.size() == 0) {
//				model.addAttribute("errormsg", "查询失败:没有任何内页");
//				return "/error/errormsg";
//			}
//			model.addAttribute("styleList", styleList);			
//			return "";
//		}
//		return "";
//	}
//	
//	@RequestMapping(value = {"/updateCoverById"})
//	public String updateCoverById(Integer coverId,String coverName,String coverColor,String coverSize,String coverImage,Double coverPrice,Model model) {
//		Cover cover= new Cover(coverId,coverName,coverColor,coverSize,coverImage,coverPrice);	
//		if(coverService.updateCoverById(cover)) {
//			List<Cover> coverList = new ArrayList<Cover>();
//			if(null==coverList || coverList.size()==0) {
//				model.addAttribute("errormsg", "查询失败：没有您要查找的封面");
//				return "/error/errormsg";
//			}
//			model.addAttribute("coverList",coverList);
//			return "";
//		}
//		model.addAttribute("errormsg", "修改操作失败！");
//		return "/error/errormsg";
//	}
//	
//	@RequestMapping(value = {"/updateStyleById"})
//	public String updateStyleById(Integer styleId,String styleName,String styleColor,String styleMaterial,String styleImage,Double stylePrice,Model model) {
//		Style style= new Style(styleId,styleName,styleColor,styleMaterial,styleImage,stylePrice);	
//		if(styleService.updateStyleById(style)) {
//			List<Style> styleList = new ArrayList<Style>();
//			if(null==styleList || styleList.size()==0) {
//				model.addAttribute("errormsg", "查询失败：没有您要查找的内页");
//				return "/error/errormsg";
//			}
//			model.addAttribute("styleList",styleList);
//			return "";
//		}
//		model.addAttribute("errormsg", "修改操作失败！");
//		return "/error/errormsg";
//	}
//	
//	@RequestMapping(value = {"/deleteCoverById"})
//	public String deleteCoverById(Integer coverId,Model model) {
//		if(null!=coverId && coverId>0) {
//			if(coverService.deleteCoverById(coverId)) {
//				model.addAttribute("coverId",coverId);
//				return "";
//			}
//			model.addAttribute("errormsg", "删除该封面失败！");
//			return "/error/errormsg";
//		}
//		model.addAttribute("errormsg", "删除操作失败！");
//		return "/error/errormsg";
//	}
//
//	@RequestMapping(value = {"/deleteStyleById"})
//	public String deleteStyleById(Integer styleId,Model model) {
//		if(null!=styleId && styleId>0) {
//			if(coverService.deleteCoverById(styleId)) {
//				model.addAttribute("styleId",styleId);
//				return "";
//			}
//			model.addAttribute("errormsg", "删除该内页失败！");
//			return "/error/errormsg";
//		}
//		model.addAttribute("errormsg", "删除操作失败！");
//		return "/error/errormsg";
//	}
//	
//	@RequestMapping(value = {"/addCover"})
//	public String addCover(String coverName,String coverColor,String coverSize,String coverImage,Double coverPrice,Model model) {
//		Cover cover= new Cover(null,coverName,coverColor,coverSize,coverImage,coverPrice);	
//		if(null!=cover.getCoverName() || null!=cover.getCoverColor() ||  null!=cover.getCoverPrice()) {
//			if(coverService.addCover(cover)) {
//				return "";
//			}
//			model.addAttribute("errormsg", "添加封面失败！");
//			return "/error/errormsg";
//		}
//		model.addAttribute("errormsg", "添加操作失败！");
//		return "/error/errormsg";
//	}
//	
//	@RequestMapping(value = {"/addStyle"})
//	public String addStyle(String styleName,String styleColor,String styleMaterial,String styleImage,Double stylePrice,Model model) {
//		Style style= new Style(null,styleName,styleColor,styleMaterial,styleImage,stylePrice);	
//		if(null!=style.getStyleName() || null!=style.getStyleColor() ||  null!=style.getStylePrice()) {
//			if(styleService.addStyle(style)) {
//				return "";
//			}
//			model.addAttribute("errormsg", "添加封面失败！");
//			return "/error/errormsg";
//		}
//		model.addAttribute("errormsg", "添加操作失败！");
//		return "/error/errormsg";
//	}
	
	//页面传值
	@RequestMapping(value = {"/selectCoverAJAX"})
	@ResponseBody
	public List<Cover>  selectCoverAJAX() {
		List<Cover> coverList = new ArrayList<Cover>();
		coverList = coverService.selectAllCover();
		if(null == coverList || coverList.size() == 0) {
			System.out.println("ERROR!");
			return null;
		}
		return coverList;		
	}
	
	@RequestMapping(value = {"/selectStyleAJAX"})
	@ResponseBody
	public List<Style>  selectStyleAJAX() {
		List<Style> styleList = new ArrayList<Style>();
		styleList = styleService.selectAllStyle();
		if(null == styleList || styleList.size() == 0) {
			System.out.println("ERROR!");
			return null;
		}
		return styleList;		
	}
	
	@RequestMapping(value = {"/updateCoverByIdAJAX"})
	@ResponseBody
	public String updateCoverByIdAJAX(@RequestBody Cover cover) {
		if(coverService.updateCoverById(cover)) {		
			return "true";
		}
		return "修改封面失败！";
	}
	
	@RequestMapping(value = {"/updateStyleByIdAJAX"})
	@ResponseBody
	public String updateStyleByIdAJAX(@RequestBody Style style) {
		if(styleService.updateStyleById(style)) {		
			return "true";
		}
		return "修改内页失败！";
	}
	
	
	@RequestMapping(value = {"/deleteCoverByIdAJAX"})
	@ResponseBody
	public String deleteCoverByIdAJAX(@RequestBody String coverid) {
		int coverId = Integer.parseInt(coverid);
		if(coverId > 0) {
			if(coverService.deleteCoverById(coverId)) {
				return "true";
			}
			return "删除封面失败！";
		}
		return "删除封面失败！";
	}
	
	@RequestMapping(value = {"/deleteStyleByIdAJAX"})
	@ResponseBody
	public String deleteStyleByIdAJAX(@RequestBody String styleid) {
		int styleId = Integer.parseInt(styleid);
		if(styleId > 0) {
			if(styleService.deleteStyleById(styleId)) {
				return "true";
			}
			return "删除内页失败！";
		}
		return "删除内页失败！";
	}
	
	@RequestMapping(value = {"/addCoverAJAX"})
	@ResponseBody
	public String addCoverAJAX(@RequestBody Cover cover) {
		if(null!=cover.getCoverName() || null!=cover.getCoverColor() ||  null!=cover.getCoverPrice()) {
			if(coverService.addCover(cover)) {
				return "true";
			}
			return "添加封面失败！";
		}
		return "添加封面失败！";
	}
	
	@RequestMapping(value = {"/addStyleAJAX"})
	@ResponseBody
	public String addStyleAJAX(@RequestBody Style style) {
		if(null!=style.getStyleName() || null!=style.getStyleColor() ||  null!=style.getStylePrice()) {
			if(styleService.addStyle(style)) {
				return "true";
			}
			return "添加内页失败！";
		}
		return "添加内页失败！";
	}
	
	@RequestMapping(value = {"/selectCoverByNameAJAX"})
	@ResponseBody
	public List<Cover> selectCoverByName(@RequestBody(required=false) String coverName) {
		List<Cover> coverList = new ArrayList<Cover>();		
		if(null != coverName && !"".equals(coverName)) {
			coverList=coverService.selectCoverByName(coverName);
			if(null!=coverList && coverList.size()>0) {
				return coverList;
			}else {
				return null;
			}
		}else {
			coverList = coverService.selectAllCover();
			if(null == coverList || coverList.size() == 0) {
				return null;
			}	
			return coverList;
		}
	}
	
	/***********************************************/
	
	@RequestMapping(value = "/indexAJAX")
	@ResponseBody
	public List<Cover> indexAJAX(){
		List<Cover> all = coverService.selectAllCover();
		int size = all.size();
		List<Cover> cover = new ArrayList<Cover>();
		boolean[] flag = new boolean[size];
		int index = 0;
		for(int i = 0; i < size && i < 8; i++) {
			do {
				index = (int)(Math.random() * size);
			}while(flag[index]);
			flag[index] = true;
			cover.add(all.get(index));
		}
		return cover;
	}
	
	@RequestMapping(value = "/single")
	public String single(Model model, String product, @RequestParam(required = false) String id) {
		switch(product) {
			case "cover": 
				Cover cover = coverService.selectCoverById(Integer.parseInt(id));
				model.addAttribute("type", "cover");
				model.addAttribute("single", cover);
				break;
			case "style":
				Style style = styleService.selectStyleById(Integer.parseInt(id));
				model.addAttribute("type", "style");
				model.addAttribute("single", style);
				break;
			default:
				model.addAttribute("errormsg", "参数错误：未知的商品类型！");
				model.addAttribute("back", "/product?product=all");
				model.addAttribute("backmsg", "浏览商品");
				return "error";
		}
		return "single";
	}
	
	@RequestMapping(value = "/product")
	public String product(Model model, String product, @RequestParam(required = false) String type,  @RequestParam(required = false) String data) {
		List<Cover> cover = new ArrayList<Cover>();
		List<Style> style = new ArrayList<Style>();
		switch(product) {
			case "cover": 
				switch(type) {
					case "color":
						cover = coverService.selectCoverByColor(data);
						break;
					case "size":
						cover = coverService.selectCoverBySize(data);
						break;
					case "price":
						switch(data) {
							case "19l":
								cover = coverService.selectCoverByPrice(0.0, 19.0);
								break;
							case "19m49l":
								cover = coverService.selectCoverByPrice(19.0, 49.0);
								break;
							case "49m99l":
								cover = coverService.selectCoverByPrice(49.0, 99.0);
								break;
							case "99m199l":
								cover = coverService.selectCoverByPrice(99.0, 199.0);
								break;
							case "199m":
								cover = coverService.selectCoverByPrice(199.0, 99999.0);
								break;
							default:
								model.addAttribute("errormsg", "参数错误：未知的价格区间！");
								model.addAttribute("back", "/product?product=all");
								model.addAttribute("backmsg", "浏览商品");
								return "error";
						}
						break;
					default:
						model.addAttribute("errormsg", "参数错误：未知的搜索类型！");
						model.addAttribute("back", "/product?product=all");
						model.addAttribute("backmsg", "浏览商品");
						return "error";
				}
				model.addAttribute("type", "cover");
				model.addAttribute("product", cover);
				break;
			case "style":
				switch(type) {
					case "color":
						style = styleService.selectStyleByColor(data);
						break;
					case "material":
						style = styleService.selectStyleByMaterial(data);
						break;
					case "price":
						switch(data) {
							case "19l":
								style = styleService.selectStyleByPrice(0.0, 1.9);
								break;
							case "19m49l":
								style = styleService.selectStyleByPrice(1.9, 4.9);
								break;
							case "49m99l":
								style = styleService.selectStyleByPrice(4.9, 9.9);
								break;
							case "99m199l":
								style = styleService.selectStyleByPrice(9.9, 19.9);
								break;
							case "199m":
								style = styleService.selectStyleByPrice(19.9, 9999.9);
								break;
							default:
								model.addAttribute("errormsg", "参数错误：未知的价格区间！");
								model.addAttribute("back", "/product?product=all");
								model.addAttribute("backmsg", "浏览商品");
								return "error";
						}
						break;
					default:
						model.addAttribute("errormsg", "参数错误：未知的搜索类型！");
						model.addAttribute("back", "/product?product=all");
						model.addAttribute("backmsg", "浏览商品");
						return "error";
				}
				model.addAttribute("type", "style");
				model.addAttribute("product", style);
				break;
			case "all":
				cover = coverService.selectAllCover();
				style = styleService.selectAllStyle();
				model.addAttribute("type", "all");
				model.addAttribute("cover", cover);
				model.addAttribute("style", style);
				break;
			default:
				model.addAttribute("errormsg", "参数错误：未知的商品类型！");
				model.addAttribute("back", "/product?product=all");
				model.addAttribute("backmsg", "浏览商品");
				return "error";
		}
		return "product";
	}
}

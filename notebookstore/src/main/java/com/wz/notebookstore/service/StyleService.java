package com.wz.notebookstore.service;

import java.util.List;

import com.wz.notebookstore.model.Style;


public interface StyleService {
	//查询所有内页的方法
	List<Style> selectAllStyle();
	
	//通过名字查找内页的方法
	List<Style> selectStyleByName(String styleName);
	
	//通过id修改内页信息的方法
	boolean updateStyleById(Style style);
		
	//通过id删除内页信息的方法
	boolean deleteStyleById(Integer styleId);
	
	//添加封面
	boolean addStyle(Style style);
	
	
	
	Style selectStyleById(Integer styleId);
	
	List<Style> selectStyleByColor(String styleColor);
	
	List<Style> selectStyleByMaterial(String styleMaterial);
	
	List<Style> selectStyleByPrice(Double min, Double max);
}

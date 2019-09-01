package com.wz.notebookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.wz.notebookstore.model.Style;

//内页
@Mapper
public interface StyleDao {
	//查询所有内页的方法
	@SelectProvider(type=StyleProvider.class,method="selectAllStyle")
	List<Style> seclectAllStyle();
		
	//通过名字查找封面的方法
	@SelectProvider(type=StyleProvider.class,method="selectStyleByName")
	List<Style> selectStyleByName(String styleName);
	
	//通过id修改内页信息的方法
	@UpdateProvider(type=StyleProvider.class,method="updateStyleById")
	Integer updateStyleById(Style style);
	
	//通过id修改内页信息的方法
	@DeleteProvider(type=StyleProvider.class,method="deleteStyleById")
	Integer deleteStyleById(Integer styleId);
	
	//添加内页的方法
	@InsertProvider(type=StyleProvider.class,method="addStyle")
	Integer addStyle(Style style);
	
	
	
	@SelectProvider(type=StyleProvider.class,method="selectStyleById")
	Style selectStyleById(Integer styleId);
	
	@SelectProvider(type=StyleProvider.class,method="selectStyleByColor")
	List<Style> selectStyleByColor(String styleColor);
	
	@SelectProvider(type=StyleProvider.class,method="selectStyleByMaterial")
	List<Style> selectStyleByMaterial(String styleMaterial);
	
	@SelectProvider(type=StyleProvider.class,method="selectStyleByPrice")
	List<Style> selectStyleByPrice(Double min, Double max);
}

package com.wz.notebookstore.dao;

import org.apache.ibatis.jdbc.SQL;

import com.wz.notebookstore.model.Style;

public class StyleProvider {
	public String selectAllStyle() {
		SQL sql=new SQL();
		sql.SELECT("style_id styleId,style_name styleName,style_color styleColor,style_material styleMaterial,style_image styleImage,style_price stylePrice");
		sql.FROM("style");
		return sql.toString();
	}
	
	public String selectStyleByName(String styleName) {
		SQL sql=new SQL();
		sql.SELECT("style_id styleId,style_name styleName,style_color styleColor,style_material styleMaterial,style_image styleImage,style_price stylePrice");
		sql.FROM("style");
		sql.WHERE("style_name LIKE CONCAT('%', '#{styleName}', '%')");
		return sql.toString();
	}
	
	public String updateStyleById(Style style) {
		SQL sql=new SQL();
		sql.UPDATE("style");
		if(null!=style.getStyleName() && style.getStyleName().trim().length()>0) {
			sql.SET("style_name = '" + style.getStyleName() + "'");
		}
		if(null!=style.getStyleColor() && style.getStyleName().trim().length()>0) {
			sql.SET("style_color = '" + style.getStyleColor() + "'");
		}
		if(null!=style.getStyleMaterial() && style.getStyleMaterial().trim().length()>0) {
			sql.SET("style_material = '" + style.getStyleMaterial() + "'");
		}
		if(null!=style.getStyleImage() && style.getStyleImage().trim().length()>0) {
			sql.SET("style_image = '" + style.getStyleImage() + "'");
		}
		if(null!=style.getStylePrice() && style.getStylePrice()>0) {
			sql.SET("style_price = '" + style.getStylePrice() + "'");
		}	
		sql.WHERE("style_id = " + style.getStyleId());
		return sql.toString();
	}
	
	public String deleteStyleById(Integer styleId) {
		SQL sql=new SQL();
		sql.DELETE_FROM("style");
		sql.WHERE("style_id = #{styleId}");
		return sql.toString();
	}

	public String addStyle(Style style) {
		SQL sql=new SQL();
		sql.INTO_COLUMNS("style_name,style_color,style_material,style_image,style_price");
		sql.INSERT_INTO("style");
		sql.INTO_VALUES(" #{styleName}, #{styleColor}, #{styleMaterial},#{styleImage},#{stylePrice}");
		return sql.toString();
	}
	
	
	
	public String selectStyleById(Integer styleId) {
		SQL sql=new SQL();
		sql.SELECT("style_id styleId,style_name styleName,style_color styleColor,style_material styleMaterial,style_image styleImage,style_price stylePrice");
		sql.FROM("style");
		sql.WHERE("style_id = " + styleId);
		return sql.toString();
	}
	
	public String selectStyleByColor(String styleColor) {
		SQL sql=new SQL();
		sql.SELECT("style_id styleId,style_name styleName,style_color styleColor,style_material styleMaterial,style_image styleImage,style_price stylePrice");
		sql.FROM("style");
		sql.WHERE("style_color = '" + styleColor + "'");
		return sql.toString();
	}
	
	public String selectStyleByMaterial(String styleMaterial) {
		SQL sql=new SQL();
		sql.SELECT("style_id styleId,style_name styleName,style_color styleColor,style_material styleMaterial,style_image styleImage,style_price stylePrice");
		sql.FROM("style");
		sql.WHERE("style_material = '" + styleMaterial + "'");
		return sql.toString();
	}
	
	public String selectStyleByPrice(Double min, Double max) {
		SQL sql=new SQL();
		sql.SELECT("style_id styleId,style_name styleName,style_color styleColor,style_material styleMaterial,style_image styleImage,style_price stylePrice");
		sql.FROM("style");
		sql.WHERE("style_price >= " + min + " and style_price < " + max);
		return sql.toString();
	}
}

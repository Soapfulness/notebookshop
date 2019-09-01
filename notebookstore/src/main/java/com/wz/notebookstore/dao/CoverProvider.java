package com.wz.notebookstore.dao;

import org.apache.ibatis.jdbc.SQL;

import com.wz.notebookstore.model.Cover;

public class CoverProvider {
	public String selectAllCover() {
		SQL sql=new SQL();
		sql.SELECT("cover_id coverId,cover_name coverName,cover_color coverColor,cover_size coverSize,cover_image coverImage,cover_price coverPrice");
		sql.FROM("cover");
		return sql.toString();
	}
	
	public String selectCoverByName(String coverName) {
		SQL sql=new SQL();
		sql.SELECT("cover_id coverId,cover_name coverName,cover_color coverColor,cover_size coverSize,cover_image coverImage,cover_price coverPrice");
		sql.FROM("cover");
		sql.WHERE("cover_name LIKE '%" + coverName + "%'");
		return sql.toString();
	}
	
	public String updateCoverById(Cover cover) {
		SQL sql=new SQL();
		sql.UPDATE("cover");
		if(null!=cover.getCoverName() && !"".equals(cover.getCoverName())) {
			sql.SET("cover_name = '" + cover.getCoverName() + "'");
		}
		if(null!=cover.getCoverColor() && !"".equals(cover.getCoverColor())) {
			sql.SET("cover_color = '" + cover.getCoverColor() + "'");
		}
		if(null!=cover.getCoverSize() && !"".equals(cover.getCoverSize())) {
			sql.SET("cover_size = '" + cover.getCoverSize()+ "'");
		}
		if(null!=cover.getCoverImage() && !"".equals(cover.getCoverImage())) {
			sql.SET("cover_image = '" + cover.getCoverImage()+ "'");
		}
		if(null!=cover.getCoverPrice() && cover.getCoverPrice() > 0) {
			sql.SET("cover_price = '" + cover.getCoverPrice()+ "'");
		}	
		sql.WHERE("cover_id = " + cover.getCoverId());
		return sql.toString();
	}
	
	public String deleteCoverById(Integer coverId) {
		SQL sql=new SQL();
		sql.DELETE_FROM("cover");
		sql.WHERE("cover_id=#{coverId}");
		return sql.toString();
	}
	
	public String addCover(Cover cover) {
		SQL sql=new SQL();
		sql.INTO_COLUMNS("cover_name,cover_color,cover_size,cover_image,cover_price");
		sql.INSERT_INTO("cover");
		sql.INTO_VALUES(" #{coverName}, #{coverColor}, #{coverSize},#{coverImage},#{coverPrice}");
		return sql.toString();
	}
	
	/**********************************************/
	
	public String selectCoverById(Integer coverId) {
		SQL sql=new SQL();
		sql.SELECT("cover_id coverId,cover_name coverName,cover_color coverColor,cover_size coverSize,cover_image coverImage,cover_price coverPrice");
		sql.FROM("cover");
		sql.WHERE("cover_id = " + coverId);
		return sql.toString();
	}
	
	public String selectCoverByColor(String coverColor) {
		SQL sql=new SQL();
		sql.SELECT("cover_id coverId,cover_name coverName,cover_color coverColor,cover_size coverSize,cover_image coverImage,cover_price coverPrice");
		sql.FROM("cover");
		sql.WHERE("cover_color = '" + coverColor + "'");
		return sql.toString();
	}
	
	public String selectCoverBySize(String coverSize) {
		SQL sql=new SQL();
		sql.SELECT("cover_id coverId,cover_name coverName,cover_color coverColor,cover_size coverSize,cover_image coverImage,cover_price coverPrice");
		sql.FROM("cover");
		sql.WHERE("cover_size = '" + coverSize + "'");
		return sql.toString();
	}
	
	public String selectCoverByPrice(Double min, Double max) {
		SQL sql=new SQL();
		sql.SELECT("cover_id coverId,cover_name coverName,cover_color coverColor,cover_size coverSize,cover_image coverImage,cover_price coverPrice");
		sql.FROM("cover");
		sql.WHERE("cover_price >= " + min + " and cover_price < " + max);
		return sql.toString();
	}

}

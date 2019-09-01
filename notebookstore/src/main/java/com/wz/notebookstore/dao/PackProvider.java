package com.wz.notebookstore.dao;

import org.apache.ibatis.jdbc.SQL;

import com.wz.notebookstore.model.Pack;

public class PackProvider {
	
	public String selectCoverIdByUserId(Integer userId) {
		SQL sql=new SQL();
		sql.SELECT("pack_cover_id packCoverId");
		sql.FROM("pack");
		sql.WHERE("pack_user_id = " + userId + " and pack_style_id = 0");
		return sql.toString();
	}
	
	public String selectStyleIdByUserId(Integer userId) {
		SQL sql=new SQL();
		sql.SELECT("pack_style_id packStyleId");
		sql.FROM("pack");
		sql.WHERE("pack_user_id = " + userId + " and pack_cover_id = 0");
		return sql.toString();
	}
	
	public String addPack(Pack pack) {
		SQL sql=new SQL();
		sql.INTO_COLUMNS("pack_user_id, pack_cover_id, pack_style_id, pack_init_date");
		sql.INSERT_INTO("pack");
		sql.INTO_VALUES("#{packUserId}, #{packCoverId}, #{packStyleId}, #{packInitDate}");
		return sql.toString();
	}
	
	public String removeProduct(Integer userId, Integer styleId, Integer coverId) {
		SQL sql=new SQL();
		sql.DELETE_FROM("pack");
		sql.WHERE("pack_user_id = #{userId} and pack_style_id = #{styleId} and pack_cover_id = #{coverId}");
		return sql.toString();
	}
	
	public String clearPack(Integer userId) {
		SQL sql=new SQL();
		sql.DELETE_FROM("pack");
		sql.WHERE("pack_user_id = #{userId}");
		return sql.toString();
	}

}

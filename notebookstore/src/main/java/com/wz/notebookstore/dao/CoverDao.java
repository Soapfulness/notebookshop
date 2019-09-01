package com.wz.notebookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.wz.notebookstore.model.Cover;

//封面
@Mapper
public interface CoverDao {
	//查询所有封面的方法
	@SelectProvider(type=CoverProvider.class,method="selectAllCover")
	List<Cover> seclectAllCover();
	
	
	//通过名字查找封面的方法
	@SelectProvider(type=CoverProvider.class,method="selectCoverByName")
	List<Cover> selectCoverByName(String coverName);
	
	//通过id修改封面信息的方法
	@UpdateProvider(type=CoverProvider.class,method="updateCoverById")
	Integer updateCoverById(Cover cover);
	
	//通过id修改封面信息的方法
	@DeleteProvider(type=CoverProvider.class,method="deleteCoverById")
	Integer deleteCoverById(Integer coverId);
	
	//添加封面的方法
	@InsertProvider(type=CoverProvider.class,method="addCover")
	Integer addCover(Cover cover);
	
	
	
	@SelectProvider(type=CoverProvider.class,method="selectCoverById")
	Cover selectCoverById(Integer coverId);
	
	@SelectProvider(type=CoverProvider.class,method="selectCoverByColor")
	List<Cover> selectCoverByColor(String coverColor);
	
	@SelectProvider(type=CoverProvider.class,method="selectCoverBySize")
	List<Cover> selectCoverBySize(String coverSize);
	
	@SelectProvider(type=CoverProvider.class,method="selectCoverByPrice")
	List<Cover> selectCoverByPrice(Double min, Double max);
}

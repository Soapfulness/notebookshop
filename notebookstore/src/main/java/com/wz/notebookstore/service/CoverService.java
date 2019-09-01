package com.wz.notebookstore.service;

import java.util.List;

import com.wz.notebookstore.model.Cover;

public interface CoverService {
	//通过名字查找封面的方法
	List<Cover> selectAllCover();
	
	//通过名字查找封面的方法
	List<Cover> selectCoverByName(String coverName);
	
	//通过id修改封面信息的方法
	boolean updateCoverById(Cover cover);
	
	//通过id删除封面信息的方法
	boolean deleteCoverById(Integer coverId);
	
	//添加封面
	boolean addCover(Cover cover);
	
	
	
	Cover selectCoverById(Integer coverId);
	List<Cover> selectCoverByColor(String coverColor);
	List<Cover> selectCoverBySize(String coverSize);
	List<Cover> selectCoverByPrice(Double min, Double max);

}

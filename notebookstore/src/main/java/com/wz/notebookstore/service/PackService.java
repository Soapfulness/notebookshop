package com.wz.notebookstore.service;

import java.util.List;

import com.wz.notebookstore.model.Cover;
import com.wz.notebookstore.model.Style;

public interface PackService {
	
	List<Cover> selectCoverByUserId(Integer userId);
	List<Style> selectStyleByUserId(Integer userId);
	boolean addPack(String product, Integer proId, Integer userId);
	boolean removeProduct(String product, Integer proId, Integer userId);
	boolean clearPack(Integer userId);

}

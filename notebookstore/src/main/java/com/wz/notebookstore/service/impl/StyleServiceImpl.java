package com.wz.notebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wz.notebookstore.dao.StyleDao;
import com.wz.notebookstore.model.Style;
import com.wz.notebookstore.service.StyleService;

@Service
public class StyleServiceImpl implements StyleService {

	@Autowired
	private StyleDao styleDao;
	
	@Override
	public List<Style> selectAllStyle() {
	
		return styleDao.seclectAllStyle();
	}

	@Override
	public List<Style> selectStyleByName(String styleName) {
		
		return styleDao.selectStyleByName(styleName);
	}

	@Override
	public boolean updateStyleById(Style style) {
		if(styleDao.updateStyleById(style) > 0)
	    	return true;
		return false;
	}

	@Override
	public boolean deleteStyleById(Integer styleId) {
		if(styleDao.deleteStyleById(styleId)>0)
			return true;
		return false;
	}

	@Override
	public boolean addStyle(Style style) {
		if(styleDao.addStyle(style) > 0)
	    	return true;
		return false;
	}
	
	
	

	@Override
	public Style selectStyleById(Integer styleId) {
		return styleDao.selectStyleById(styleId);
	}

	@Override
	public List<Style> selectStyleByColor(String styleColor) {
		return styleDao.selectStyleByColor(styleColor);
	}

	@Override
	public List<Style> selectStyleByMaterial(String styleMaterial) {
		return styleDao.selectStyleByMaterial(styleMaterial);
	}

	@Override
	public List<Style> selectStyleByPrice(Double min, Double max) {
		// TODO Auto-generated method stub
		return styleDao.selectStyleByPrice(min, max);
	}

}

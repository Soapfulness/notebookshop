package com.wz.notebookstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.notebookstore.dao.CoverDao;
import com.wz.notebookstore.dao.PackDao;
import com.wz.notebookstore.dao.StyleDao;
import com.wz.notebookstore.model.Cover;
import com.wz.notebookstore.model.Pack;
import com.wz.notebookstore.model.Style;
import com.wz.notebookstore.service.PackService;

@Service
public class PackServiceImpl implements PackService {
	
	@Autowired
	private CoverDao coverDao;
	
	@Autowired
	private StyleDao styleDao;
	
	@Autowired
	private PackDao packDao;

	@Override
	public List<Cover> selectCoverByUserId(Integer userId) {
		List<Integer> coverId = packDao.selectCoverIdByUserId(userId);
		List<Cover> cover = new ArrayList<Cover>();
		int size = coverId.size();
		for(int i = 0; i < size; i++) {
			cover.add(coverDao.selectCoverById(coverId.get(i)));
		}
		return cover;
	}

	@Override
	public List<Style> selectStyleByUserId(Integer userId) {
		List<Integer> styleId = packDao.selectStyleIdByUserId(userId);
		List<Style> style = new ArrayList<Style>();
		int size = styleId.size();
		for(int i = 0; i < size; i++) {
			style.add(styleDao.selectStyleById(styleId.get(i)));
		}
		return style;
	}

	@Override
	public boolean addPack(String product, Integer proId, Integer userId) {
		Pack pack = null;
		switch(product) {
			case "cover":
				pack = new Pack(0, userId, proId, 0, new Date());
				break;
			case "style":
				pack = new Pack(0, userId, 0, proId, new Date());
				break;
			default:
				return false;
		}
		if(packDao.addPack(pack) > 0)
			return true;
		return false;
	}

	@Override
	public boolean removeProduct(String product, Integer proId, Integer userId) {
		Integer styleId;
		Integer coverId;
		switch(product) {
			case "cover":
				coverId = proId;
				styleId = 0;
				break;
			case "style":
				styleId = proId;
				coverId = 0;
				break;
			default:
				return false;
		}
		if(packDao.removeProduct(userId, styleId, coverId) > 0)
			return true;
		return false;
	}

	@Override
	public boolean clearPack(Integer userId) {
		if(packDao.clearPack(userId) > 0)
			return true;
		return false;
	}

}

package com.wz.notebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.notebookstore.dao.CoverDao;
import com.wz.notebookstore.model.Cover;
import com.wz.notebookstore.service.CoverService;

@Service
public class CoverServiceImpl implements CoverService{
	@Autowired
	private CoverDao coverDao;

	@Override
	public List<Cover> selectAllCover() {
		return coverDao.seclectAllCover();
	}

	@Override
	public List<Cover> selectCoverByName(String coverName) {
		
		return coverDao.selectCoverByName(coverName);
	}

	@Override
	public boolean updateCoverById(Cover cover) {		
	    if(coverDao.updateCoverById(cover) > 0)
	    	return true;
		return false;
	}

	@Override
	public boolean deleteCoverById(Integer coverId) {
		if(coverDao.deleteCoverById(coverId)>0)
			return true;
		return false;
	}

	@Override
	public boolean addCover(Cover cover) {
		if(coverDao.addCover(cover) > 0)
	    	return true;
		return false;
	}
	
	

	@Override
	public Cover selectCoverById(Integer coverId) {
		return coverDao.selectCoverById(coverId);
	}

	@Override
	public List<Cover> selectCoverByColor(String coverColor) {
		return coverDao.selectCoverByColor(coverColor);
	}

	@Override
	public List<Cover> selectCoverBySize(String coverSize) {
		return coverDao.selectCoverBySize(coverSize);
	}

	@Override
	public List<Cover> selectCoverByPrice(Double min, Double max) {
		return coverDao.selectCoverByPrice(min, max);
	}

}

package com.wz.notebookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.wz.notebookstore.model.Pack;

@Mapper
public interface PackDao {
	
	@SelectProvider(type=PackProvider.class,method="selectCoverIdByUserId")
	List<Integer> selectCoverIdByUserId(Integer userId);
	
	@SelectProvider(type=PackProvider.class,method="selectStyleIdByUserId")
	List<Integer> selectStyleIdByUserId(Integer userId);
	
	@InsertProvider(type=PackProvider.class,method="addPack")
	Integer addPack(Pack pack);
	
	@DeleteProvider(type=PackProvider.class,method="removeProduct")
	Integer removeProduct(Integer userId, Integer styleId, Integer coverId);
	
	@DeleteProvider(type=PackProvider.class,method="clearPack")
	Integer clearPack(Integer userId);

}

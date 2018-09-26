package com.lmt.dao;

import java.util.List;

import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface PetOwnerDao {
	
	List<PetOwner> getAllOwner() throws Exception;//查询所有宠物主人信息
	
	PetOwner selectOwner(String username, String password)throws Exception; // 根据查询条件查询宠物主人信息

	List<Pet> getListMyPet(PetOwner pet)throws Exception;//展示我的宠物列表

	void upadae(Pet pet) throws Exception;//卖出时更新宠物信息

}

package com.lmt.dao;

import java.util.List;

import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface PetDao {
	List<Pet> getAllPet() throws Exception;//查询所有宠物信息

	List<Pet> getPetsInStock(int storeId)throws Exception;//显示库存宠物

	void update(Pet pet) throws Exception;//购买时更新宠物信息
}

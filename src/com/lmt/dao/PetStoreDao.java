package com.lmt.dao;

import java.util.List;

import com.lmt.domain.PetStore;

public interface PetStoreDao {
	List<PetStore> getAllStore() throws Exception;//查询所有宠物商店的信息
}

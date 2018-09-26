package com.lmt.dao;

import java.util.List;

import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface PetDao {
	List<Pet> getAllPet() throws Exception;//��ѯ���г�����Ϣ

	List<Pet> getPetsInStock(int storeId)throws Exception;//��ʾ������

	void update(Pet pet) throws Exception;//����ʱ���³�����Ϣ
}

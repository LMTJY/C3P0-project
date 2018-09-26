package com.lmt.dao;

import java.util.List;

import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface PetOwnerDao {
	
	List<PetOwner> getAllOwner() throws Exception;//��ѯ���г���������Ϣ
	
	PetOwner selectOwner(String username, String password)throws Exception; // ���ݲ�ѯ������ѯ����������Ϣ

	List<Pet> getListMyPet(PetOwner pet)throws Exception;//չʾ�ҵĳ����б�

	void upadae(Pet pet) throws Exception;//����ʱ���³�����Ϣ

}

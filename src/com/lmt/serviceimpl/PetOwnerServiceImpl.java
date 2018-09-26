package com.lmt.serviceimpl;

import java.util.List;

import com.lmt.dao.AccountDao;
import com.lmt.dao.PetDao;
import com.lmt.dao.PetOwnerDao;
import com.lmt.dao.PetStoreDao;
import com.lmt.daoimpl.AccountDaoImpl;
import com.lmt.daoimpl.PetDaoImpl;
import com.lmt.daoimpl.PetOwnerDaoImpl;
import com.lmt.daoimpl.PetStoreDaoImpl;
import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;
import com.lmt.service.PetOwnerService;
/**
 * �������˷�����
 * @author 
 *
 */
public class PetOwnerServiceImpl implements PetOwnerService{
	/**
	 * ��������
	 */
	@Override
	public Pet breed(String petType) {
		
		return null;
	}
/**
 * ����
 * @throws Exception 
 */
	@Override
	public int getAccount(Account account,Pet pet) throws Exception {
		AccountDao accountDao = new AccountDaoImpl();
		return accountDao.update(account,pet);
	}
	/**
	 * �������
	 * @throws Exception 
	 */
	@Override
	public void buy(Pet pet) throws Exception {
		PetDao petDao = new PetDaoImpl();
		petDao.update(pet);
	}
/**
 * ��������
 * @throws Exception 
 */
	@Override
	public void sell(Pet pet) throws Exception {
		PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
		petOwnerDao.upadae(pet);
	}
	/**
	 *��ʾ������
	 */
	@Override
	public List<Pet> getPetsInStock(int storeId) throws Exception {
		PetDao petDao = new PetDaoImpl();
		return petDao.getPetsInStock(storeId);
	}
	/**
	 * ��ʾ����������
	 */
	@Override
	public List<Pet> getPetBreed(int storeId) throws Exception{
		return null;
	}
/**
 * ������Ŀ��Ϣ
 */
	@Override
	public void charge(Pet pet) {
		// TODO Auto-generated method stub
		
	}
/**
 * ��¼ģʽ
 */
	
@Override
public PetOwner login(String username, String password) throws Exception {
	PetOwnerDao petOwner = new PetOwnerDaoImpl();
	return petOwner.selectOwner(username, password);
}
/**
 * չʾ�ҵĳ����б�
 * @throws Exception 
 */
	public List<Pet> listMyPet(PetOwner pet) throws Exception {
		PetOwnerDao petOwner = new PetOwnerDaoImpl();
		return petOwner.getListMyPet(pet);
	}

}

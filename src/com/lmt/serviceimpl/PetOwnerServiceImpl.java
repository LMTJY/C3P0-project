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
 * 宠物主人服务功能
 * @author 
 *
 */
public class PetOwnerServiceImpl implements PetOwnerService{
	/**
	 * 抚养宠物
	 */
	@Override
	public Pet breed(String petType) {
		
		return null;
	}
/**
 * 结账
 * @throws Exception 
 */
	@Override
	public int getAccount(Account account,Pet pet) throws Exception {
		AccountDao accountDao = new AccountDaoImpl();
		return accountDao.update(account,pet);
	}
	/**
	 * 购买宠物
	 * @throws Exception 
	 */
	@Override
	public void buy(Pet pet) throws Exception {
		PetDao petDao = new PetDaoImpl();
		petDao.update(pet);
	}
/**
 * 卖出宠物
 * @throws Exception 
 */
	@Override
	public void sell(Pet pet) throws Exception {
		PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
		petOwnerDao.upadae(pet);
	}
	/**
	 *显示库存宠物
	 */
	@Override
	public List<Pet> getPetsInStock(int storeId) throws Exception {
		PetDao petDao = new PetDaoImpl();
		return petDao.getPetsInStock(storeId);
	}
	/**
	 * 显示新培育宠物
	 */
	@Override
	public List<Pet> getPetBreed(int storeId) throws Exception{
		return null;
	}
/**
 * 更新账目信息
 */
	@Override
	public void charge(Pet pet) {
		// TODO Auto-generated method stub
		
	}
/**
 * 登录模式
 */
	
@Override
public PetOwner login(String username, String password) throws Exception {
	PetOwnerDao petOwner = new PetOwnerDaoImpl();
	return petOwner.selectOwner(username, password);
}
/**
 * 展示我的宠物列表
 * @throws Exception 
 */
	public List<Pet> listMyPet(PetOwner pet) throws Exception {
		PetOwnerDao petOwner = new PetOwnerDaoImpl();
		return petOwner.getListMyPet(pet);
	}

}

package com.lmt.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.lmt.dao.PetDao;
import com.lmt.dao.PetOwnerDao;
import com.lmt.dao.PetStoreDao;
import com.lmt.daoimpl.PetDaoImpl;
import com.lmt.daoimpl.PetOwnerDaoImpl;
import com.lmt.daoimpl.PetStoreDaoImpl;
import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;
import com.lmt.service.PetOwnerService;
import com.lmt.serviceimpl.PetOwnerServiceImpl;

public class TestOwner {
	PetOwner petO = new PetOwner();
	PetStore petS = new PetStore();
	Account account = new Account();
	PetOwnerDao  petOwner = new PetOwnerDaoImpl();
	PetStoreDao petStore = new PetStoreDaoImpl();
	/**
	 * 启动程序
	 * 获取相关信息并输出，提示选择登录模式
	 * @throws Exception 
	 */
	@Test
	public void startPetShop() throws Exception {
		PetDao pet= new PetDaoImpl();
		
		System.out.println("Womderland醒来,所有宠物从sqlServer中醒来");
		System.out.println("****************************************");
		System.out.println("序号\t宠物名称");
		List<Pet> allPet = pet.getAllPet();
		for (Pet pet2 : allPet) {
			System.out.println(pet2.getId()+"\t"+pet2.getName());
		}
		System.out.println("****************************************\n");
		System.out.println("所有宠物主人从Sqlserver中醒来");
		System.out.println("****************************************");
		System.out.println("序号\t主人姓名");
		List<PetOwner> allOwner = petOwner.getAllOwner();
		for (PetOwner petOwner2 : allOwner) {
			System.out.println(petOwner2.getId()+"\t"+petOwner2.getName());
		}
		System.out.println("****************************************\n");
		System.out.println("所有宠物从Sqlserver中醒来");
		System.out.println("****************************************");
		System.out.println("序号\t宠物商店名称");
		List<PetStore> allStore = petStore.getAllStore();
		for (PetStore petStore1 : allStore) {
			System.out.println(petStore1.getId()+"\t"+petStore1.getName());
		}
		System.out.println("****************************************\n");
		System.out.println("请选择输入登录模式，输入1为宠物主人登录，输入2为宠物商店登录");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		if(choose==1) {
			ownerLogin();
		}
	}
	/**
	 * 宠物主人登录
	 * @throws Exception 
	 */
	@Test
	public void ownerLogin() throws Exception {
		PetOwner login;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("请先登录，请您输入主人的名字：");
			String username = sc.next();
			System.out.println("请您输入主人的密码");
			String password = sc.next();
			PetOwnerService petOwner = new PetOwnerServiceImpl();
			login = petOwner.login(username,password);
		}while((login==null));
			petO.setId(login.getId());
			System.out.println("-----------------恭喜您登录成功------------------");
			System.out.println("--—--------------您的基本信息：------------------");
			System.out.print("名字："+login.getName());
			System.out.print("元宝数："+login.getMoney()+"\n");
			System.out.println("登录成功，您可以购买和卖出宠物，如果您要购买宠物请选择1，想要卖出请选择2");
			System.out.println("1:购买宠物\n2:卖出宠物");
			int choose = sc.nextInt();
			if(choose==1) {
				ownerBuy();
			}else if(choose==2){
				ownerSell();
			}else {
				System.out.println("输入错误，退出系统");
				System.exit(1);
			}		
	}
	/**
	 * 宠物主人购买宠物
	 * @throws Exception 
	 */
	@Test
	public void ownerBuy() throws Exception {
		account.setDeal_type(1);
		Scanner sc = new Scanner(System.in);
		PetOwnerService petOwner = new PetOwnerServiceImpl();
		System.out.println("-------请输入要购买的范围：只输入选择项的序号-------");
		System.out.println("1:购买库存\n2:购买新培育宠物");
		int choose = sc.nextInt();
		if(choose==1) {
			System.out.println("请输入商店ID");
			int storeId = sc.nextInt();
			System.out.println("-----------以下是库存宠物--------------");
			System.out.println("序号\t宠物名称\t类型\t元宝数");
			List<Pet> petsInStock = petOwner.getPetsInStock(storeId);
			for(int i=0;i<petsInStock.size();i++) {
				System.out.println((i+1)+"\t"+petsInStock.get(i).getName()+"\t"+petsInStock.get(i).getTypeName()+"\t"+petsInStock.get(i).getLove());
			}
			System.out.println("----请选择要购买哪一个宠物，并输入选择项的序号-----");
			int buyNum = sc.nextInt();
			petsInStock.get(buyNum-1).setOwner_id(storeId);
			petOwner.buy(petsInStock.get(buyNum-1));
			int result = petOwner.getAccount(account,petsInStock.get(buyNum-1));
			if(result==1) {
				System.out.println("台账正确插入一条信息");
		    }else {
		    	System.out.println("插入失败");
		    }
		}else if(choose==2){
		}else {
			System.out.println("输入错误，退出系统");
			System.exit(1);
		}		
		
	}
	/**
	 * 宠物主人卖出宠物
	 * @throws Exception 
	 */
	@Test
	public void ownerSell() throws Exception {
		account.setDeal_type(2);
		Scanner sc = new Scanner(System.in);
		System.out.println("--------我的宠物列表----------");
		System.out.println("序号\t宠物名称\t类型");
		PetOwnerService petOwner = new PetOwnerServiceImpl();
		List<Pet> listMyPet = petOwner.listMyPet(petO);
		for(int i=0;i<listMyPet.size();i++) {
			System.out.println((i+1)+"\t"+listMyPet.get(i).getName()+"\t"+listMyPet.get(i).getTypeName());
		}
		System.out.println("---------请选择要出售的宠物序号---------");
		int sellNum = sc.nextInt();
		System.out.println("----------您要卖出的宠物信息如下-----------");
		System.out.println("宠物的名字叫："+listMyPet.get(sellNum-1).getName()+"\t宠物的类别是"+
				listMyPet.get(sellNum-1).getTypeName());
		System.out.println("请确认是否卖出，y代表卖出n代表不卖");
		String choose = sc.next();
		while(!"y".equals(choose)) {
			System.out.println("您选择不卖，退出系统");
			System.exit(1);
		}System.out.println("-------下面是现有宠物商店，请选择您要卖给买家序号-------");
		System.out.println("序号\t宠物商店名字");
		List<PetStore> allStore = petStore.getAllStore();
		for(int i=0;i<allStore.size();i++) {
			System.out.println((i+1)+"\t"+allStore.get(i).getName());
		}
		int buyNum = sc.nextInt();
		listMyPet.get(sellNum-1).setStore_id(buyNum);
		petOwner.sell(listMyPet.get(sellNum-1));
		int result = petOwner.getAccount(account,listMyPet.get(sellNum-1));
		if(result==1) {
			System.out.println("台账正确插入一条信息");
	    }else {
	    	System.out.println("插入失败");
	    }	
	}

}

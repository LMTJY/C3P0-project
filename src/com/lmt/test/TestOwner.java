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
	 * ��������
	 * ��ȡ�����Ϣ���������ʾѡ���¼ģʽ
	 * @throws Exception 
	 */
	@Test
	public void startPetShop() throws Exception {
		PetDao pet= new PetDaoImpl();
		
		System.out.println("Womderland����,���г����sqlServer������");
		System.out.println("****************************************");
		System.out.println("���\t��������");
		List<Pet> allPet = pet.getAllPet();
		for (Pet pet2 : allPet) {
			System.out.println(pet2.getId()+"\t"+pet2.getName());
		}
		System.out.println("****************************************\n");
		System.out.println("���г������˴�Sqlserver������");
		System.out.println("****************************************");
		System.out.println("���\t��������");
		List<PetOwner> allOwner = petOwner.getAllOwner();
		for (PetOwner petOwner2 : allOwner) {
			System.out.println(petOwner2.getId()+"\t"+petOwner2.getName());
		}
		System.out.println("****************************************\n");
		System.out.println("���г����Sqlserver������");
		System.out.println("****************************************");
		System.out.println("���\t�����̵�����");
		List<PetStore> allStore = petStore.getAllStore();
		for (PetStore petStore1 : allStore) {
			System.out.println(petStore1.getId()+"\t"+petStore1.getName());
		}
		System.out.println("****************************************\n");
		System.out.println("��ѡ�������¼ģʽ������1Ϊ�������˵�¼������2Ϊ�����̵��¼");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		if(choose==1) {
			ownerLogin();
		}
	}
	/**
	 * �������˵�¼
	 * @throws Exception 
	 */
	@Test
	public void ownerLogin() throws Exception {
		PetOwner login;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("���ȵ�¼�������������˵����֣�");
			String username = sc.next();
			System.out.println("�����������˵�����");
			String password = sc.next();
			PetOwnerService petOwner = new PetOwnerServiceImpl();
			login = petOwner.login(username,password);
		}while((login==null));
			petO.setId(login.getId());
			System.out.println("-----------------��ϲ����¼�ɹ�------------------");
			System.out.println("--��--------------���Ļ�����Ϣ��------------------");
			System.out.print("���֣�"+login.getName());
			System.out.print("Ԫ������"+login.getMoney()+"\n");
			System.out.println("��¼�ɹ��������Թ����������������Ҫ���������ѡ��1����Ҫ������ѡ��2");
			System.out.println("1:�������\n2:��������");
			int choose = sc.nextInt();
			if(choose==1) {
				ownerBuy();
			}else if(choose==2){
				ownerSell();
			}else {
				System.out.println("��������˳�ϵͳ");
				System.exit(1);
			}		
	}
	/**
	 * �������˹������
	 * @throws Exception 
	 */
	@Test
	public void ownerBuy() throws Exception {
		account.setDeal_type(1);
		Scanner sc = new Scanner(System.in);
		PetOwnerService petOwner = new PetOwnerServiceImpl();
		System.out.println("-------������Ҫ����ķ�Χ��ֻ����ѡ��������-------");
		System.out.println("1:������\n2:��������������");
		int choose = sc.nextInt();
		if(choose==1) {
			System.out.println("�������̵�ID");
			int storeId = sc.nextInt();
			System.out.println("-----------�����ǿ�����--------------");
			System.out.println("���\t��������\t����\tԪ����");
			List<Pet> petsInStock = petOwner.getPetsInStock(storeId);
			for(int i=0;i<petsInStock.size();i++) {
				System.out.println((i+1)+"\t"+petsInStock.get(i).getName()+"\t"+petsInStock.get(i).getTypeName()+"\t"+petsInStock.get(i).getLove());
			}
			System.out.println("----��ѡ��Ҫ������һ�����������ѡ��������-----");
			int buyNum = sc.nextInt();
			petsInStock.get(buyNum-1).setOwner_id(storeId);
			petOwner.buy(petsInStock.get(buyNum-1));
			int result = petOwner.getAccount(account,petsInStock.get(buyNum-1));
			if(result==1) {
				System.out.println("̨����ȷ����һ����Ϣ");
		    }else {
		    	System.out.println("����ʧ��");
		    }
		}else if(choose==2){
		}else {
			System.out.println("��������˳�ϵͳ");
			System.exit(1);
		}		
		
	}
	/**
	 * ����������������
	 * @throws Exception 
	 */
	@Test
	public void ownerSell() throws Exception {
		account.setDeal_type(2);
		Scanner sc = new Scanner(System.in);
		System.out.println("--------�ҵĳ����б�----------");
		System.out.println("���\t��������\t����");
		PetOwnerService petOwner = new PetOwnerServiceImpl();
		List<Pet> listMyPet = petOwner.listMyPet(petO);
		for(int i=0;i<listMyPet.size();i++) {
			System.out.println((i+1)+"\t"+listMyPet.get(i).getName()+"\t"+listMyPet.get(i).getTypeName());
		}
		System.out.println("---------��ѡ��Ҫ���۵ĳ������---------");
		int sellNum = sc.nextInt();
		System.out.println("----------��Ҫ�����ĳ�����Ϣ����-----------");
		System.out.println("��������ֽУ�"+listMyPet.get(sellNum-1).getName()+"\t����������"+
				listMyPet.get(sellNum-1).getTypeName());
		System.out.println("��ȷ���Ƿ�������y��������n������");
		String choose = sc.next();
		while(!"y".equals(choose)) {
			System.out.println("��ѡ�������˳�ϵͳ");
			System.exit(1);
		}System.out.println("-------���������г����̵꣬��ѡ����Ҫ����������-------");
		System.out.println("���\t�����̵�����");
		List<PetStore> allStore = petStore.getAllStore();
		for(int i=0;i<allStore.size();i++) {
			System.out.println((i+1)+"\t"+allStore.get(i).getName());
		}
		int buyNum = sc.nextInt();
		listMyPet.get(sellNum-1).setStore_id(buyNum);
		petOwner.sell(listMyPet.get(sellNum-1));
		int result = petOwner.getAccount(account,listMyPet.get(sellNum-1));
		if(result==1) {
			System.out.println("̨����ȷ����һ����Ϣ");
	    }else {
	    	System.out.println("����ʧ��");
	    }	
	}

}

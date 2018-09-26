package com.lmt.service;

import java.util.List;

import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface PetOwnerService extends Buyable,Sellable,Breedable,Accountable{
	
	
	public List<Pet> getPetsInStock(int storeId) throws Exception;
	
	public List<Pet> getPetBreed(int storeId) throws Exception;

	
	public void charge(Pet pet) throws Exception;
	
	public List<Pet> listMyPet(PetOwner pet) throws Exception;
	
	public PetOwner login(String username, String password) throws Exception;//³èÎïÖ÷ÈËµÇÂ¼ 

}

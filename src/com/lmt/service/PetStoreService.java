package com.lmt.service;

import com.lmt.domain.PetOwner;

public interface PetStoreService extends Buyable,Sellable {
	
	public PetOwner login() throws Exception;
}

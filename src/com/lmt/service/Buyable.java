package com.lmt.service;

import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface Buyable {

	void buy(Pet pet) throws Exception;
}

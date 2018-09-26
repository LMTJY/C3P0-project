package com.lmt.service;

import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface Sellable {

	void sell(Pet pet) throws Exception;
}

package com.lmt.service;

import java.util.List;

import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface Accountable {

	int getAccount(Account account, Pet pet)throws Exception;
}

package com.lmt.dao;

import java.util.List;

import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;

public interface AccountDao {


	int update(Account account, Pet pet) throws Exception;//更新台账信息


}

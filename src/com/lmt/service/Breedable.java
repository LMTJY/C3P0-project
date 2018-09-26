package com.lmt.service;

import com.lmt.domain.Pet;

public interface Breedable {
	 Pet breed(String petType) throws Exception;
}

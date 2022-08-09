package com.qa.biscuits.service;

import java.util.List;

import com.qa.biscuits.domain.Biscuit;

public interface BiscuitService {

	Biscuit makeBikky(Biscuit biscuit);

	List<Biscuit> getAllBiscuits();

	Biscuit getById(int id);

	Biscuit updateBiscuit(int id, String name, Integer amount, Double cost);

	void delete(int id);
}

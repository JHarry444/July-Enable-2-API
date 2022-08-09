package com.qa.biscuits.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.biscuits.domain.Biscuit;

@Service
//@Primary
public class BiscuitServiceList implements BiscuitService {

	private List<Biscuit> biscuits;

	public BiscuitServiceList() {
		super();
		this.biscuits = new ArrayList<>();
		this.biscuits.add(new Biscuit("Custard Cream", 1, 0.05));
	}

	@Override
	public Biscuit makeBikky(Biscuit biscuit) {
		this.biscuits.add(biscuit);
		return biscuits.get(this.biscuits.size() - 1);
	}

	@Override
	public List<Biscuit> getAllBiscuits() {
		return this.biscuits;
	}

	@Override
	public Biscuit getById(int id) {
		return this.biscuits.get(id);
	}

	@Override
	public Biscuit updateBiscuit(int id, String name, Integer amount, Double cost) {
		Biscuit toUpdate = this.biscuits.get(id);

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (amount != null)
			toUpdate.setAmount(amount);
		if (cost != null)
			toUpdate.setCost(cost);

		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.biscuits.remove(id);
	}

}

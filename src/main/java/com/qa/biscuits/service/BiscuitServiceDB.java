package com.qa.biscuits.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.biscuits.domain.Biscuit;
import com.qa.biscuits.repos.BiscuitRepo;

@Service
@Primary
public class BiscuitServiceDB implements BiscuitService {

	private BiscuitRepo repo;

	public BiscuitServiceDB(BiscuitRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Biscuit makeBikky(Biscuit biscuit) {
		return this.repo.save(biscuit);
	}

	@Override
	public List<Biscuit> getAllBiscuits() {
		return this.repo.findAll();
	}

	@Override
	public Biscuit getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Biscuit updateBiscuit(int id, String name, Integer amount, Double cost) {
		Biscuit toUpdate = this.repo.findById(id).get(); // fetches the existing data from the DB

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (amount != null)
			toUpdate.setAmount(amount);
		if (cost != null)
			toUpdate.setCost(cost);

		return this.repo.save(toUpdate); // saves the new data and returns it
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);

	}

}

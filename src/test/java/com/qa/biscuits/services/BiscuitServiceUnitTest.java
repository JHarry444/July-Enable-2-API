package com.qa.biscuits.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.biscuits.domain.Biscuit;
import com.qa.biscuits.repos.BiscuitRepo;
import com.qa.biscuits.service.BiscuitService;

@SpringBootTest
@ActiveProfiles("test")
public class BiscuitServiceUnitTest {

	@Autowired
	private BiscuitService service;

	@MockBean
	private BiscuitRepo repo;

	@Test
	void testUpdate() {

		final int id = 1;

		final String name = "Maryland Cookies";
		final int newAmount = 12;
		final double newCost = 34.45;

		Biscuit expected = new Biscuit(id, name, newAmount, newCost);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Biscuit(id, name, 6, 10)));
		Mockito.when(this.repo.save(new Biscuit(id, name, newAmount, newCost)))
				.thenReturn(new Biscuit(id, name, newAmount, newCost));

		Biscuit actual = this.service.updateBiscuit(id, null, newAmount, newCost);

		assertEquals(expected, actual);

	}

}

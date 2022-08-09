package com.qa.biscuits.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.biscuits.domain.Biscuit;
import com.qa.biscuits.service.BiscuitService;

@RestController
public class BiscuitController {

	private BiscuitService service;

	@Autowired
	public BiscuitController(BiscuitService service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, world!";
	}

	@PostMapping("/createBiscuit")
	public Biscuit makeBikky(@RequestBody Biscuit biscuit) {
		System.out.println("Body: " + biscuit);
		return this.service.makeBikky(biscuit);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getAll")
	public List<Biscuit> getAllBiscuits() {
		return this.service.getAllBiscuits();
	}

	@GetMapping("/get/{id}")
	public Biscuit getById(@PathVariable int id) {
		System.out.println("ID: " + id);
		return this.service.getById(id);
	}

	@PatchMapping("/update/{id}")
	public Biscuit updateBiscuit(@PathVariable int id, @PathParam("name") String name,
			@PathParam("amount") Integer amount, @PathParam("cost") Double cost) {
		System.out.println("ID: " + id);
		System.out.println("NAME: " + name);
		System.out.println("AMOUNT: " + amount);
		System.out.println("COST: " + cost);

		return this.service.updateBiscuit(id, name, amount, cost);
	}

	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
		this.service.delete(id);
	}

}

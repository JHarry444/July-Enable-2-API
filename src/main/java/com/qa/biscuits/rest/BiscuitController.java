package com.qa.biscuits.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.biscuits.domain.Biscuit;

@RestController
public class BiscuitController {

	private List<Biscuit> biscuits;

	public BiscuitController() {
		super();
		this.biscuits = new ArrayList<>();
		this.biscuits.add(new Biscuit("Custard Cream", 1, 0.05));
	}

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, world!";
	}

	@PostMapping("/createBiscuit")
	public void makeBikky(@RequestBody Biscuit biscuit) {
		System.out.println("Body: " + biscuit);
	}

	@GetMapping("/getAll")
	public List<Biscuit> getAllBiscuits() {
		return this.biscuits;
	}

	@GetMapping("/get/{id}")
	public Biscuit getById(@PathVariable int id) {
		System.out.println("ID: " + id);
		return this.biscuits.get(id);
	}

	@PatchMapping("/update/{id}")
	public void updateBiscuit(@PathVariable int id, @PathParam("name") String name, @PathParam("amount") Integer amount,
			@PathParam("cost") Double cost) {
		System.out.println("ID: " + id);
		System.out.println("NAME: " + name);
		System.out.println("AMOUNT: " + amount);
		System.out.println("COST: " + cost);
	}

	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
	}

}

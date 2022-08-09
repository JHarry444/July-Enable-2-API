package com.qa.biscuits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class Biscuit {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI (optional)
	private Integer id;

	private String name;

	private int amount;

	private double cost;

	public Biscuit(Integer id, String name, int amount, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
	}

	public Biscuit(String name, int amount, double cost) {
		super();
		this.name = name;
		this.amount = amount;
		this.cost = cost;
	}

	// REQUIRED
	public Biscuit() {
		super();
	}

	// REQUIRED
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Biscuit [name=" + this.name + ", amount=" + this.amount + ", cost=" + this.cost + "]";
	}

}

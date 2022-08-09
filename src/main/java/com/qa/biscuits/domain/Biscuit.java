package com.qa.biscuits.domain;

public class Biscuit {

	private String name;

	private int amount;

	private double cost;

	public Biscuit(String name, int amount, double cost) {
		super();
		this.name = name;
		this.amount = amount;
		this.cost = cost;
	}

	public Biscuit() {
		super();
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

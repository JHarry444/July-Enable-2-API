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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.amount;
		long temp;
		temp = Double.doubleToLongBits(this.cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biscuit other = (Biscuit) obj;
		if (this.amount != other.amount)
			return false;
		if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
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

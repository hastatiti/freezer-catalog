package com.northrow.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;
	
	//Apple
	private String name;
	
	//Fruit
	private String type; 
	
	//10
	private int quantity;

	public Food() {
		super();
	}

	public Food(String name, String type, int quantity) {
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodId, name, quantity, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(foodId, other.foodId) && Objects.equals(name, other.name) && quantity == other.quantity
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", type=" + type + ", quantity=" + quantity + "]";
	}
	
}

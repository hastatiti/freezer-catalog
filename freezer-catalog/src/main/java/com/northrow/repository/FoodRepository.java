package com.northrow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.northrow.model.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

	@Query("SELECT f FROM Food f WHERE f.name = ?1")
	Food findFoodByName(String name);
	
}

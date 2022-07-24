package com.northrow.service;

import com.northrow.model.Food;

public interface FoodService {

	Food saveFood(Food food);

	Food getFood(Long id);

	Food updateFood(Long id, Food food);

	Food getFoodByName(String name);

}

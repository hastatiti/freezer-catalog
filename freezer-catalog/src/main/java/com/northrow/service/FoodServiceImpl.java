package com.northrow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northrow.model.Food;
import com.northrow.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public Food saveFood(Food food) {
		return foodRepository.save(food);
	}

	@Override
	public Food getFood(Long id) {
		return foodRepository.findById(id).orElseThrow();
	}

	@Override
	public Food updateFood(Long id, Food food) {
		Food foodToUpdate = foodRepository.findById(id).orElseThrow();
		foodToUpdate.setName(food.getName());
		foodToUpdate.setType(food.getType());
		foodToUpdate.setQuantity(food.getQuantity());
		return foodRepository.save(foodToUpdate);
	}

	@Override
	public Food getFoodByName(String name) {
		return foodRepository.findFoodByName(name);
	}

}

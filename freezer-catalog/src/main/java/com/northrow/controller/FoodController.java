package com.northrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.northrow.model.Food;
import com.northrow.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;

	@PostMapping("/food")
	@Operation(summary = "Save food")
	public Long saveFood(@RequestBody Food food) {
		Food f = foodService.saveFood(food);
		return f.getFoodId();
	}

	@GetMapping("/food/{id}")
	@Operation(summary = "Get food by id")
	public Food getFood(@PathVariable Long id) {
		return foodService.getFood(id);
	}

	@PutMapping("/food/{id}")
	@Operation(summary = "Update food")
	public Food updateFood(@PathVariable Long id, @RequestBody Food food) {
		return foodService.updateFood(id, food);
	}

	@GetMapping("/food/search/{name}")
	@Operation(summary = "Get food by name")
	public Food getFoodByName(@PathVariable String name) {
		return foodService.getFoodByName(name);
	}

}

package com.northrow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.northrow.controller.FoodController;
import com.northrow.model.Food;
import com.northrow.repository.FoodRepository;
import com.northrow.service.FoodService;

@SpringBootTest
public class FoodControllerTest {

	@Autowired
	FoodController foodController;
	@Autowired
	FoodService foodService;
	@Autowired
	FoodRepository foodRepository;

	@Test
	public void testSaveFood() {
		Food food = new Food("apple", "fruit", 20);
		Long id = foodController.saveFood(food);
		assertThat(id).isEqualTo(1L);
	}

	@Test
	public void testGetFood() {
		Food newFood = new Food("tomato", "vegetable", 44);
		Long id = foodController.saveFood(newFood);
		Food food = foodController.getFood(id);
		assertThat(food).isEqualTo(newFood);
	}

	@Test
	public void testUpdateFood() {
		Food newFood = new Food("buscuit", "snack", 33);
		Long id = foodController.saveFood(newFood);
		Food anotherFood = new Food("orange", "fruit", 12);
		Food updatedFood = foodController.updateFood(id, anotherFood);
		assertThat(updatedFood.getName()).isEqualTo(anotherFood.getName());
		assertThat(updatedFood.getQuantity()).isEqualTo(anotherFood.getQuantity());
		assertThat(updatedFood.getType()).isEqualTo(anotherFood.getType());
	}

	@Test
	public void testgetFoodByName() {
		Food newFood = new Food("pear", "fruit", 10);
		foodController.saveFood(newFood);
		Food food = foodController.getFoodByName("pear");
		assertThat(food).isEqualTo(newFood);
	}

}

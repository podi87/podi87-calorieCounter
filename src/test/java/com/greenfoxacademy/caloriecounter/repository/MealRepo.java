package com.greenfoxacademy.caloriecounter.repository;

import com.greenfoxacademy.caloriecounter.model.Meals;
import org.springframework.data.repository.CrudRepository;


public interface MealRepo extends CrudRepository<Meals, Long> {
}

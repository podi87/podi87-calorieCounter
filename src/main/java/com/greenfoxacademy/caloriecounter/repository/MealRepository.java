package com.greenfoxacademy.caloriecounter.repository;


import com.greenfoxacademy.caloriecounter.model.Meals;
import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meals, Long> {
}

package com.greenfoxacademy.caloriecounter.model;


import com.greenfoxacademy.caloriecounter.repository.MealRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Status {

  private int numberOfMeals;
  private int totalCalories;

  public Status(MealRepository mealRepository) {
    this.numberOfMeals = (int)mealRepository.count();
    this.totalCalories = sumCalories(mealRepository);
  }

  public int sumCalories(MealRepository mealRepository) {
    int sum = 0;
    for (Meals m : mealRepository.findAll()) {
      sum += m.getCalories();
    }
    return sum;
  }

}

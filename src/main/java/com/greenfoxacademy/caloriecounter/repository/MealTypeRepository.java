package com.greenfoxacademy.caloriecounter.repository;

import com.greenfoxacademy.caloriecounter.model.MealTypes;
import org.springframework.data.repository.CrudRepository;

public interface MealTypeRepository extends CrudRepository<MealTypes, Long>{
}

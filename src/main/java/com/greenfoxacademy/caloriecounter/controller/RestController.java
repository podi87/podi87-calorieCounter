package com.greenfoxacademy.caloriecounter.controller;


import com.greenfoxacademy.caloriecounter.model.Meals;
import com.greenfoxacademy.caloriecounter.model.Status;
import com.greenfoxacademy.caloriecounter.repository.MealRepository;
import com.greenfoxacademy.caloriecounter.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  MealRepository mealRepository;
  @Autowired
  MealTypeRepository mealTypeRepository;
  @Autowired
  Meals meals;
  @Autowired
  Status status;

  @RequestMapping(value = "/getmeals", method = RequestMethod.GET)
  public Iterable<Meals> list() {
    return mealRepository.findAll();
  }

  @RequestMapping(value = "/getstats", method = RequestMethod.GET)
  public Status status() {
    return new Status(mealRepository);
  }

}

package com.greenfoxacademy.caloriecounter.controller;

import com.greenfoxacademy.caloriecounter.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @Autowired
  MealRepository mealRepository;

  @RequestMapping(value = "/")
  public String showMeals(Model model) {
    model.addAttribute("table", mealRepository.findAll());
    return "index";
  }

}

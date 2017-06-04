package com.greenfoxacademy.caloriecounter.controller;

import com.greenfoxacademy.caloriecounter.model.MealTypes;
import com.greenfoxacademy.caloriecounter.model.Meals;
import com.greenfoxacademy.caloriecounter.repository.MealRepository;
import com.greenfoxacademy.caloriecounter.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

  @Autowired
  MealRepository mealRepository;
  @Autowired
  MealTypeRepository mealTypeRepository;

  @RequestMapping(value = "/")
  public String showMeals(Model model) {
    model.addAttribute("count", mealRepository.count());
    model.addAttribute("table", mealRepository.findAll());
    return "index";
  }

  @RequestMapping(value = "/add")
  public String add(Model model) {
    List<String> mealTypes = new ArrayList<>(Arrays.asList("Breakfast", "Elevenses", "Lunch", "Snack", "Dinner", "Midnight Snack"));
    if (mealTypeRepository.count() == 0) {
      for (int i = 0; i < mealTypes.size(); i++) {
        mealTypeRepository.save(new MealTypes(mealTypes.get(i)));
      }
    }
    model.addAttribute("count", mealRepository.count());
    model.addAttribute("types", mealTypeRepository.findAll());
    return "add";
  }

  @RequestMapping(value = "/addMeal")
  public String addNew(@RequestParam(name = "type") String type, @RequestParam(name = "description") String description,
                       @RequestParam(name = "calories") String calories) {
    int cal = Integer.parseInt(calories);
    mealRepository.save(new Meals(type, description, cal));
    return "redirect:/add";
  }

}

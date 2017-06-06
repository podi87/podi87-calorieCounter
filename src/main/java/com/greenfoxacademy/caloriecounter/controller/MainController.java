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

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

  @Autowired
  MealRepository mealRepository;
  @Autowired
  MealTypeRepository mealTypeRepository;

  public String message = "Add new meals below!";

  @RequestMapping(value = "/")
  public String showMeals(Model model) {
    if (mealRepository.count() > 0) {
      Integer sum = 0;
      for (Meals m : mealRepository.findAll()) {
        sum += m.getCalories();
      }
      model.addAttribute("total", sum);
    } else {
      model.addAttribute("total", 0);
    }
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
    model.addAttribute("log", message);
    model.addAttribute("count", mealRepository.count());
    model.addAttribute("table", mealRepository.findAll());
    model.addAttribute("types", mealTypeRepository.findAll());
    return "add";
  }

  @RequestMapping(value = "/addMeal")
  public String addNew(@RequestParam(name = "type") String type, @RequestParam(name = "description") String description,
                       @RequestParam(name = "calories") String calories) {
    int cal = 0;
    if (type.equals("Choose type") && calories.isEmpty()) {
      message = "Please choose type and add calories!";
    } else if (type.equals("Choose type")) {
      message = "Please choose type!";
    } else if (calories.isEmpty()) {
      message = "Please add calories!";
    } else {
      try {
        cal = Integer.parseInt(calories);
      } catch (NumberFormatException e) {
        e.getStackTrace();
      }
      if (cal != 0) {
        message = "Add new meals below!";
        mealRepository.save(new Meals(type, description, cal));
      } else {
        message = "Please provide number format in the calorie field!";
      }
    }
    return "redirect:/add";
  }

  @RequestMapping(value = "/delete")
  public String edit(@RequestParam(name = "delID") long id) {
    mealRepository.delete(id);
    return "redirect:/";
  }

  @RequestMapping(value = "/update")
  public String update(Model model, @RequestParam(name = "upID") long id) {
    model.addAttribute("count", mealRepository.count());
    model.addAttribute("table", mealRepository.findAll());
    model.addAttribute("types", mealTypeRepository.findAll());
    return "edit";
  }

  @RequestMapping(value = "/editor")
  public String editor(@RequestParam(name = "upID") long id, @RequestParam(name = "type") String type,
                       @RequestParam(name = "description") String description, @RequestParam(name = "calories") String calories) {
    int cal = Integer.parseInt(calories);
    mealRepository.findOne(id).setCalories(cal);
    mealRepository.findOne(id).setDescription(description);
    mealRepository.findOne(id).setType(type);
    mealRepository.findOne(id).setDate(LocalDate.now().toString());
    mealRepository.save(mealRepository.findOne(id));
    return "redirect:/";
  }

  @RequestMapping(value = "/back")
  public String back() {
    return "redirect:/";
  }

}

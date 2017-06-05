package com.greenfoxacademy.caloriecounter.controller;


import com.greenfoxacademy.caloriecounter.model.Meals;
import com.greenfoxacademy.caloriecounter.model.ResponseMessage;
import com.greenfoxacademy.caloriecounter.model.Status;
import com.greenfoxacademy.caloriecounter.repository.MealRepository;
import com.greenfoxacademy.caloriecounter.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;


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
  @Autowired
  ResponseMessage responseMessage;


  @RequestMapping(value = "/getmeals", method = RequestMethod.GET)
  public Iterable<Meals> list() {
    return mealRepository.findAll();
  }

  @RequestMapping(value = "/getstats", method = RequestMethod.GET)
  public Status status() {
    return new Status(mealRepository);
  }

  @RequestMapping(value = "/meal", method = RequestMethod.POST)
  public ResponseMessage saveMeal(@RequestBody() Meals meals) {
    mealRepository.save(meals);
    return new ResponseMessage();
  }

  @RequestMapping(value = "/meal" , method = RequestMethod.PUT)
  public ResponseMessage updateMela(@RequestBody() Meals mealBody) {
    for (Meals m : mealRepository.findAll()) {
      if (m.getId() == mealBody.getId()) {
        mealRepository.findOne(mealBody.getId()).setType(mealBody.getType());
        mealRepository.findOne(mealBody.getId()).setDescription(mealBody.getDescription());
        mealRepository.findOne(mealBody.getId()).setCalories(mealBody.getCalories());
        mealRepository.findOne(mealBody.getId()).setDate(mealBody.getDate());
        mealRepository.save(mealRepository.findOne(mealBody.getId()));
        return new ResponseMessage();
      }
    }
    return new ResponseMessage(null);
  }

  @RequestMapping(value = "/meal", method = RequestMethod.DELETE)
  public ResponseMessage delete(@RequestBody() Meals mealBody) {
    for (Meals m : mealRepository.findAll()) {
      if (m.getId() == mealBody.getId()) {
        mealRepository.delete(mealBody.getId());
        return new ResponseMessage();
      }
    }
    return new ResponseMessage(null);
  }
}

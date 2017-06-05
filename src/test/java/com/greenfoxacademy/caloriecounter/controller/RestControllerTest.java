package com.greenfoxacademy.caloriecounter.controller;



import com.greenfoxacademy.caloriecounter.model.Meals;

import com.greenfoxacademy.caloriecounter.repository.MealRepo;
import com.greenfoxacademy.caloriecounter.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EndpointTestingApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class RestControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  private MockMvc mockMvc;

//  @Autowired
//  MealRepo mealRepo;

  @Autowired
  private WebApplicationContext webApplicationContext;


  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
//    this.mealRepo.deleteAll();
//    this.mealRepo.save(new Meals("Breakfast", "cheese", 150));
  }


  @Test
  public void list() throws Exception {
    ResultActions resultActions = mockMvc.perform(get("/getmeals"))
            .andExpect(jsonPath("$.id").doesNotExist())
            .andExpect(jsonPath("$.type").doesNotExist())
            .andExpect(jsonPath("$.description").doesNotExist())
            .andExpect(jsonPath("$.calories").doesNotExist())
            .andExpect(jsonPath("$.date").doesNotExist());


  }

  @Test
  public void status() throws Exception {

  }

  @Test
  public void saveMeal() throws Exception {

  }

  @Test
  public void updateMela() throws Exception {

  }

  @Test
  public void delete() throws Exception {

  }

}
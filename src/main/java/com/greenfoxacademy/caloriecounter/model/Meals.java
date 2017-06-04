package com.greenfoxacademy.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Meals")
@Getter
@Setter
public class Meals {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "Type")
  private String type;
  @Column(name = "Description")
  private String description;
  @Column(name = "Calories(kcal)")
  private int calories;
  @Column(name = "Date")
  private Timestamp timestamp;

  public Meals(String type, String description, int calories) {
    this.type = type;
    this.description = description;
    this.calories = calories;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  
}

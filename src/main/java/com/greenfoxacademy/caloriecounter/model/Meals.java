package com.greenfoxacademy.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MEALS")
@Getter
@Setter
public class Meals {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String type;
  private String description;
  private int calories;
  private Timestamp timestamp;

  public Meals(String type, String description, int calories) {
    this.type = type;
    this.description = description;
    this.calories = calories;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Meals() {
  }
}

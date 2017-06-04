package com.greenfoxacademy.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TYPES")
@Getter
@Setter
public class MealTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String type;

  public MealTypes(String type) {
    this.type = type;
  }

  public MealTypes() {
  }
}

package com.greenfoxacademy.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "MEALS")
@Getter
@Setter
@Component
public class Meals {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String type;
  private String description;
  private int calories;
  private String date;

  public Meals(String type, String description, int calories) {
    this.type = type;
    this.description = description;
    this.calories = calories;
    this.date = LocalDate.now().toString();
  }

  public Meals(String type, String description, int calories, String date) {
    this.type = type;
    this.description = description;
    this.calories = calories;
    this.date = date;
  }

  public Meals() {
  }

  @Override
  public String toString() {
    return "Meals{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", calories=" + calories +
            ", date=" + date +
            '}';
  }
}

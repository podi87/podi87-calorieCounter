package com.greenfoxacademy.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
public class ResponseMessage {

  private String status;

  public ResponseMessage(String input) {
    if (Objects.equals(input, "timestamp")) {
      this.status = "Missing timestamp!";
    } else if (Objects.equals(input, "type")) {
      this.status = "Missing type";
    } else if (Objects.equals(input, "calories")) {
      this.status = "Missing calories";
    } else if (Objects.equals(input, "description")) {
      this.status = "Missing description";
    } else if (input == null) {
      this.status = "not ok";
    }
  }

  public ResponseMessage() {
    this.status = "ok";
  }
}

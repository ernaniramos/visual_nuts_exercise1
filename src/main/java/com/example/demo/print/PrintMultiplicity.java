package com.example.demo.print;

import com.example.demo.config.AppConfiguration;
import com.example.demo.service.MultiplicityService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PrintMultiplicity {

  private final MultiplicityService multiplicityService;
  private final AppConfiguration appConfiguration;

  PrintMultiplicity(
      final MultiplicityService multiplicityService, final AppConfiguration appConfiguration) {
    this.multiplicityService = multiplicityService;
    this.appConfiguration = appConfiguration;
  }

  @PostConstruct
  private void print() {
    getMultiplicity();
  }

  public void getMultiplicity() {
    multiplicityService
        .checkNumbersInRange(appConfiguration.getStartRange(), appConfiguration.getEndRange())
        .forEach(System.out::println);
  }
}

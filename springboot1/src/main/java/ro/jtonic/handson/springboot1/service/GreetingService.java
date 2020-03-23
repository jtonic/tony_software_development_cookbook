package ro.jtonic.handson.springboot1.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

  public String getMessage(String personName) {
    return String.format("Hello %s%n", personName);
  }
}

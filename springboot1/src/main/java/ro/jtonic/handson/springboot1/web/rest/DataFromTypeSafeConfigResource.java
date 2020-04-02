package ro.jtonic.handson.springboot1.web.rest;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataFromTypeSafeConfigResource {

  private final String applicationName;
  private final String applicationDescription;

  public DataFromTypeSafeConfigResource(
      @Value("${application.name}") String applicationName,
      Environment env) {

    this.applicationName = applicationName;
    this.applicationDescription = env.getProperty("application.description", "No description");
  }

  @SneakyThrows
  @GetMapping(value = "/config")
  @ResponseStatus(HttpStatus.OK)
  public String greeting() {

    final String message = String
        .format("[Application] name: %s, description %s", this.applicationName,
            this.applicationDescription);
    return message;
  }
}

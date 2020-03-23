package ro.jtonic.handson.springboot1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {
    new SpringApplicationBuilder(MainApp.class)
        .web(true)
        .main(MainApp.class)
        .build()
        .run(args);
  }
}

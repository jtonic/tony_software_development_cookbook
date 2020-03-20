package ro.jtonic.handson.springboot1;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {
    SpringApplication.run(MainApp.class);
  }

  @Bean
  public ApplicationRunner runner() {
    return args -> System.out.println("Running....");
  }
}

package ro.jtonic.handson.springboot1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;
import ro.jtonic.handson.springboot1.config.TypesafePropertySourceFactory;

@SpringBootApplication
@PropertySource(factory= TypesafePropertySourceFactory.class, value="/app.conf", name = "app.conf")
public class MainApp {

  public static void main(String[] args) {
    new SpringApplicationBuilder(MainApp.class)
        .web(true)
        .main(MainApp.class)
        .build()
        .run(args);
  }
}

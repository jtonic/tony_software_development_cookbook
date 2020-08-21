package ro.jtonic.handson.cli;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

  @Bean
  public ObjectMapper mapper() {
    return new ObjectMapper();
  }
}

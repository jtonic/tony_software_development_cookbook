package ro.jtonic.handson.springboot1.config;

import static ro.jtonic.handson.springboot1.akka.ext.SpringExtension.SPRING_EXTENSION_PROVIDER;

import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActorSystemConfig {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  public ActorSystem actorSystem() {
    ActorSystem system = ActorSystem.create("akka-spring");
    SPRING_EXTENSION_PROVIDER.get(system)
        .initialize(applicationContext);
    return system;
  }
}

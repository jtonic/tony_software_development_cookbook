package ro.jtonic.handson.springboot1.web.rest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ro.jtonic.handson.springboot1.akka.actor.GreetingActor;
import ro.jtonic.handson.springboot1.akka.actor.GreetingActor.Greet;
import ro.jtonic.handson.springboot1.akka.ext.SpringExtension;
import ro.jtonic.handson.springboot1.akka.ext.SpringExtension.SpringExt;

@RestController
public class GreetingResource {

  public static final Logger LOG = LoggerFactory.getLogger(GreetingResource.class);

  private final ActorSystem actorSystem;

  public GreetingResource(ActorSystem actorSystem) {
    this.actorSystem = actorSystem;
  }

  @SneakyThrows
  @GetMapping(value = "/greeting")
  @ResponseStatus(HttpStatus.OK)
  public String greeting(@RequestParam("name") String name) {

    final SpringExt springExt = SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem);

    final Props actorProps = springExt.props(GreetingActor.NAME);

    final String actorName = GreetingActor.NAME + UUID.randomUUID().toString();

    final ActorRef greetingActorRef = actorSystem.actorOf(actorProps,
        actorName);

    final CompletableFuture<Object> resultCompFuture = Patterns
        .ask(greetingActorRef, new Greet(name), Duration.ofSeconds(3)).toCompletableFuture();

    LOG.info("Waiting for getting information from greeting actor (superviser)...");
    TimeUnit.SECONDS.sleep(2);

    final String message = (String) resultCompFuture.get();
    LOG.info("Got message from greeting actor (superviser). Message: {}", message);
    return message;
  }
}

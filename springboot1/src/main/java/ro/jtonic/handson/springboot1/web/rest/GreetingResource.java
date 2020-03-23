package ro.jtonic.handson.springboot1.web.rest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
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

  private final ActorSystem actorSystem;

  public GreetingResource(ActorSystem actorSystem) {
    this.actorSystem = actorSystem;
  }

  @GetMapping(value = "/greeting")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void greeting(@RequestParam("name") String name) {

    final SpringExt springExt = SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem);

    final Props actorProps = springExt.props(GreetingActor.NAME);

    final ActorRef greetingActorRef = actorSystem.actorOf(actorProps, GreetingActor.NAME);

    greetingActorRef.tell(new Greet(name), ActorRef.noSender());
  }
}

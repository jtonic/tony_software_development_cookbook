package ro.jtonic.handson.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.jtonic.handson.akka.actors.GreetingActor;

public class SimpleActorApp {

  public static final Logger LOG =  LoggerFactory.getLogger(SimpleActorApp.class);

  public static void main(String[] args) {

    final ActorSystem actorSystem = ActorSystem.create("akka-system-1");
    try {
      final ActorRef greetingActor = actorSystem
          .actorOf(GreetingActor.props(), GreetingActor.NAME);

      LOG.info("Sending message to Greeting actor");

      greetingActor.tell("Hello Mr. Tony", ActorRef.noSender());

      TimeUnit.MICROSECONDS.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      actorSystem.terminate();
    }
  }
}

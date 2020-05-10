package ro.jtonic.handson.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.jtonic.handson.akka.actors.GreeteeActor;
import ro.jtonic.handson.akka.actors.GreeterActor;

public class ActorSystemApp {

  public static final Logger LOG =  LoggerFactory.getLogger(ActorSystemApp.class);

  public static void main(String[] args) {

    final ActorSystem actorSystem = ActorSystem.create("akka-system-1");
    try {
      final ActorRef greeteeActor = actorSystem
          .actorOf(GreeteeActor.props(), GreeteeActor.NAME);

      final ActorRef greeterActor = actorSystem
          .actorOf(GreeterActor.props("Mr."), GreeterActor.NAME);

      LOG.info("Sending message to Greeting actor...");

      greeterActor.tell("Tony", greeteeActor);

      TimeUnit.MICROSECONDS.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      actorSystem.terminate();
    }
  }
}

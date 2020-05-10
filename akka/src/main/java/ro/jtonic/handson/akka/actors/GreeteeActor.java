package ro.jtonic.handson.akka.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class GreeteeActor extends AbstractActor {

  public static final String NAME = "greetee-actor";

  private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

  public static Props props() {
    return Props.create(GreeteeActor.class);
  }

  @Override
  public void preStart() {
    log.debug("The actor {} was started!", NAME);
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder().match(
        String.class, s -> {
          final String msg = String.format("%s Sender: %s%n", s, getSender());
          log.debug(msg);
        }
    ).build();
  }
}

package ro.jtonic.handson.akka.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class GreeterActor extends AbstractActor {

  public static final String NAME = "greeter-actor";

  private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

  private final String salutation;

  public static Props props(String salutation) {
    return Props.create(GreeterActor.class, () -> new GreeterActor(salutation));
  }

  private GreeterActor(String salutation) {
    this.salutation = salutation;
  }

  @Override
  public void preStart() {
    log.debug("The actor {} was started!", NAME);
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder().match(
        String.class, s -> {
          final String msg = String.format("%s %s, hello from Akka!", this.salutation, s);
          log.debug(String.format("%s Sender: %s%n", msg, getSender().toString()));
          getSender().tell(msg, getSelf());
        }
    ).build();
  }
}

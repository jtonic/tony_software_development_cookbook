package ro.jtonic.handson.akka.actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingActor extends UntypedAbstractActor {

  public static final Logger LOG = LoggerFactory.getLogger(GreetingActor.class);

  public static final String NAME = "greeting-actor";

  public static Props props() {
    return Props.create(GreetingActor.class);
  }

  @Override
  public void onReceive(Object message) {
    if (message instanceof String) {
      LOG.info("Hello from GreetingActor");
    }
  }
}

package ro.jtonic.handson.akka.actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class GreetHelpActor extends UntypedAbstractActor {

  public static final String NAME = "GreetHelpActor";

  public static final String SALUTATION = "Mr.";

  public static final class Commands {

    public static final String GET_SALUTATION = "getSalutation";
  }

  public static Props props() {
    return Props.create(GreetHelpActor.class);
  }

  @Override
  public void onReceive(Object message) {
    if (message instanceof String && Commands.GET_SALUTATION.equalsIgnoreCase((String)message)) {
      getSender().tell(SALUTATION, getSelf());
    } else {
      unhandled("Command unknown!");
    }
  }
}

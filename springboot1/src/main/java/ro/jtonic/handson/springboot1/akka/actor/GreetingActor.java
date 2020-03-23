package ro.jtonic.handson.springboot1.akka.actor;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.jtonic.handson.springboot1.service.GreetingService;

@Component(GreetingActor.NAME)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetingActor extends UntypedAbstractActor {

  private final LoggingAdapter LOG = Logging.getLogger(getContext().getSystem(), this);

  public static final String NAME = "GreetingActor";

  private final GreetingService service;

  public GreetingActor(GreetingService service) {
    this.service = service;
  }

  @Override
  public void onReceive(Object message) {
    if (message instanceof Greet) {
      String personName = ((Greet)message).getName();
      LOG.info("Message received: {}", personName);

      final String msg = this.service.getMessage(personName);
      LOG.info("Message to be send: {}", msg);
      getSender().tell(msg, getSelf());
    } else {
      getSender().tell("No message!!!", getSelf());
    }
  }

  @Getter
  @AllArgsConstructor
  @EqualsAndHashCode
  @ToString
  public static final class Greet {

    private final String name;
  }
}

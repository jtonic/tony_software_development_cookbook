package ro.jtonic.handson.springboot1.akka.ext;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import ro.jtonic.handson.springboot1.akka.ext.SpringExtension.SpringExt;

public class SpringExtension
    extends AbstractExtensionId<SpringExt> {

  public static final SpringExtension SPRING_EXTENSION_PROVIDER
      = new SpringExtension();

  @Override
  public SpringExt createExtension(ExtendedActorSystem system) {
    return new SpringExt();
  }

  public static class SpringExt implements Extension {

    private volatile ApplicationContext applicationContext;

    public void initialize(ApplicationContext applicationContext) {
      this.applicationContext = applicationContext;
    }

    public Props props(String actorBeanName) {
      return Props.create(
          SpringActorProducer.class, applicationContext, actorBeanName);
    }
  }
}
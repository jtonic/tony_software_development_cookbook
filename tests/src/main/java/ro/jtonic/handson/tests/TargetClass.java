package ro.jtonic.handson.tests;

public class TargetClass {

  private final FinalMethodClass finalMethodClass;
  private final FinalClass finalClass;
  private final PrivateMethodClass privateMethodClass;

  public TargetClass(FinalMethodClass finalMethodClass, FinalClass finalClass,
      PrivateMethodClass privateMethodClass) {
    this.finalMethodClass = finalMethodClass;
    this.finalClass = finalClass;
    this.privateMethodClass = privateMethodClass;
  }

  public String foo() {
    final CollaboratorClass collaborator = new CollaboratorClass();
    return collaborator.foo();
  }

  public String boo() {

    final CollaboratorClass collaboratorClass = new CollaboratorClass();
    final String foo = collaboratorClass.foo();

    final String ask = this.finalClass.ask();
    final String say = this.finalMethodClass.say();

    final String speak = StaticClass.speak();
    final String tell = this.privateMethodClass.tell();

    return String.format("%s %s %s %s %s", foo, ask, say, speak, tell);
  }
}

package ro.jtonic.handson.tests;

public class TargetClass {

  public String foo() {
    final CollaboratorClass collaborator = new CollaboratorClass();
    return collaborator.foo();
  }
}

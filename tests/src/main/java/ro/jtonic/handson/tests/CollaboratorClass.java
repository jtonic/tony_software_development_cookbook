package ro.jtonic.handson.tests;

public class CollaboratorClass {

  public CollaboratorClass() {
    System.out.println("In CollaboratorClass's constructor");
  }

  public String foo() {
    System.out.println("Calling collaborator");
    return "foo";
  }
}

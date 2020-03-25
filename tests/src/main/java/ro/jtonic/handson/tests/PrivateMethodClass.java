package ro.jtonic.handson.tests;

public final class PrivateMethodClass {

  private String doTell() {
    System.out.println("I am private method!!! Original tell.");
    return "I am private method!!! Original tell.";
  }

  public String tell() {
    return this.doTell();
  }
}

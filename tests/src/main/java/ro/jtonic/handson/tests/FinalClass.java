package ro.jtonic.handson.tests;

public final class FinalClass {
    
    public String ask(){
        System.out.println("final class, normal method");
        return "I'm Final class!!!";
    }
    
    public final String say(){
        System.out.println("final class, final method");
        return "I am final method!!!!";
    }
}

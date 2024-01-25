package oops._3_Concepts._2_abstract;

public class Driver extends AbstractClass {

    public static void main(String[] args) {
        Driver d = new Driver();
        d.abstractMethod();
        d.normalMethod();
    }
    @Override
    public  void abstractMethod() {
        System.out.println("abstract method");
    }
}

package oops._3_Concepts._4_interface;

/*
    Interface is blue print of classes,
    specifies what class MUST do(not how).
    - only have method declaration
    - all method are abstract
 */
public interface InterfaceDemo {
    static final String a = "Static Constant";

    // can't implement
    public void m1();

    // can't implement
    public abstract  void m2();

    static void m3() {
        // can implement
        System.out.println("Static method in Interface");
    }

    default void m4() {
        // can implement
        System.out.println("default Method in INTERFACE");
        m5();
    }

    private void m5() {
        // can implement
        System.out.println("private method in INTERFACE");
    }
}


class Test implements InterfaceDemo {

    public static void main(String[] args) {
        Test t =new Test();
        t.m1();
        t.m2();
        t.m4();
        InterfaceDemo.m3();
    }
    @Override
    public void m1() {
        System.out.println("Abstract method 1");
    }

    @Override
    public void m2() {
        System.out.println("Abstract method 2");

    }
}
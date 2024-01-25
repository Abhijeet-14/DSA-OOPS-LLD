package oops._3_Concepts._2_abstract;

/*
    hiding internal implementation
        Abstract class are with INCOMPLETE implementation
        - cam have abstract and normal method
        - can not create object
 */
public abstract class AbstractClass {
    public  abstract void abstractMethod();

    public void normalMethod(){
        // we can define normal method & implementation in abstract class.
        // but we can implement in INTERFACE
        System.out.println("Normal method in abstract class");
    }
}

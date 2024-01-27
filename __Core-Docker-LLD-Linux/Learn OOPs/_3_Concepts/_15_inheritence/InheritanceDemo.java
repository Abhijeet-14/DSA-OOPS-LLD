package oops._3_Concepts._15_inheritence;

/*
    - Inheritance - IS-A relationship
    - Association - HAS-A relationship
    - Diff bw IS-A & HAS-A relationship

    Inheritance:
        mechanism to create a new Class, deriving old class.

    Inheriting all functionalities ==> IS-A rela.
        - means 'Developer IS-A employee'
        and 'Manager IS-A employee'
 */

class Parent{
    int var1;

    public void parentMethod(){
        System.out.println("Parent method");
    }
}

class Child extends Parent{
    int var2;

    public void childMethod(){
        System.out.println("Child Method");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Child ch = new Child();

        ch.var2 = 11;
        ch.childMethod();

        // can use parents variable and functions as well.
        ch.var1 = 10;   // can set parent variable
        ch.parentMethod(); // can call parent function
    }
}

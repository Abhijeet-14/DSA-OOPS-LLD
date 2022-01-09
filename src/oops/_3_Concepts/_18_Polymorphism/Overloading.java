package oops._3_Concepts._18_Polymorphism;
/*
    Overloading:
        method overloading is same name but having diff parameters inside same class.

    compile time polymorphism
 */
public class Overloading {

    public static void main(String[] args) {

        overloading(10);
        overloading("String");
    }

    public static void overloading(int a){}

    public static int overloading(String a){ return 1;}
}

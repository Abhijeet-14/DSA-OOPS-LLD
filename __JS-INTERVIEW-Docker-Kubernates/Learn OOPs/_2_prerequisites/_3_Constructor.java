package oops._2_prerequisites;

/*
Constructor
    1. Non-Parameterized
    2. Parameterized
 */

public class _3_Constructor {

    public static void main(String[] args) {
        Const c = new Const(10);

        System.out.println(c.a);
    }
}

class Const{
    public int a;

    // default constructor - non parameterized
    public Const(){}

    // Parameterized
    public Const(int a){
        // this points to current object
        this.a = a;
    }
}
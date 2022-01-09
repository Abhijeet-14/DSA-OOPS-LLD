package oops._3_Concepts._16_Inheritence_type;

/*
    Types of Inheritance (re-usability of code):
        1. Single Inheritance - 1 child & 1 parent
        2. Multilevel - inheriting from CHILD & child is inheriting PARENT
        3. Multiple - inheriting from PARENT1 & PARENT2.. NOT POSSIBLE
        4. Hierarchical
        5. Hybrid
 */

// Single Inheritance
// parent
class A {
}

// child
class B extends A {
}

// MultiLevel Inheritance
class C extends B {
}

// Multiple Inheritance - NOT POSSIBLE
//class D extends C, B {}

// but
// Multiple INTERFACE is possible
interface Ai {
    abstract void method1();
}

interface Bi {
    abstract void method2();
}

class E implements Ai, Bi {
    @Override
    public void method1() {
        // implement
    }

    @Override
    public void method2() {
        // implement
    }
}


public class Demo {
}

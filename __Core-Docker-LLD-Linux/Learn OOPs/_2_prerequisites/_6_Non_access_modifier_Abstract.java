package oops._2_prerequisites;

/*
    Non-Access-Modifier
        Abstract-Modifier:
            - applicable for classes and methods
                1. abstract class
                2. abstract method
            - it should NOT have any IMPLEMENTATION
            - can create Object of abstract class
 */


// Abstract class
abstract class AbstractClass{

    // doesn't have any implementation - sub_class implement them
    public abstract  void runIt();
}

// Sub-class CHILD
// use 'extends' keyword to use abstraction class
class SubClass extends  AbstractClass{
    @Override
    public void runIt() {
        System.out.println("Run it");
    }
}


public class _6_Non_access_modifier_Abstract{
    public static void main(String[] args) {
        SubClass sc =new SubClass();
        sc.runIt();
    }
}

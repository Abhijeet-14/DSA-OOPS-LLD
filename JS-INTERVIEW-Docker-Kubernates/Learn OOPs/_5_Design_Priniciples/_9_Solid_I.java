package oops._5_Design_Priniciples;

/*
    I - Interface Segregation Principle
        - it says, a client should not be FORCED to implement
            an interface that it DOES NOT required.
        - means breaking interface into small small interfaces.
            so purpose can be achieved
    Example
        'Worker' Interface(work() & sleep())
        so..
            if 'Human' implements Worker
            then Human(work() & sleep())
        also,
            if 'Robot' implements Worker
            then Robot(work() & sleep())
          But that is not possible in REAL.
    So,
        sub-interface needs to create.
        'Worker' interface &
        'Sleeping' interface
        so,
            Human -> Worker & Sleeping
                Human(work() & sleep())

            Robot -> Worker
                Robot(work())
 */

// Parent Interface
interface Worker{
    public abstract void work();
}

// Child Interface
interface Sleeping{
    public abstract void sleep();
}

// Implements BOTH Worker & Sleeping
class Human implements Worker, Sleeping{

    @Override
    public void work() {}

    @Override
    public void sleep() {}
}

// Implements only WORKER
class Robot implements Worker{

    @Override
    public void work() {}
}

public class _9_Solid_I {

    public static void main(String[] args) {
        Human h = new Human();
        h.work(); // Worker's method
        h.sleep(); // Sleeping's method

        Robot r =new Robot();
        r.work(); // Worker's method
//        r.sleep(); // NOT Sleeping's Method
    }
}

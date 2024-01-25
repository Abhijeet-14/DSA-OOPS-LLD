package oops._5_Design_Priniciples;

/*
    SOLID
    L -  Liskov Substitution Principle
        - a class can be replaced by its sub-class in all
            particular usage scenarios.

    e.g., 'class Bird' & 'class Sparrow'
        Bird can Fly
        - Sparrow extends Bird
            so, sparrow also fly... bcoz of parent
        Now,
        - Ostrich extend Bird
            and Ostrich Also fly... bcoz of parent.
            but in real Ostrich doesn't fly.

        So,
            to make a DISTINGUISH.. we can make a subclass FLY.

        - 'GrandParent' class Bird & 'Parent' class FlyingBird
         so,
            FlyingBird extends Bird
         and
            Sparrow extends FlyingBird
         Hence... Sparrow has FlyingBird & Bird property.

        - Now,
            Ostrich only extends Bird.
            So,
                it has only Bird property, no flying property.
 */

// GrandParent
class Bird{
    public void info(){}
}

// Parent -> GrandParent
class FlyingBird extends Bird{
    public void fly(){}
}

// Sparrow -> Parent -> GrandParent
class Sparrow extends FlyingBird{
    public void color(){}
}

class Ostrich extends Bird{
    public void color(){}
}

public class _8_SOLID_L_Liskov_Substitution_Principle {
    public static void main(String[] args) {
        Sparrow s = new Sparrow();
        s.color(); // own method
        s.fly(); // parent method - FlyingBird
        s.info(); // GrandParent Method - Bird

        Ostrich os = new Ostrich();
        os.color(); // own method
        os.info(); // GrandParent Method - Bird
//        os.fly(); // NOT available.

        // this is Liskov principle...
        // if a class can be make sub-class under some condition..
        // then make sub-class.
    }
}

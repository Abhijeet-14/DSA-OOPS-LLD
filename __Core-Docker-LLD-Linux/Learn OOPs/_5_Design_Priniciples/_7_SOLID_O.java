package oops._5_Design_Priniciples;

/*
    O - Open Closed Principle
        - it states...
            entities(classes, module, function etc) should be open
            for EXTENSION BUT closed for MODIFICATION


        - assume a class CalculateArea{}..
            - it works for Circle and Rectangle
            - now we want it to work for triangle also
            - so we need add logic to this class...
            HENCE, violates the Open Closed Principle.
 */

class Reactange {
}

class Circle {
}

class CalculateArea {

    Object shape;

    public CalculateArea(Object shape) {
        this.shape = shape;
    }

    public void calculate() {
        if(shape instanceof Reactange) {
            Reactange r = (Reactange) shape;
            System.out.println("Rectangle Area: " + r);
        } else if(shape instanceof Circle) {
            Circle c = (Circle) shape;
            System.out.println("Circle Area " + c);
        }
        // NOW we don't have logic for any other shape.
        // if You'll try TRIANGLE... then we need to implement its logic.
    }
}
// this Violating Open-Close-Principle...
// bcoz for any new shape, we need to make changes in CalculateArea.

// so we should make 'abstract class'
abstract class AreaCalculate{
    Object shape;

    public abstract void calculate(Object shape);
}

class React extends AreaCalculate{

    @Override
    public void calculate(Object shape) {
        System.out.println("Rectangle Area");
    }
}
class Cir extends AreaCalculate{

    @Override
    public void calculate(Object shape) {
        System.out.println("Circle Area");
    }
}class Triangle extends AreaCalculate{

    @Override
    public void calculate(Object shape) {
        System.out.println("Triangle Area");
    }
}
// HENCE, Open-Closed-Principle achieved.

public class _7_SOLID_O {
    public static void main(String[] args) {
        CalculateArea c = new CalculateArea(new Circle());
        c.calculate();

        CalculateArea r = new CalculateArea(new Reactange());
        r.calculate();
    }
}


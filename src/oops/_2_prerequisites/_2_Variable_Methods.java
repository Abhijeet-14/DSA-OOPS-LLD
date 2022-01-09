package oops._2_prerequisites;

/*
   Variable:
        1. instance-variable = object variable
        2. local-variable = function variable
        3. static-variable = class variable
*/

/*
    Method:
        - public private protected
        - static method - class method
        - normal method - object method
 */
public class _2_Variable_Methods {


    public static void main(String[] args) {

        Fan1 myFan = new Fan1();
        myFan.turnOn();
        myFan.isOn = true;
        System.out.println(myFan.isOn);
        System.out.println(myFan.staticVariable);

        Fan1 urFan = new Fan1();
        urFan.staticVariable = 9;
        System.out.println(myFan.staticVariable);
    }
}

class Fan1 {

    // instance variable
    protected boolean isOn = false;

    // class variable
    public static int staticVariable;

    public void turnOn(){
        // local variable - gets initialized when invoke turnOn()
        int abc = 10;

        System.out.println("Fan has Turn ON");
    }
}

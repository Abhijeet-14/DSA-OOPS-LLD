package oops._2_prerequisites;


// it can have one 'public class'
public class _1_Classes {

    public static void main(String[] args) {
        Fan myFan = new Fan();

        myFan.turnOn();
    }
}

// it can have multiple non-public class
class Fan {

    private boolean isOn;

    public void turnOn(){
        System.out.println("Fan has Turn ON");
    }
}

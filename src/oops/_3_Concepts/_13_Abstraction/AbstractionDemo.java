package oops._3_Concepts._13_Abstraction;

/*
    Abstraction:
        it is an act of REPRESENTING essential features of CLASS w/o
        including details or explanation

    hiding of data - called DATA HIDING
    hiding internal implementations - ABSTRACTION

    Abstraction is achieved by:
        - interface
        - abstract class
 */

import java.util.ArrayList;
import java.util.List;

interface Mobile {
    public abstract void calling(String number);

    public abstract void sendMsg(String message);
}


class Apple implements Mobile {

    // instance variable
    private List<String> allContacts = new ArrayList<>();

    @Override
    public void calling(String number) {
        allContacts.add(number);
        System.out.println("Calling " + number);
    }

    @Override
    public void sendMsg(String message) {
        System.out.println(message + ", Message sent to all contacts: " + allContacts);
    }
}


public class AbstractionDemo {

    public static void main(String[] args) {
        // abstraction through INTERFACE
        Apple ap = new Apple();
        ap.calling("123456");
        ap.calling("098765");
        ap.sendMsg("Welcome!!!");

        Apple ab = new Apple();
        ab.sendMsg("Hey Stop!!");

        // abstraction through ABSTRACT CLASS
        Nokia nk = new Nokia();
        nk.calling("123");
        nk.calling("345");
        nk.sendMsg("Hello");
        nk.allContacts();

        Nokia nk2 = new Nokia();
        nk2.allContacts();
    }
}

abstract class Mobilee {
    protected List<String> allContacts = new ArrayList<>();

    abstract void calling(String number);

    abstract void sendMsg(String message);

    public void allContacts() {
        System.out.println(allContacts);
    }
}

class Nokia extends Mobilee {

    @Override
    void calling(String number) {
        allContacts.add(number);
        System.out.println("Calling " + number);
    }

    @Override
    void sendMsg(String message) {
        System.out.println("Send message: " + message);
    }
}

package oops._5_Design_Priniciples;

/*
    S - Single Responsibility principle

    A class should have one & only one reason to change

    - assume a class is updating DB and send mail... 2 task
 */

class MultipleTask{
    public void updateDB(){}

    public void sendMail(){}
}

// Instead we should 2 class

class UpdateDB {
    public void updateDB(){}
}

class sendMail{
    public void sendMail(){}
}

public class _6_SOLID_S {
}

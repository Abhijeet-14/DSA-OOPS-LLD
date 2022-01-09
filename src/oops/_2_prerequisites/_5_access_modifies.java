package oops._2_prerequisites;

/*
    Modifier set accessibility of classes or methods or any members
        1. public - can access anywhere
        2. private -  can access only its class
        3. protected - can access only to class & sub-class
        4. default


    Note: if method is public BUT class is not public... then we can't access that method
 */
public class _5_access_modifies {
    public static void main(String[] args) {

    }
}

class Fan2{

    // Public method can be accessed anywhere
    public void publicMethod(){
        System.out.println("Public method can be accessed anywhere");
    }
}
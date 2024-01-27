package oops._2_prerequisites;

/*
    Final keyword
        - non-AM applicable for classes, variable & methods
        - work as CONSTANT

    Static Keyword
        - applicable for variables & methods
        - use to define class members
 */
public class _7_Non_access_modifier_Final_Static {

    // final - variable
    static final int a =10;

    public static void main(String[] args) {
        System.out.println("Below code gives error, 'Cannot assign a value to final variable 'a''");
        // a =11;
    }

    // final-method
        // now this method can't be override at any place.
    public static final void att(){
        System.out.println("FINAL METHOD!!");
    }
}

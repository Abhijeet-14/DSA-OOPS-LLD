package oops._5_Design_Priniciples;

/*
    State Design Pattern: Say, we have,
        Operation 1
        op 2
        op 3
        op 4
        op 5
        op 6

       and we know,
       op 1 & op 2  => only possible in STATE 1 of an Object
       op 4 & 5 => only possible in STATE 2 of an Object
       op 3 & 6 => only possible in STATE 3 of an Object


       this flow of Object, STATE Design Pattern.

       e.g.,
        ATM -> State_1. ATM - No Cards
            -> State_2. ATM - has Card - only possible after STATE 1
            -> State_3. PIN Verify - only Possible after STATE 2
            -> State_4. Operation Selection - only Possible after STATE 3
            -> State_5. Perform Operation - only Possible after STATE 4
            -> State_6. RemoveCard - only Possible after STATE 2
            -> goes back to state 1.
 */
public class _1_Design_Pattern_State_Pattern {
}

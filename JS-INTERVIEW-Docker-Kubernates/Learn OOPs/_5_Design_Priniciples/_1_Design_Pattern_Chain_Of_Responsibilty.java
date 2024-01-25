package oops._5_Design_Priniciples;

/*
    State Design Pattern: Say, we have,
       Request => [ Process 1, Process 2, Process 3, Process 4, .... , Process N ]

       so to full-fill our REQUEST -> we check Process 1
       if Process 1 -> Pass -> return RESPONSE
                    -> Fail -> call Process 2
       Similarly, Process 2 -> pass -> return RESPONSE
                            -> Fail -> call Process 3 ....
        Same flow follow till Process N, if previous fail.

        Example:
        ATM - 2 - 1000 Notes, 3 - 500 Notes, 2 - 100 Notes
        withdraw 2700 ->
            so ATM will first take 1700/1000 -> 1 - 1000 Note
            700 remaining -> 700/500 -> 1 - 500 Note
            200 remaining -> 200/100 -> 2 - 100 Note

         So,
            1000 Notes not able to make amount = 0 -> Fail -> Try 500 -> if Fail -> try -> 100 -> if Fail -> Not enough Fund

 */
public class _1_Design_Pattern_Chain_Of_Responsibilty {
}

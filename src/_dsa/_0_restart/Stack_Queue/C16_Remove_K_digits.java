package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class C16_Remove_K_digits {
    // Given a non-negative integer num by represented as a string.
    // remove k digits from the number so that the new number is the smallest possible.

    // Note:
    //      1. length num < 10002 & will be >= k
    //      2. given num doesn't contain any leading zero.

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        // Logic:
        // whenever find a dip -> remove the peek
        // 2 7(peek) 3(dip) 1 => k = 1

        Stack<Integer> s = new Stack<>();

        for(int i=0; i<num.length();i++){
            int curr = Character.getNumericValue(num.charAt(i));

            while(!s.isEmpty() && s.peek()>curr){
                s.pop();
                k--;
            }

            if(!s.isEmpty() || curr != 0)
                s.add(curr);
        }

        while(!s.isEmpty() && k-- == 0)
            s.pop();
        if(s.isEmpty())
            System.out.println("0") ;

        String res = "";
        while(!s.isEmpty()){
            res += String.valueOf(s.pop());
        }
        num = "";
        for(int i=0; i<res.length(); i++){
            num+=res.charAt(res.length() - i-1);
        }

        System.out.println(num);
    }
}

package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class C13_Valid_Parenthesis_String {
    public static void main(String[] args) {
        String str = "*(";

        boolean isValid = isValid(str);

        System.out.println(isValid);
    }

    private static boolean isValid(String str){
        Stack<Integer> leftIdx = new Stack<>();
        Stack<Integer> starIdx = new Stack<>();

        for(int i=0; i<str.length(); i++ ){
            char curr = str.charAt(i);

            if(curr == '('){
                leftIdx.add(i);
            }else if (curr == '*'){
                starIdx.add(i);
            }else{
                // both stack is empty... no * or ( for pair up with )
                if(leftIdx.isEmpty() && starIdx.isEmpty())
                    return false;
                // left ( exists
                else if(!leftIdx.isEmpty())
                    leftIdx.pop();
                // star available
                else{
                    starIdx.pop();
                }
            }
        }

        while(!leftIdx.isEmpty() && !starIdx.isEmpty()){
            // if left right Index > star rightMost Index
            // e.g *(... 1 > 0 => no pairUp possible.
            if(leftIdx.pop() > starIdx.pop())
                return false;

        }

        return leftIdx.isEmpty();
    }
}

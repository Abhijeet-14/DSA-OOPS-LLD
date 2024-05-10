package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class VVI_Valid_Parentheses_Star {
    // Question:
    // Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
    //
    //The following rules define a valid string:
    //
    //Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    //Any right parenthesis ')' must have a corresponding left parenthesis '('.
    //Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    //'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

    public static void main(String[] args) {
        String str = "(**))*)";

        // use 2 stack - TC-O(N), AS-O(N)
        boolean isValid = isValidString(str);
        System.out.println(isValid);
    }

    private static boolean isValidString(String str){
        Stack<Integer> leftParenthesesId = new Stack<>();
        Stack<Integer> starId = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(curr == '(' )
                leftParenthesesId.add(i);
            else if(curr == '*')
                starId.add(i);
            else{
                if(leftParenthesesId.isEmpty() && starId.isEmpty())
                    return false;
                else if(!leftParenthesesId.isEmpty()){
                    leftParenthesesId.pop();
                }else
                    starId.pop();
            }
        }

        while(!leftParenthesesId.isEmpty() && !starId.isEmpty()){
            if(leftParenthesesId.pop() > starId.pop())
                return false;
        }

        return leftParenthesesId.isEmpty();
    }
}

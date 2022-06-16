package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class C4_Parenthese_Checker {
    public static void main(String[] args) {
        String str = "{(})";

        boolean isValid = isValid(str);
        System.out.println("isValid: " + isValid);
    }

    private static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(char _char: str.toCharArray()){
            if(_char == '{' || _char == '(' || _char == '[')
                s.add(_char);
            else {
                char _pop = s.peek();
                if (
                        (_char == '}' && _pop == '{') ||
                        (_char == ')' && _pop == '(') ||
                        (_char == ']' && _pop == '[')
                )
                    s.pop();
                else
                    return false;
            }
        }

        return s.isEmpty();
    }

}

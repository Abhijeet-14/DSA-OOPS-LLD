package ___KT_C3;

import java.io.*;
import java.util.*;

/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.

Any right parenthesis ')' must have a corresponding left parenthesis '('.

Left parenthesis '(' must go before the corresponding right parenthesis ')'.

'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

An empty string is also valid

Examples:

input: "***())", output: True, '*' interpretated as '(' // s -

input: "(*)", output: True, '*' interpretated as '' // s ( * , )

input: "((**)", output: True, '*' interpretated as ')' // s
input: "(**))))", output: False // s )

input: "***(", output: False // s - not empty

input: "(***", output: True, 1 '*' interpretated as ')' the rest as '' // s - NOT EMPTY

Constraints:

1 <= s.length <= 100

s[i] is '(', ')' or '*'
*/

// * after (
// push to stack only (
// * after (
// checking with )
// if stack empty .. no of ) - 3
//  * 4 or 3, 2


// Main class should be named 'Solution'
public class Question_1 {

    public static void main(String[] args) {
        String str = "(**";
        System.out.println(solve(str));
    }

    private static boolean solve(String str){
        Stack<Character> s = new Stack<>();

        int starCountBefore = 0;
        int starCountAfter = 0;
        int startCount = 0;
        for(char ch: str.toCharArray()){
            if (ch == '*')
                startCount++;
        }

        for(char ch: str.toCharArray()){
            if(ch == '('){
                s.push(ch);
            }

            if(ch == ')' && !s.isEmpty()){
                // if(!s.isEmpty()){/
                s.pop();
                // }/
                // else if (starCountBeforeRightP > 0){
                //     starCountBeforeRightP--;
                // }else {
                //     return false;
                // }
            }
            else{
                if(starCountBefore < 0)
                    return false;
                else
                    starCountBefore--;
            }
            // (**))
            if(ch == '*'){ // (**
                starCountBefore++; // 2 , 2
            }

        }
        starCountAfter = startCount - starCountBefore;
        if(!s.isEmpty() && s.size()<=starCountBefore){
            return true;
        }
        else
            return false;
    }
}

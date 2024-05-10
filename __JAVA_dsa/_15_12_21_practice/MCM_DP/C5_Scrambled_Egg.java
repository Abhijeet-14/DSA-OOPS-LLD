package _dsa._15_12_21_practice.MCM_DP;

import java.util.HashMap;
import java.util.Map;

public class C5_Scrambled_Egg {
    // Ques: Given 2 string 'a' & 'b', if they are SCRAMBLED, then -> T -> Else -> F
    // Scrambled String??:
    // Given string str, we can represent it as a binary tree by partitioning it into two non-empty substrings recursively.

    public static void main(String[] args) {

        String a = "great";
        String b = "rgeat";

        boolean rec = solve(a, b);
        System.out.println("Recursion: " + rec);

        boolean memo = solve_memo(a, b);
        System.out.println("Memoization: " + memo);
    }


    static Map<String, Boolean> map = new HashMap<>();

    private static boolean solve_memo(String a, String b) {
        // Empty - We only accept Non-Empty
        if(a.length() < 1 || b.length() < 1)
            return false;

        if(a.length() != b.length())
            return false;

        // Swap not possible bw 'great' & 'great'
        if(a.equals(b))
            return true;

        int n = a.length();
        boolean flag = false; // assuming Non-swap

        String key = a + ":" + b;
        if(map.containsKey(key))
            return map.get(key);

        for(int i = 1; i < n; i++) {
            // a = great & b=rgeat, i =2
            // a[0:2] = gr & b[3:5] = at
            boolean left_a_right_b = solve(a.substring(0, i), b.substring(n - i, n));
            // a[2:5] = eat & b[0:3] = rge
            boolean right_a_left_b = solve(a.substring(i, n), b.substring(0, n - i));
            // a[0:2] = gr & b[0:2] = rg
            boolean left_a_left_b = solve(a.substring(0, i), b.substring(0, i));
            // a[2:5] = eat & b[2:5] = eat
            boolean right_a_right_b = solve(a.substring(i, n), b.substring(i, n));

            // Swap & Non-Swap
            if((left_a_right_b && right_a_left_b) || (left_a_left_b && right_a_right_b)) {
                flag = true;
                break;
            }
        }

        map.put(key, flag);
        return flag;
    }

    private static boolean solve(String a, String b) {
        // Empty - We only accept Non-Empty
        if(a.length() < 1 || b.length() < 1)
            return false;

        if(a.length() != b.length())
            return false;

        // Swap not possible bw 'great' & 'great'
        if(a.equals(b))
            return true;

        int n = a.length();
        boolean flag = false; // assuming Non-swap

        for(int i = 1; i < n; i++) {
            // a = great & b=rgeat, i =2
            // a[0:2] = gr & b[3:5] = at
            boolean left_a_right_b = solve(a.substring(0, i), b.substring(n - i, n));
            // a[2:5] = eat & b[0:3] = rge
            boolean right_a_left_b = solve(a.substring(i, n), b.substring(0, n - i));
            // a[0:2] = gr & b[0:2] = rg
            boolean left_a_left_b = solve(a.substring(0, i), b.substring(0, i));
            // a[2:5] = eat & b[2:5] = eat
            boolean right_a_right_b = solve(a.substring(i, n), b.substring(i, n));

            if((left_a_right_b && right_a_left_b) || (left_a_left_b && right_a_right_b)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}

package __Interview_pocketFM.Round1;

import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        String str = "abcbad";

        int ans = solve(str);

        System.out.println("O/p: " + ans);
        // len max substring whose characters are unique
        // Example:
        // abcdba - 4 - abcd & cdba
        // abcdbac - 4 - abcd & cdba
        // abcdbaf - 5

        // left - right
        // CHAR - 256;
        // arr[CHAR] -1
        // arr[CHAR] - char - occurence
        // count = 0
        // a - 0, count++
        // b - 1, count++
        // c- 2, count++
        // d - 3, count++
        // b -> arr[b] != -1 -> left - arr[b] + 1 => arr[CHAR], -1 => max = Max(count, max) => count =0
        // c - 2
        // d - 3
        // b - 4
        // a - 5



    }

    public static int solve(String str){
        int max = 0;
        int count = 0;

        int CHAR = 256;

        int occurence[] = new int[CHAR];

        Arrays.fill(occurence, -1);

        int i =0;
        while(i<str.length()){ // abcdbaf
            char curr_char = str.charAt(i); // c
            if(occurence[curr_char] != -1){
                i = occurence[curr_char] +1; // next non-repeating index

                max = Math.max(count, max); // global loop
                count = 0; // sub-loop
                Arrays.fill(occurence, -1);
            }else{
                count++;
                occurence[curr_char] = i;
                i++;
            }
        }

        max = Math.max(max, count);
        return max;
    }
}

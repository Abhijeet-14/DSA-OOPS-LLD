package _dsa._0_LeetCode_Village.String_Matching;

public class _3_Maximum_Repeating_Substring {
    // Question: https://leetcode.com/problems/maximum-repeating-substring/submissions/

    public static void main(String[] args) {

    }

    public static int maxRepeating(String sequence, String word) {


        int count = 0;

        String s = word;

        while(sequence.contains(s)){
            s += word;
            count++;
        }

        return count;
    }
}

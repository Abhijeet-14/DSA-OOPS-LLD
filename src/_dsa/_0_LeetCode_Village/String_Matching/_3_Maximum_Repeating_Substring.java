package _dsa._0_LeetCode_Village.String_Matching;

public class _3_Maximum_Repeating_Substring {
    // Question: https://leetcode.com/problems/maximum-repeating-substring/submissions/

    // Edge Case: it is a substring, so in 'ababc' & 'ab' will work as... abab is repeating
    //              but in 'abcab', ab is only there.. becoz in 2 times ab is not substring... it will work in sub-sequence
    public static void main(String[] args) {
        System.out.println(maxRepeating("abcab","ab"));
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

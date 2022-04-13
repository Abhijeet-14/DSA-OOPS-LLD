package _dsa._0_LeetCode_Village.String_Matching;

public class _2_Rotate_String {
    // Question: https://leetcode.com/problems/rotate-string/

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abced", "cdeab"));
    }

    public static boolean rotateString(String s, String goal) {

        if(s.length() != goal.length())
            return false;

        String newStr = s + s;

        int idx = newStr.indexOf(goal);

        return idx != -1 ? true: false;
    }
}

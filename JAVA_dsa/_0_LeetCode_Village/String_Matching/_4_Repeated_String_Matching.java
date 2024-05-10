package _dsa._0_LeetCode_Village.String_Matching;

public class _4_Repeated_String_Matching {
    // Question: https://leetcode.com/problems/repeated-string-match/submissions/

    public static void main(String[] args) {

    }
    public static int repeatedStringMatch(String a, String b) {
        String str = "";
        int count =0;

        if(b.length() == 0)
            return 0;

        do{
            str+=a;
            count++;
        }while(!str.contains(b) && str.length() < 1 + Math.pow(10,4));

        if(!str.contains(b)){
            System.out.println(b + " " +str);
            return -1;}

        return count;
    }
}

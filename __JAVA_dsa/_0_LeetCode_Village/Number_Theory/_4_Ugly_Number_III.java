package _dsa._0_LeetCode_Village.Number_Theory;


import java.util.ArrayList;
import java.util.List;

public class _4_Ugly_Number_III {
    /* Problem Statement: 
    * An ugly number is a positive integer that is divisible by a, b, or c.
    * Given four integers n, a, b, and c, return the nth ugly number.    
    */
    public static void main(String[] args) {

    }
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        /* Logic:

        Time Complexity: 
         */
        List<Integer> res = new ArrayList<>();
                
        int N = (int)Math.pow(10,9);
        
        for(int i=2; i<N; i++){
            if(i %a == 0 || i%b == 0 || i%c == 0 ){
                System.out.println(i);
                res.add(i);
            }
        }
        if (res.size() > 0)
            return res.get(n-1);
        return -1;
    }
}

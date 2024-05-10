package _dsa._0_LeetCode_Village.Number_Theory;


import java.util.Arrays;

public class _1_is_prime {
    public static void main(String[] args) {

    }

    private static int isPrime(int n){
        /* Logic: - Seive Of EartoSenthenes
        * 0 & 1 is not prime.
        * from 2 we start checking---
        * Create an boolean Array of 'n' size.
        * fill all element to TRUE.
        * start at 2, mark all multiple of 2 to FALSE. [4-F, 6-F, 8-F, 10-F, 12-F]
        * start at 3, mark all multiple of 3 to False. [6-F, 9-F, 12-F, 15-F]
        * start at 4, mark all multiple of 4 to FALSE. [4-F, 8-F, 12-F, 16-F]
        * similarly do till 'n'.
        * Finally, we get..
        * [0-F, 1-F, 2-T, 3-T,4-F, 5-T, 6-F, 7-T,8-F, 9-F, 10-F...]
        * count all element which is TRUE.
        */

        // Corner Case
        if(n<=1)
            return 0;

        boolean isPrime[] = new boolean[n];
        
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        
        
        for (int i = 2; i * i <= n; i++) {
			for (int j = 2 * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}	
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            if (isPrime[i] == true)
                count++;
        }
        
        return count;
    }
}

class Solution {
    public int countPrimes(int n) {
        
        boolean isPrime[] = new boolean[n];
        
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        
        
        for (int i = 2; i * i <= n; i++) {
			for (int j = 2 * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}	
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            if (isPrime[i] == true)
                count++;
        }
        
        return count;
    }
    
}

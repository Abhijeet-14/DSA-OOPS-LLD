package _dsa._0_LeetCode_Village.Number_Theory;


public class _2_add_digits {
    // PS: Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

    public static void main(String[] args) {

    }

    public staic int addDigits(int num) {
        /* Logic: 
        * if num is < 10 -> Single Digit => return num
        * check sum >=10 with while
        * YES, then make sum = 0
        * create new sum with while
        * And make num = sum of digits
        * if sum <10 -> signle digit -> 
        * return sum.
        */
        if(num<10)
            return num;
        
        int sum=num;
        
        while(sum>=10){
            sum=0;
            while(num>0){
                sum += num%10;
                num = num/10;
            }
            num = sum;
        }
     
        return sum;
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

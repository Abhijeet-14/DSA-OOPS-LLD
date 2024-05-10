package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/submissions/
 * 
 * Response: OPTIMIZED SOL.
 * 
 * */

public class M1_VERY_IMPORTANT_Min_No_Steps_to_Make_2_Strings_Anagram {

	public static void main(String[] args) {
			System.out.println("VERY VERY VERY IMPORTANT QUESITON \n");
			System.out.println("Optimized O(n):  99.11%");
		
		String s=  "leetcode";
		String t=  "practice";
		
		int ans = optimized(s,t);
		
		System.out.println(ans);
	}
	
	 public static int optimized(String s, String t) {
	        int char_count[] = new int[26];
	        
	        for(char ch: s.toCharArray()){
	            char_count[ch-'a']++;
	        }
	        
	        for(char ch: t.toCharArray()){
	            char_count[ch-'a']--;
	        }
	        
	        int count = 0;
	        for(int val: char_count){
	        	// as val can be both -ve & +ve
	            if(val!=0)
	                count += Math.abs(val);
	        }
	        
	        // will count all the unmatched char
	        // but we can by replacing any one will make match with other char in other string
	        // so, we count as 1
	        // Therefore, divide by 2.
	        return count/2;
	    }

}

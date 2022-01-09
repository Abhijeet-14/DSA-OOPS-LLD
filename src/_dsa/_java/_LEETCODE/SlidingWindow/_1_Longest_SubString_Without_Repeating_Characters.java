package _dsa._java._LEETCODE.SlidingWindow;

import java.util.*;


/* PROBLEM STATEMENT:
 	Given a string s, find the length of the longest substring without repeating characters.
 	e.g.,
 	Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
	
	Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
	
	Example 3:	
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	
	Example 4:	
		Input: s = ""
		Output: 0
 */


public class _1_Longest_SubString_Without_Repeating_Characters {

		// Brute Force:	TC( O(n^2) ) & SC( O(n) )
			//
			// we first fix the FIRST Character of every new SubString
			// then check the max SubString length from that character.
			// so from i -> 0 - n-1
			// j-> i+1 - n-1
	
	    public static int lengthOfLongestSubstring_1(String s) {
	        
	        Set<Character> storeCharacter = new HashSet<>(); 
	        
	        
	        int mx=0;
	        int count=0;
	        for(int index=0;index < s.length(); index++){
	            
	            storeCharacter.add(s.charAt(index));
	            count = 1;
	            if(mx<count) 
	                mx=count;
	            
	            for(int jndex=index+1;jndex <s.length(); jndex++){
	                if(storeCharacter.contains( s.charAt(jndex) )){
	                    count = 0;
	                    storeCharacter.clear();
	                    break;
	                }  
	                else{
	                    storeCharacter.add(s.charAt(jndex));
	                    count++;

	                }
	                
	            if(mx<count)
	                mx = count;
	        }
	            
	        }
	               
	        return mx;
	    }
	    
	    
	    
	    // Approach 2: 
	    		// TC - O(2n) => O(n)
	    		// In the worst case each character will be visited twice by i and j.
	    
	    		// Space complexity : O(k) space for the sliding window, where k is the size of the Set.
	    
	    public static int lengthOfLongestSubstring_2(String s) {
	            int n = s.length(), ans = 0;
	           
	            Map<Character, Integer> map = new HashMap<>(); // current index of character
	           
	            // try to extend the range [i, j]
	            for (int j = 0, i = 0; j < n; j++) {
	                if (map.containsKey(s.charAt(j))) {
	                    i = Math.max(map.get(s.charAt(j)), i);
	                }
	                ans = Math.max(ans, j - i + 1);
	                map.put(s.charAt(j), j + 1);
	            }
	            return ans;
	        }
	    
	    
	    // Approach 3:
	    		// 2 took 2*n times to as visiting each element twice.
	    		// use HashMap... so that, 
	    		// we can skip the characters immediately when we found a repeated character.
	    
	    public static int lengthOfLongestSubstring_3(String s) {
	        
	        Map<Character, Integer> map= new HashMap<>();
	        int start=0, len=0;
	        
	        // abacd
	        for(int i=0; i<s.length(); i++) {
	            char c = s.charAt(i);
	            if (map.containsKey(c)) {
	                if (map.get(c) >= start) 
	                    start = map.get(c) + 1;		
	                	// if we get duplicate 
	                	// we find the index of First Occurrence of the Duplicate character
	                	// then assume that, our Substring starts from next to it.
	                	// i=0; start=1; ==>> substring starts from 1 index(i+start)
	                	// i=0; start=1; ==>> substring starts from 1 index(i+start)
	            }
	            len = Math.max(len, i-start+1);		// length of SubString
	            map.put(c, i);
	        }
	        
	        return len;
	    }
	    
	    
	    	
	    public static void main(String args[]) {
	    	String s = "abaacd";
	    	
	    	System.out.println(lengthOfLongestSubstring_3(s));
	    }
}

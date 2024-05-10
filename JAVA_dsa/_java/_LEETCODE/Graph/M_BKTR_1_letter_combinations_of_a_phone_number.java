package _dsa._java._LEETCODE.Graph;
import java.util.*;

// Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Response: Solved! optimization requires, TC - O(3^N X 4^M); N: input with 3 letter; M: input with 4 letter 
// OPTIMIZE: ???

public class M_BKTR_1_letter_combinations_of_a_phone_number {
    
	static String a[] = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new  Scanner(System.in);
		
		System.out.println("digits.length:[0,4] && digits[i] is a digit in the range ['2', '9'].");
		String input = sc.nextLine(); 
		
		System.out.println("\nMy Approach: TC-O(3^N X 4^M), SC-O(3^N X 4^M); N: input with 3 letter; M: input with 4 letter");
		System.out.println(letterCombinations(input));
		
		System.out.println("\nOPTMIZE: ???");
	}
    
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        
        List<String> combi = new ArrayList<>();
        
        String word = "";
        
        int next = 0;
        int in = Character.getNumericValue(digits.charAt(next)) - 2;
        
        for(int i=0; i<a[in].length(); i++)
            dfs(combi, digits, word, i, next, in);
        
        return combi;
    }
    
    public static void dfs(List<String> combi, String digits, String word, int count, int next, int in){
        
        char val = a[in].charAt(count);
        word += val;
                
        if(word.length() == digits.length()){
            combi.add(word);
            return;
        }

        next++;
        in = Character.getNumericValue(digits.charAt(next)) -  2;
        
        for(int i=0; i<a[in].length(); i++)
            dfs(combi, digits, word, i, next, in); 
        
    } 

}

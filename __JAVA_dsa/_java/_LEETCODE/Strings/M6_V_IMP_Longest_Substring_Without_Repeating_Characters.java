package _dsa._java._LEETCODE.Strings;


/*
 * Question: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class M6_V_IMP_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String s = "tmmzxkt";
		
		System.out.println("MyApproach: 99.83% faster");
		myApproach(s);
	}

	private static void myApproach(String s) {
		int char_count[] = new int[256];
        int n = s.length();
        
        int count = 0;
        int mx = Integer.MIN_VALUE;
        
        int i=0, j=0;
        
        while(i<n && j<n){
            char ch = s.charAt(j);
            if(char_count[ch] == 0){
                char_count[ch]++;
                count++;
            }
            else{
                int k;
                for( k=i; k<j;k++){
                    if(s.charAt(k) == ch)
                        break;
                    count--;
                    char_count[s.charAt(k)]--;
                }
                i=k+1;
            }
            if(count>mx)
                mx = count;
            j++;
        }
        
        System.out.println(mx==Integer.MIN_VALUE ? 0 : mx);
	}

}

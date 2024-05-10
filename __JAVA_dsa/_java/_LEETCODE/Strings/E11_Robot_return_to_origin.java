package _dsa._java._LEETCODE.Strings;

public class E11_Robot_return_to_origin {

	public static void main(String[] args) {
		
//		boolean ans = myApproach("UDRLL");
		
		boolean ans = optimized("UDRLL");
		
		System.out.println(ans);
	}
	
	 public static boolean optimized(String moves) {
	        int[] arr = new int[26];
	        arr['U' - 'A'] = 1;
	        arr['D' - 'A'] = -1;
	        arr['R' - 'A'] = 20001;
	        arr['L' - 'A'] = -20001;
	        long res = 0;
	        for(char ch : moves.toCharArray()) {
	            res = res + arr[ch - 'A'];
	        }
	        return res == 0;
	    }
	
	public static boolean myApproach(String moves) {
        int x =0; int y=0;
        
        for(char move: moves.toCharArray()){
            if(move == 'R')
                x++;
            else if(move == 'U')
                y++;
            else if(move == 'D')
                y--;
            else if(move == 'L')
                x--;
        }
        
        return x==0 && y==0;
    }

}

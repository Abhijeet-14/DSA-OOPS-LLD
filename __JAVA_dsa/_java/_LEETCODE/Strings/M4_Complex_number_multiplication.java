package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/complex-number-multiplication/
 * 
 * Response: Solved, needs optimization
 */

public class M4_Complex_number_multiplication {

	public static void main(String[] args) {
		String a = "7+-4i";
		String b = "-9+11i";
		
		String ans = myApproach(a, b);
		System.out.println("MyApproach: 81% \n" + ans);
	}
	
	public static String myApproach(String a, String b) {
        String arrA[] = a.split("\\+");
        String arrB[] = b.split("\\+");
        
        int variables[] = new int[4];
        
        for(int i=0; i<arrA.length; i++){
            int sign = 1;
            int end = arrA[i].length();
            if(i == 1)
                end = end -1;
            
            if(arrA[i].charAt(0) == '-'){
                sign = -1;
                variables[i] = sign*Integer.parseInt(arrA[i].substring(1, end));
            }
            else{
                variables[i] = sign*Integer.parseInt(arrA[i].substring(0, end));
            }
        }
            
        for(int i=0; i<arrB.length; i++){
            int sign = 1;
            int end = arrB[i].length();
            if(i == 1)
                end = end -1;
            
            if(arrB[i].charAt(0) == '-'){
                sign = -1;
                variables[i+2] = sign*Integer.parseInt(arrB[i].substring(1, end));
            }
            else{
                variables[i+2] = sign*Integer.parseInt(arrB[i].substring(0, end));
            }
        }

        // a1+a2*i b1+b2*i = a1b1 - a2b2 + a1b2*i + a2b1*i
        int ans1 = variables[0]*variables[2] - variables[1]*variables[3];
        int ans2 = variables[1]*variables[2] + variables[0]*variables[3];
      
        return String.valueOf(ans1) + "+" + String.valueOf(ans2) + "i";
    }

}

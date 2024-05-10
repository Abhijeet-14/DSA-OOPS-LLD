package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/goal-parser-interpretation
 * 
 * Response: SOLVED
 * 
 * */
public class E6_Goal_Parser {

	public static void main(String[] args) {
		String command = "G()(AL)";
		
		String ans = interpret_MyApproach(command);
		
		System.out.println(ans);
	}
	
	public static String interpret_MyApproach(String command) {
        String val = "";
        for(int i=0; i<command.length();){
            if(command.charAt(i) == 'G'){
                val+='G';
                i++;
            }
            else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                val +="o";
                i+=2;
            }
            else{
                val+="al";
                i+=4;
            }
        }
        
        return val;
        
    }

}

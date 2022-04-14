package _dsa._java._1Strings;

public class C1_Methods {
	public static void main(String[] args) {
		String str = "ABCDEFA";
		
		System.out.println(".length(str): " + str.length());
		System.out.println(".charAt(1): " + str.charAt(1));
		System.out.println(".substring(2): " + str.substring(2));
		System.out.println(".substring(2,5): " + str.substring(2,5));
		System.out.println(str+".contains(\"ABC\"): " + str.contains("ABC"));
		System.out.println(str+".contains(\"ABD\"): " + str.contains("ABD"));
		System.out.println(str+".equals(\"ABCDEF\"): " + str.equals("ABCDEF"));
		
		System.out.println();
		System.out.println(".compareTo... (-1 => s1>s2) (0 => s1=s2) (1 => s1<s2)");
		System.out.println(str+".compareTo(\"BCDEF\"): " + str.compareTo("BCDEF"));
		
		System.out.println();
		System.out.println(str+".indexOf(CD): " + str.indexOf("CD"));
		System.out.println(str+".indexOf(A), start from index 2: " + str.indexOf("A", 2));
	}
}

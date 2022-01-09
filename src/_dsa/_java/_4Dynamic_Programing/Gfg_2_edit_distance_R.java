package _dsa._java._4Dynamic_Programing;

public class Gfg_2_edit_distance_R {
	// A Naive recursive Java program to find minimum number 
	// operations to convert str1 to str2 
		static int min(int x, int y, int z) 
		{ 
			if (x <= y && x <= z) 
				return x; 
			if (y <= x && y <= z) 
				return y; 
			else
				return z; 
		} 
		
		static void initi(int t[][], int n, int m) {
			for(int i=0; i<n+1; i++) {
				for(int j=0; j<m+1; j++) {
					t[n][m] = -1;
					System.out.print(t[n][m]);
				}
				System.out.println();
			}
		}
		
		static int editDist(int t[][], String str1, String str2, int n, int m) 
		{ 

			// If first string is empty, the only option is to 
			// insert all characters of second string into first 
			
			if (m == 0) 
				return t[n][m] = n; 

			// If second string is empty, the only option is to 
			// remove all characters of first string 
			 if (n == 0) 
				return t[n][m] = m; 
			
			 if(t[n][m] != -1)
				return t[n][m];
			
			// If last characters of two strings are same, nothing 
			// much to do. Ignore last characters and get count for 
			// remaining strings. 
			else if (str1.charAt(n - 1) == str2.charAt(m - 1)) 
				return t[n][m] = editDist(t, str1, str2, n - 1, m - 1); 

			// If last characters are not same, consider all three 
			// operations on last character of first string, recursively 
			// compute minimum cost for all three operations and take 
			// minimum of three values. 
			else 
				return t[n][m] =1 + min(editDist(t, str1, str2, n, m - 1), // Insert 
										editDist(t, str1, str2, n - 1, m), // Remove 
										editDist(t, str1, str2, n - 1, m - 1) // Replace 
										);
		} 

		public static void main(String args[]) { 
			String str1 = "o"; 
			String str2 = "gh"; 

			int t[][] = new int[str1.length()+1][str2.length()+1];
			
			initi(t, str1.length(),	str2.length());
			
			System.out.println(editDist(t, str1, str2, str1.length(), str2.length()));
			
			for (int i = 0; i <= str1.length(); i++) { 
				for (int j = 0; j <= str2.length(); j++) {
					System.out.print(t[i][j]);
				}
				System.out.println();
			}
		} 
	} 


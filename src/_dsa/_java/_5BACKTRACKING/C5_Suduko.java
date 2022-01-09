package _dsa._java._5BACKTRACKING;

public class C5_Suduko {

	static int N;
	static int mat[][];
	public static void main(String[] args) {
		System.out.println("Naive: Time:\n\t  O(9^(n*n))");
		System.out.println("Backtracking:\n\t Time: O(9^(n*n)) .. it is the upper bound, but it takes time very less than naive \n\t "
				+ "Space: O(n*n)");

		mat = new int[9][9];
		
//		mat= new int[][] {
//            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
//            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
//            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
//            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
//            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
//            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
//            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
//            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
//            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
//        };
		
		
        
        N = mat.length;
        
		boolean isSolve = sudokoSol();

		System.out.println();
		if (isSolve == true) {
			printMatrix(mat);
			System.out.println("Yes, Possible!!");
		} else {
			printMatrix(mat);
			System.out.println("No, Not Possible!!");
		}

	}
	
	private static boolean isSafe(int i, int j, int n) {

		// Check row & column
		for (int k = 0; k < N; k++) {
			if (mat[k][j] == n || mat[i][k] == n)
				return false;
		}

		// check in SUB-grid
		// for i = 7, j=8 , in N=9
		int s = (int) Math.sqrt(N);
		
		// 7-(7%3) = 7-1 = 6
		int rowStart = i - (i % s);
		// 8-(8%3) = 8-2 = 6
		int colStart = j - (j % s);
		
		// so it will check in row 6-8 & column 6-8, 
		for (i = 0; i < s; i++) {
			for (j = 0; j < s; j++) {
				if (mat[i + rowStart][j + colStart] == n)
					return false;
			}
		}

		return true;
	}

	private static boolean sudokoSol() {
		int i=0;
		int j=0;
		boolean emptyCell = false;
		
		// Find 1st free cell
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				if (mat[i][j] == 0) {
					emptyCell = true;
					break;
				}
			}
			if(emptyCell)
				break;
		}

		// No Empty cell found after traveling each cell:
		if (i == N && j == N) {
			return true;
		}

		for (int n = 1; n <= N; n++) {
			if (isSafe(i, j, n) == true) {
				// if safe place the number
				mat[i][j] = n;
				
				// solve further
				if (sudokoSol() == true) {
					return true;
				}

				// last placement doesn't lead to solution, make this cell empty.
				mat[i][j] = 0;
			}
		}

		// Current parent placement is Wrong.
		return false;
	}

	

	private static void printMatrix(int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}

// 4
// {1, 0, 3, 0},
// {0, 0, 2, 1},
// {0, 1, 0, 2},
// {2, 4, 0, 0},
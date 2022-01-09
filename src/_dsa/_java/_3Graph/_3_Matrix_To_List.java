package _dsa._java._3Graph;

import java.util.ArrayList;
import java.util.List;

public class _3_Matrix_To_List {
    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0}};

        List<List<Integer>> res = convertList(matrix);
        System.out.println(res);

    }

    private static List<List<Integer>> convertList(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j] == 1)
                    res.get(i).add(j);
        }
        return res;
    }
}

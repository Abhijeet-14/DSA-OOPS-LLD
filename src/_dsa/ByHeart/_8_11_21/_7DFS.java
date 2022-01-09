package _dsa.ByHeart._8_11_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _7DFS {
    static List<List<Integer>> vertices = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];


        for(int i=0; i< n; i++)
            vertices.add(new ArrayList<>());

        for(int i=0; i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            vertices.get(x).add(y);
        }

        System.out.println("\nSingle Trip");
        dfs(0);

        for(int i=0; i<n;i++)
            if(!visited[i]) {
                System.out.println("\nTrip");
                dfs(i);
            }

        sc.close();

    }

    private static void dfs(int source) {
        visited[source] = true;

        List<Integer> parent = vertices.get(source);

        for(int child : parent){
            System.out.print("(" + source + " -> " + child + ")" + "->");
            if(!visited[child]){
                dfs(child);
            }
        }

    }
}

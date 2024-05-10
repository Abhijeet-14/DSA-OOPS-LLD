package _dsa._0__Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C9_No_of_connected_components {
    static int N;
    static int M;
    static List<List<Integer>> V = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        visited = new boolean[N];

        for(int i = 0; i < N; i++)
            V.add(new ArrayList<>());

        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            V.get(x).add(y);

            // Undirected Graph
            V.get(y).add(x);
        }


        int count = 0;

        for(int i = 0; i < N; i++) {
            System.out.println();
            if(visited[i] == false) {
                dfs(i);
                count++;
            }
        }

        System.out.println("\n" + count);
    }

    private static void dfs(int source) {
        List<Integer> curr = V.get(source);
        visited[source] = true;


        System.out.print("->" + source);
        for(int child : curr) {
            if(visited[child] == false) {
                dfs(child);
            }
        }
    }
}



package _dsa._0__Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class C6_Topological {
    static List<List<Integer>> V = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];

        for(int i = 0; i < n; i++)
            V.add(new ArrayList<>());

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            V.get(x).add(y);

            // undirected
//            V.get(y).add(x);
        }

        sc.close();

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < V.size(); i++)
            if(visited[i] == false)
                topo(i, s);


        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    private static void topo(int source, Stack<Integer> s) {

        List<Integer> curr = V.get(source);
        visited[source] = true;

        for(int child : curr) {
            if(visited[child] == false) {
                topo(child, s);
            }
        }

        s.push(source);
    }
}



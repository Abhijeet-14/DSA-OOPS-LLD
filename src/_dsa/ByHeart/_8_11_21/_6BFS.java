package _dsa.ByHeart._8_11_21;

import java.util.*;

public class _6BFS {
    static List<List<Integer>> vertices = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(n + " " + m);
        visited = new boolean[n];


        for(int i=0; i< n; i++)
            vertices.add(new ArrayList<>());

        for(int i=0; i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            vertices.get(x).add(y);
        }



        System.out.println("\nSingle Trip");
        bfs(0);

        for(int i=0; i<n;i++)
            if(!visited[i]) {
                System.out.println("\nTrip");
                bfs(i);
            }

        sc.close();
    }

    private static void bfs(int source) {
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int parent_value = q.poll();

            List<Integer> parent = vertices.get(parent_value);

            for(int i=0; i<parent.size(); i++) {
                int child = parent.get(i);
                if(!visited[child]){
                    q.add(child);
                    visited[child] = true;
                }
                System.out.print("(" + parent_value + " -> " + child + ")" + "->");

            }

        }

    }
}

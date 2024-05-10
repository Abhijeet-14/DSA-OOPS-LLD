package _dsa._java._3Graph;

// Questions: https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/

//import java.io.*;
import java.util.*;

public class P2_Mother_Vertex {
    static int count = 0;
	public static void main (String[] args) {
	    int edges[][] = {{0,3},{3,4},{2,1},{1,0},{0,2}};
//	    int edges[][] = {{0,1}, {1,3}, {4,1}, {0,2}, {5, 2},{5,6},{6,0},{6,4}};
	    
        List<List<Integer>> adj = new ArrayList<>();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int v = 5;
//        int v = 7;
        
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        boolean visited[] = new boolean[v];
        
        for(int i=0; i<v; i++){
            
            if(!visited[i]){
                dfs(adj, visited, i);
            }
            
//            System.out.println(count);
            if(count == v){
                res.add(i); 
            }
            
            Arrays.fill(visited, false);
            count = 0;
        }
        
        
        // List to Array
        int[] arr = res.stream().mapToInt(i -> i).toArray();
        
        System.out.println("arr: " + arr);
        System.out.println("res: " + res);
    }
    
    public static void dfs(List<List<Integer>> adj, boolean visited[], int source){
        List<Integer> curr = adj.get(source);
        visited[source] = true;
        count++;
        
        for(int i=0; i<curr.size(); i++){
            int child = curr.get(i);
            if(!visited[child])
                dfs(adj, visited, child);
        }
        
    }
}
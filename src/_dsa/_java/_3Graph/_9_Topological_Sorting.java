package _dsa._java._3Graph;

import java.util.*;

// DFS METHOD
public class _9_Topological_Sorting {

	public static void main(String[] args) {
//		int edges[][] = {{0,1},{3,4},{1, 3},{2,3},{2,4}};
		int edges[][] = {{1,0},{2,0},{3,1},{3,2}};
		int v = 4;
		    
	    List<List<Integer>> adj = new ArrayList<>();
	        
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        boolean visited[] = new boolean[v];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<v; i++){
            
            if(!visited[i]){
                dfs(adj, i, st, visited);
            }
        }
        
        System.out.println("Topological Sort");
        Collections.reverse(st);
        while(!st.isEmpty()) {
        	System.out.print(st.pop() + " ");
        }
	}
	
	public static void dfs(List<List<Integer>> adj, int source, Stack<Integer> st, boolean visited[]) {
		List<Integer> curr = adj.get(source);
		visited[source] = true;
		
		for(int i=0; i<curr.size(); i++) {
			int child = curr.get(i);
			if(!visited[child])
				dfs(adj, child, st, visited);
		}
		st.push(source);
		
	}

}

/*
Time Complexity:
10 - n!, 2n
18 - 2n.n2
22 - 2n.n
100 - n4
400 - n3
2000 - n2.lgn
10k - n2
10^5-6 - n.lgn, n
10^8 - n, lgn, 1
10^18 - lgn, 1
*/
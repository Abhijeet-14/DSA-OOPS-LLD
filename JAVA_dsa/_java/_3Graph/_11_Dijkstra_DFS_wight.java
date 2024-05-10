package _dsa._java._3Graph;

import java.util.*;

public class _11_Dijkstra_DFS_wight {
	
	static int count = 0;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("vertex");
		int vertices = sc.nextInt();
		
		System.out.println("edges");
		int edges = sc.nextInt();
		
		
		List<List<Pair>> adj = new ArrayList<>();
		
		for(int i=0; i<vertices; i++) {
			adj.add(new ArrayList<>());
		}
		
		
		System.out.println("Graph: ");
		for(int i=0; i<edges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			adj.get(u).add(new Pair(v, w));
			
			// Undirected
			adj.get(v).add(new Pair(u, w));
		}

		System.out.println("SOURCE: ");
		int source = sc.nextInt();
		
//		System.out.println("DESTINATION: ");
//		int destination = sc.nextInt();
		
		
		int weights[] = new int[vertices];
		
		Arrays.fill(weights, Integer.MAX_VALUE);

		weights[source] = 0;
		
//		dfs(adj, weights, source);	
		
		
		dijkstra(adj, weights, source, vertices);	
		
		System.out.println("\nOutput: ");
		for(int i=0; i<vertices;i++) {
			System.out.println(i + ": " + weights[i]);
		}
		
//		System.out.println("Shortest Path: " + weights[]);
	}
	
	
	public static void dfs(List<List<Pair>> adj, int weights[], int source) {
		
		List<Pair> curr = adj.get(source);	
		
		for(int i=0; i<curr.size(); i++) {
			Pair child = curr.get(i);	
			
			if(weights[child.to] > weights[source] + child.w) { 
				weights[child.to] = weights[source] + child.w;	
				dfs(adj, weights, child.to);
			}
			
		}
	}
	
	public static void dijkstra(List<List<Pair>> adj, int weights[], int source, int V ) {
	
		// min-value
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(V, new Pair());
		
		pq.add(new Pair(source, 0));
		
		while(!pq.isEmpty()) {
			int val = pq.peek().to;
			List<Pair> curr = adj.get(val);
			
			pq.poll();
			
			for(int i=0; i<curr.size(); i++) {
				Pair child = curr.get(i);
				
				if(weights[child.to] > weights[val] + child.w) {
					pq.remove(new Pair(child.to, weights[child.to]));
					
					weights[child.to] = weights[val] + child.w;
					
					pq.add(new Pair(child.to, weights[child.to]));
				}
				
			}
		}
	}
	
	static class Pair implements Comparator<Pair>{
		int to;
		int w;
		
		public Pair(){}
		
		public Pair(int to, int w){
			this.to = to;
			this.w = w;
		}
		
		public int compare(Pair a, Pair b){
			return a.w - b.w;
		}
	}
}


//Vertices:
//9

//Edges
//14

// Graph:
//0 1 4
//0 7 8
//1 7 11
//1 2 8
//7 8 7
//7 6 1
//2 8 2
//2 3 7
//2 5 4
//8 6 6
//6 5 2
//3 5 14
//3 4 9
//5 4 10

//Source
//0

//Destination
//4

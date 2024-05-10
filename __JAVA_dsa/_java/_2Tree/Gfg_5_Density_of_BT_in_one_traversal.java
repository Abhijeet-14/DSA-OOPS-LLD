package _dsa._java._2Tree;

import java.util.LinkedList;
import java.util.Queue;

// Density = size/height

public class Gfg_5_Density_of_BT_in_one_traversal {
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	static void densityBT(Node node) {
		if(node == null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(node);
		q.add(null);
		
		float size = 1;
		float height = 0;
		
		Node temp =  null;
	
//		System.out.println(node.data + " ");
		
		while(!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			
			if(temp == null) {
				if(!q.isEmpty()) {
					height += 1;
					q.add(null);
					System.out.println();
				}
			}
			else {
				if(temp.left!=null) {
					size += 1;
					q.add(temp.left);
				}
				if(temp.right!=null) {
					size += 1;
					q.add(temp.right);
				}
				System.out.print(temp.data + " ");
			}
		
		}
		
		System.out.println();
		if(height>0) {			
			System.out.println("size: " + size);
			System.out.println("height: " + height);
			System.out.println("Density: " + size/height);
		}else
			System.out.println("Height is 0");
	}
	
    public static void main(String[] args)  
    { 
         
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
//        root.right.right = new Node(6); 
      
  
        densityBT(root); 
    } 

}

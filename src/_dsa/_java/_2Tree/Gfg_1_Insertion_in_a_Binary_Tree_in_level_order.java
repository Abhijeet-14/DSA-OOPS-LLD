package _dsa._java._2Tree;

//import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// Insertion in a Binary Tree in level order
// Level order traversal : BFS 


public class Gfg_1_Insertion_in_a_Binary_Tree_in_level_order {
    
    static class Node{
        int data;
        Node left, right;
        
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    
    static Node root;
    static Node temp = root;
    
    static void insertI(Node temp, int data){
        
		Queue<Node> q = new LinkedList<>();
		q.add(temp);
		
		while(!q.isEmpty()){
		    temp = q.peek();
	        System.out.print(q.peek().data + " ");
		    q.remove();
  
		    if (temp.left == null){
		        temp.left = new Node(data);
		        break;
		    }
		    else {
		        q.add(temp.left);
		    }
 
		    if(temp.right == null){
		        temp.right = new Node(data);
		        break;
		    }
		    else{
		        q.add(temp.right);
		    }
		}
    }
    
    static void inOrder(Node node){
        if(node == null){
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    static void preOrder(Node node){
        if(node == null){
            return;
        }
        
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
	public static void main (String[] args) {
		
        root = new Node(10);
        
        root.left = new Node(11);
        root.right = new Node(9);
        
        root.left.left = new Node(7);
        
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        
        System.out.println("InOrder traversal before Insertion!");
        
        inOrder(root);
        System.out.println();
        
        preOrder(root);
        System.out.println();
        
        insertI(root, 12);
        
        System.out.println();
        insertI(root, 25);
        
        System.out.println();
        insertI(root, 55);
        
        System.out.println();
        insertI(root, 45);
        
        System.out.println();
        insertI(root, 35);
        
        System.out.println();
        insertI(root, 67);
        
        
        System.out.println();
        System.out.println("InOrder traversal after Insertion!");
        
        inOrder(root);
        System.out.println();
        preOrder(root);
	}
}

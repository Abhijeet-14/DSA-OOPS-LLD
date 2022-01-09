package _dsa._java._2Tree;


// Question: Deletion in a Binary Tree

// 		Given a binary tree, delete a node from it by making sure that tree shrinks from 
// 		the bottom (i.e. the deleted node is replaced by bottom most and rightmost node). 
// 		This different from BST deletion. Here we do not have any order among elements, 
// 		so we replace with last element.

// Problem Explanation:
// 		Given a Binary Tree of size N, your task is to complete the function deletionBT(), 
// 		that should delete a given node from the tree by making sure that tree shrinks 
// 		from the bottom (the deleted node is replaced by bottom-most and rightmost node).

//Constraints:
//	1<=T<=30
//	1<=N<=104
//Example:
//	Input:
//		2
//		1
//		1 4 7 5 6 
//		5
//		7 10 4 11 2 5 9 
//	Output:
//		5 4 6 7 
//		11 10 2 7 9 4 

/*

public class Solution {
    
    public void deleteDeepest(Node root, Node deepNode){
        
        Node temp = root;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(temp);
        
        while(!q.isEmpty()){
            temp = q.peek();
            q.poll();
            
            if(temp == deepNode){
                temp = null;
                return;
            }
            
            if(temp.right != null){
                if(temp.right == deepNode){
                    temp.right = null;
                    return;
                }
                else{
                    q.add(temp.right);
                }
            }
            
            if(temp.left != null){
                if(temp.left == deepNode){
                    temp.left = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
            
    }
    
    }
    public Node deletionBT(Node root, int key){
        if(root == null){
            return null;
        }
        
        if(root.left == null && root.right == null){
            if((root.data) == key)
                return root;
            else 
                return null;
        }
        
        Queue<Node> q1 = new LinkedList<>();
        
        q1.add(root);
        
        Node tempo = null;
        Node toReplace = null;
        
        while(!q1.isEmpty()){
            tempo = q1.peek();
            q1.remove();
            
            if(tempo.data == key)
                toReplace = tempo;
                
            if(tempo.left != null)
                q1.add(tempo.left);
            
            if(tempo.right != null)
                q1.add(tempo.right);
        }
        
        if(toReplace != null){
            int reData = tempo.data;
            
            deleteDeepest(root, tempo);  // temp: is the DEEPEST Node.
            toReplace.data = reData;
        }
        
        return root;
    }
}

*/
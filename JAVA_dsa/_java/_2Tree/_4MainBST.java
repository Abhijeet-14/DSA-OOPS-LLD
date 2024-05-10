package _dsa._java._2Tree;

//import _java.__Collection_FramWork._5Tree._3BinarySearchTree.Node;

public class _4MainBST {

	public static void main(String[] args) {

		_3BinarySearchTree bst = new _3BinarySearchTree();
		
		System.out.println("Maximum " + bst.treeMaximum(bst.toRoot()));
		
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(45);
		bst.insert(37);
		bst.insert(33);
		bst.insert(25);
		bst.insert(5);
		
		
		bst.inOrder();
		System.out.println();
		
		bst.preOrder();
		System.out.println();

		bst.postOrder();
		System.out.println();		


		System.out.println("Maximum " + bst.treeMaximum(bst.toRoot()).data );
		System.out.println("Minimum " + bst.treeMinimum(bst.toRoot()).data );
		
		System.out.println("Search R: " + bst.treeSearchR(bst.toRoot(), 25));
		
		System.out.println("Search I: "+ bst.treeSearchI(40));

		
		System.out.println("Successor: " + bst.treeSuccessor(bst.treeSearchI(20)) );
		System.out.println("Predecessor: " + bst.treePredecessor(bst.treeSearchI(33)) );
		

		bst.nodeDelete(0);
		bst.nodeDelete(45);
		bst.nodeDelete(30);
		
		
		bst.inOrder();
		System.out.println();
		
		bst.preOrder();
		System.out.println();
	}

}

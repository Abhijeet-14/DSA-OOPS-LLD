package _dsa._java._2Tree;


public class _2MainBT {

	public static void main(String[] args) {
		
		_1BinaryTree bt = new _1BinaryTree();
		
		_1BinaryTree.Node rootAdd = bt.create();
		
//		System.out.println(rootAdd);
//		System.out.println(rootAdd.data);
//		System.out.println(rootAdd.left.data);
//		System.out.println(rootAdd.right.data);
		
		// InOrder
		bt.InOrder(rootAdd);
		System.out.println();
		
		// PreOrder
		bt.PreOrder(rootAdd);
		System.out.println();
		
		// PostOrder
		bt.PostOrder(rootAdd);
		
		System.out.println("\n\nThanks for the Use!");
		
	}
}

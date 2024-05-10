package _dsa._15_12_21_practice.Tree_DP;

public class C4_Max_Path_Sum_Leaf_2_leaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(-4);
        root.left.left = new Node(-5);
        root.right = new Node(-3);

        int rec = solve_rec(root);
        System.out.println(rec);
        System.out.println("Ans (3 case): " + res);
    }

    static int res = Integer.MIN_VALUE;

    private static int solve_rec(Node root) {
        // Base Condition
        if(root == null)
            return 0;

        // leaf node
        if(root.left == null && root.right == null)
            return root.data;

        int left_ST_S = solve_rec(root.left);
        int right_ST_S = solve_rec(root.right);

        //Case1: root + left + right
        int NLR = left_ST_S + right_ST_S + root.data;
        // Case 2: left + root
        int NL = left_ST_S + root.data;
        // Case 3: right + root
        int NR = right_ST_S + root.data;

        if(root.left == null) {
            return NR;
        } else if(root.right == null) {
            return NL;
        } else {

            int mx_1 = Math.max(NL, NR);

            int mx_at_node = mx_1;

            res = Math.max(res, NLR);

            return mx_at_node;
        }


        // returning the max at that Node
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}

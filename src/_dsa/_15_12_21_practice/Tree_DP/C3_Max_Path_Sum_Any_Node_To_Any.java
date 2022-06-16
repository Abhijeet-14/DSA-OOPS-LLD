package _dsa._15_12_21_practice.Tree_DP;

public class C3_Max_Path_Sum_Any_Node_To_Any {
    public static void main(String[] args) {
        // 4 case
        // root.data + left_subTree.sum + right_subTree.sum
        // left_subTree.sum + root
        // right_subTree.sum + root
        // root
        // we need find max in bw these 4 value.

        Node root = new Node(1);
        root.left = new Node(-2);
        root.left.right = new Node(4);
        root.left.left = new Node(5);
        root.right = new Node(3);

        int rec = solve_rec(root);
        System.out.println(rec + " :- 4 cases (NLR, NL, NR, R) - Any Node to Any Node");
        System.out.println(res);

    }

    static int res = 0;

    private static int solve_rec(Node root) {
        // Base Condition
        if(root == null)
            return 0;

        int left_ST_S = solve_rec(root.left);
        int right_ST_S = solve_rec(root.right);

        //Case1: root + left + right
        int NLR = left_ST_S + right_ST_S + root.data;
        // Case 2: left + root
        int NL = left_ST_S + root.data;
        // Case 3: right + root
        int NR = right_ST_S + root.data;
        // Case 4: root
        int N = root.data;

        int mx_L_R = Math.max(NL, NR);

        int mx_at_node = Math.max(mx_L_R, N);

        int mx_all = Math.max(NLR, mx_at_node);

        res = Math.max(mx_all, res);

        // returning the max at that Node
        return mx_at_node;
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}

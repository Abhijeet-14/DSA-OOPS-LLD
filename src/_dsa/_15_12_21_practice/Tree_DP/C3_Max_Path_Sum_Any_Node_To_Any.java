package _dsa._15_12_21_practice.Tree_DP;

public class C3_Max_Path_Sum_Any_Node_To_Any {
    public static void main(String[] args) {
        // 3 case
        // root.data + left_subTree.sum + right_subTree.sum
        // left_subTree.sum
        // right_subTree.sum

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(-4);
        root.left.left = new Node(-5);
        root.right = new Node(-3);

        int rec = solve_rec(root);
        System.out.println(rec + " O(N^2) - 1 & 2 node, both are not leaf Node");

        // here we store the height at each Node
//        System.out.println("O(N) - by storing height of each Node");
//        int memo = solve_memo(root);
//        System.out.println(res + " " + memo + " - didn't understand");

    }

    static int res = 0;

    private static int solve_memo(Node root) {
        if(root == null)
            return 0;

        return +1;

    }

    private static int solve_rec(Node root) {
        // Base Condition
        if(root == null)
            return 0;

        // root + left + right
        int left_Sum = subTree_sum(root.left);
        int right_Sum = subTree_sum(root.right);

        int new_Sum = root.data + left_Sum + right_Sum;

        int left_ST_S = solve_rec(root.left);
        int right_ST_S = solve_rec(root.right);

        int mx = Math.max(root.data, Math.max(left_ST_S, right_ST_S));
        return Math.max(new_Sum, Math.max(left_ST_S, right_ST_S));
//        return Math.max(new_Sum, mx);
    }

    private static int subTree_sum(Node root) {
        if(root == null || root.data < 0)
            return 0;

        return root.data + Math.max(subTree_sum(root.left), subTree_sum(root.right));
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}

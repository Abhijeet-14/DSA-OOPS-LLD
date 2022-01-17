package _dsa._15_12_21_practice.Tree_DP;

public class C4_Max_Path_Sum_Left_2_leaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(-4);
        root.left.left = new Node(-5);
        root.right = new Node(-3);

        int rec = solve_rec(root);
        System.out.println(rec + " O(N^2) - Didn't understand, Now even though leaf Node < 0, we have to include & try find max form them. ");
    }

    private static int solve_rec(Node root) {
        if(root == null)
            return 0;

//        if(root.left == null && root.right == null)
//            return root.data;

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
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
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

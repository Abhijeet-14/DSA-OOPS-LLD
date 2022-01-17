package _dsa._15_12_21_practice.Tree_DP;

public class C2_diameter_of_tree {
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(2);

        int rec = solve_rec(root);
        System.out.println(rec + " O(N^2) - got the solution");

        // here we store the height at each Node
        System.out.println("O(N) - by storing height of each Node");
        int memo = solve_memo(root);
        System.out.println(res + " " + memo + " - didn't understand");

    }

    static int res = 0;
    private static int solve_memo(Node root) {
        if(root == null)
            return 0;

        int left_H = solve_memo(root.left);
        int right_H = solve_memo(root.right);

        res = Math.max(res, left_H + right_H + 1);

        return Math.max(left_H, right_H) + 1;

    }

    private static int solve_rec(Node root) {
        // Base Condition
        if(root == null)
            return 0;

        // root + left + right
        int left_H = height(root.left);
        int right_H = height(root.right);
        int new_D = 1 + left_H + right_H;

        int left_D = solve_rec(root.left);
        int right_D = solve_rec(root.right);

        return Math.max(new_D, Math.max(left_D, right_D));
    }

    private static int height(Node root) {
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}

package _dsa._15_12_21_practice.Tree_DP;

public class C1_Intro {
    public static void main(String[] args) {
        // we need to find the longest Path in BT. (Diameter, max path sum)
        // 3 cases, from which we can get the longest path.
        // 1) include root + left + right
        // 2) right only
        // 3) left only
        //
        // Naive O(N^2) -> O(N)(height tree) * N(find height for each Node)


        // Syntax
        Node root = new Node(0);
        root.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(2);

        System.out.println("Naive O(N^2) -> O(N)(height tree) * N(find height for each Node)");
        int rec = solve(root);
        System.out.println(rec + " O(N^2) - got the solution");

    }

    private static int solve(Node root) {
        // Base Condition
        if(root == null)
            return 0;

        // root + left + right
        int left_H = height(root.left);
        int right_H = height(root.right);
        int new_D = 1 + left_H + right_H;

        int left_D = solve(root.left);
        int right_D = solve(root.right);

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

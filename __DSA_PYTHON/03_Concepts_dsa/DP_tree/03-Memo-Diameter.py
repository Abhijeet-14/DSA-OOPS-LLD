private static int solve_memo(Node root) {
        if(root == null)
            return 0;

        int left_H = solve_memo(root.left);
        int right_H = solve_memo(root.right);

        res = Math.max(res, left_H + right_H + 1);

        return Math.max(left_H, right_H) + 1;

    }
package _dsa._0_JOB_Change.T14_Binary_Tree;

import java.util.*;

public class C18_All_nodes_at_K_distance_from_target_node {
    // Question: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

    public static void main(String[] args) {
        TreeNode target = new TreeNode(5);
        int k = 2;

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        List<Integer> ans = distanceK(root, target, k);

        System.out.println();
        for(int val: ans)
            System.out.print(val + ", ");
    }

    static Set<Integer> ans;
    static Map<Integer, Pair> map;
    static Set<Integer> visited;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new HashSet<>();
        map = new HashMap<>();
        visited = new HashSet<>();

        add_all_node_with_parent(root, null);

        if(k==0)
            ans.add(target.val);

        else if(map.containsKey(target.val)) // find the target node
            solve_(map.get(target.val).node, k, target);

        return new ArrayList<>(ans);
    }

    public static void solve_(TreeNode root, int k, TreeNode target){
        if(root == null)
            return;

        if(visited.contains(root.val))
            return;

        TreeNode par = map.get(root.val).parent;

        if(k==0){
            if(root.val != target.val)
                ans.add(root.val);
            return;
        }

        k--;

        visited.add(root.val);

        solve_(root.left, k,target); // left direction
        solve_(root.right, k,target); // right direction
        solve_(par, k,target);  // parent direction
    }

    public static void add_all_node_with_parent(TreeNode root, TreeNode parent){
        if(root == null)
            return;

        map.put(root.val, new Pair(root, parent));

        add_all_node_with_parent(root.left, root);
        add_all_node_with_parent(root.right, root);
    }

    public static class Pair{
        TreeNode node, parent;

        public Pair(TreeNode node, TreeNode parent)
        {
            this.node = node;
            this.parent = parent;
        }

        public String toString(){
            if(this.node != null && this.parent != null)
                return "(" + this.node.val + " " + this.parent.val + ")";
            return "-" + this.node.val;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

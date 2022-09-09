package _dsa._0_JOB_Change.T14_Binary_Tree;

import java.util.*;

// Ques: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class C8_Vertical_Response_correct {
    // Logic:
    // we will consider 3 thing "level", "vertical_position", "value"
    // Take TreeMap(Bcoz it will give KeySet in sorted Order)
    // now put as vertical_position: Pair(value, level)

    // do inorder traversal - and add all node
    // we have custom sorting order for Pair

    //
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        root.right.right.left.right = new TreeNode(12);

        int position = 0;

        Map<Integer, List<Pair>> ans = new TreeMap<>();


        List<List<Integer>> result = verticalTraversal(root);

        System.out.println("\nVertical_View: ");
        for(List<Integer> val: result)
            System.out.print(val +", ");

//        System.out.println("\nVertical_View: ");
//        for(int i:ans.keySet())
//            System.out.print(ans.get(i).get(0).value + ", ");


    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<Pair>> map = new TreeMap<>(); // it will give keyset in sorted order

        vertical_traversal_tree_map(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i: map.keySet()){
            List<Pair> curr = map.get(i);
            Collections.sort(curr); // sort them as per level

            List<Integer> _ans = new ArrayList<>();
            for(Pair data: curr)
                _ans.add(data.value);

            ans.add(_ans);
        }

        return ans;
    }

    public static void vertical_traversal_tree_map(TreeNode root, int level, int position, Map<Integer, List<Pair>> map){
        if(root == null)
            return;

        List<Pair> curr = map.getOrDefault(position, new ArrayList<>());

        curr.add(new Pair(root.val, level));
//        Collections.sort(curr);

        map.put(position, curr);

        vertical_traversal_tree_map(root.left, level+1, position-1, map);
        vertical_traversal_tree_map(root.right, level+1, position+1, map);
    }

    static class Pair implements Comparable<Pair>{
        int value;
        int level;

        public Pair(int value, int level){
            this.value = value;
            this.level = level;
        }

        @Override
        public int compareTo(Pair p){
            if(this.level == p.level)
                return this.value-p.value; // take whose value is smaller
            return this.level - p.level;
        }

        @Override
        public String toString(){
            return "(" +value +", "+ level+"),";
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

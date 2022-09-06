package _dsa._0_JOB_Change.T14_Binary_Tree;

import java.util.*;

public class C8_Vertical_Traversal {
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

        int position =0;

        Map<Integer, List<Pair>> ans = new HashMap<>();


        vertical_traversal(root, 0, 0, ans);

        for(int i:ans.keySet()){
            System.out.println(i + ": " + ans.get(i));
        }

        System.out.println("\nTop_View: ");
        for(int i:ans.keySet())
            System.out.print(ans.get(i).get(0).value + ", ");

        System.out.println("\n\nBottom_View: ");
        for(int i:ans.keySet()) {
            int curr_size = ans.get(i).size();
            System.out.print(ans.get(i).get(curr_size-1).value + ", ");
        }

        System.out.println("\n\nLeft_View: ");
        for(int i:ans.keySet()) {
            if(i == 0)
                System.out.print(ans.get(i).get(0).value + ", ");
            else if(i<0) {
                int curr_size = ans.get(i).size();
                System.out.print(ans.get(i).get(curr_size - 1).value + ", ");
            }
        }

        System.out.println("\n\nRight_View: ");
        for(int i:ans.keySet()) {
            if(i == 0)
                System.out.print(ans.get(i).get(0).value + ", ");
            else if(i>0) {
                int curr_size = ans.get(i).size();
                System.out.print(ans.get(i).get(curr_size - 1).value + ", ");
            }
        }


    }
    public static void vertical_traversal(TreeNode root, int level, int position, Map<Integer, List<Pair>> ans){
        if(root == null)
            return;

        List<Pair> curr = ans.getOrDefault(position, new ArrayList<>());

        curr.add(new Pair(root.val, level));

        Collections.sort(curr);

        ans.put(position, curr);

        vertical_traversal(root.left, level+1, position-1, ans);
        vertical_traversal(root.right, level+1, position+1, ans);
    }


    static class Pair implements Comparable<Pair> {
        int value;
        int level;
        public Pair(int value, int level)
        {
            this.value = value;
            this.level = level;
        }

        @Override
        public String toString() {
            return "(" + value +", " + level + ")";
        }

        @Override
        public int compareTo(Pair o2) {
            return this.level -  o2.level;
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

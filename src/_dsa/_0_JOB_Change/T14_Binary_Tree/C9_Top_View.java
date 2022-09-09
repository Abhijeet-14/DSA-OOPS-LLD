package _dsa._0_JOB_Change.T14_Binary_Tree;
import java.util.*;

public class C9_Top_View {
    // Ques: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
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


        List<List<Integer>> result = topView(root);

        System.out.println("\nVertical_View: ");
        for(List<Integer> val: result)
            System.out.print(val +", ");

//        System.out.println("\nVertical_View: ");
//        for(int i:ans.keySet())
//            System.out.print(ans.get(i).get(0).value + ", ");


    }

    public static List<List<Integer>> topView(TreeNode root) {

        Map<Integer, Pair> map = new TreeMap<>(); // it will give keyset in sorted order

        top_view_tree_map(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i: map.keySet()){
            Pair curr = map.get(i);
            List<Integer> _ans = new ArrayList<>();

            _ans.add(curr.value);

            ans.add(_ans);
        }

        return ans;
    }

    public static void top_view_tree_map(TreeNode root, int level, int position, Map<Integer, Pair> map){
        if(root == null)
            return;

        Pair curr_pair = new Pair(root.val, level);

        if(!map.containsKey(position))
            map.put(position,curr_pair);
        else {
            if (map.get(position).compareTo(curr_pair) > 0 ) // top view - take this > curr_pair
                map.put(position, curr_pair);
        }

        top_view_tree_map(root.left, level+1, position-1, map);
        top_view_tree_map(root.right, level+1, position+1, map);
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

package _dsa._15_12_21_practice.Stack;

import java.util.*;

public class C2_Next_greater_Element_to_Left {
    public static void main(String[] args) {
//        int arr[] = {4, 5, 2, 25, 10};
        int arr[] = {1, 3, 2, 4};

        List<Integer> naive = naive(arr);
        System.out.println(naive + " O(N^2)");

        List<Integer> optimize = optimize(arr);
        System.out.println(optimize + " O(N)");
    }

    private static List<Integer> optimize(int[] arr) {
        int N = arr.length;

        Stack<Integer> s = new Stack<>();
        List<Integer> rs = new ArrayList<>();

        Collections.fill(rs, -1);

        for(int i = 0; i < N; i++) {
            int curr = arr[i];
            if(s.isEmpty()) {
                rs.add(-1);
                s.push(curr);
            } else if(curr < s.peek()) {
                rs.add(s.peek());
                s.push(curr);
            } else if(curr > s.peek()) {
                while(!s.isEmpty() && s.peek() <= curr) {
                    s.pop();
                }
                if(s.isEmpty())
                    rs.add(-1);
                else
                    rs.add(s.peek());
                s.push(curr);
            }
        }
        return rs;
    }

    private static List<Integer> naive(int[] arr) {
        int N = arr.length;
        List<Integer> res = new ArrayList<>();

        boolean flag = false;
        for(int i = 0; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    res.add(arr[j]);
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                res.add(-1);
            flag = false;
        }

        return res;
    }
}

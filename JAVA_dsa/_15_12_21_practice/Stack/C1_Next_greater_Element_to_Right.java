package _dsa._15_12_21_practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class C1_Next_greater_Element_to_Right {
    public static void main(String[] args) {
//        int arr[] = {4, 5, 2, 25, 10};
        int arr[] = {11, 13, 21, 2};

        List<Integer> naive = naive(arr);
        System.out.println(naive + " O(N^2)");

        int[] optimize = optimize(arr);
        for(int val : optimize)
            System.out.print(val + " -> ");
//        System.out.println(optimize + " O(N)");
    }

    private static int[] optimize(int[] arr) {
        int N = arr.length;
        int rs[] = new int[N];
        Arrays.fill(rs, -1);

        Stack<Integer> s = new Stack<>();
        s.add(arr[N - 1]);

        for(int i = N - 1; i >= 0; i--) {
            int curr = arr[i];
            if(s.isEmpty()) {
                rs[i] = -1;
            } else if(curr < s.peek()) {
                rs[i] = s.peek();
                s.push(curr);
            } else if(curr > s.peek()) {

                while(!s.isEmpty() && s.peek() <= curr) {
                    s.pop();
                }
                if(s.isEmpty())
                    rs[i] = -1;
                else
                    rs[i] = s.peek();

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
            for(int j = i + 1; j < N; j++) {
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

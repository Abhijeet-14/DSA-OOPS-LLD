package _dsa._0_restart.Stack_Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class C11_Max_In_All_Sub_Array_Of_K {
    public static void main(String[] args) {
        int k  =3;
        int arr[] = {1,6,2,5,3,4,1};

        // Logic:
        // use Deque,
        // while pushing if 'last element' < arr_curr & dq is not empty
        // then popLast
        // add element to dq.
        // if r-l+1 = k, then add 'firstElement' to resArr.
        // and if  'firstElement' == arr[l]
        // then 'popFirst'.
        // l++
        // and finally r++

        List<Integer> resArr = solve(arr, k);
        System.out.println("Result: " + resArr);

        // Time: O(N), AS: O(N)
    }

    private static List<Integer> solve(int arr[], int k){
        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0, n = arr.length;

        Deque<Integer> dq = new ArrayDeque<>();

        while(right<n){
            while(!dq.isEmpty() && dq.getLast()<arr[right])
                dq.pollLast();

            dq.addLast(arr[right]);

            if(right - left + 1 == k){
                res.add(dq.getFirst());
                if(arr[left] == dq.getFirst())
                    dq.pollFirst();

                left++;
            }

            right++;
        }

        return res;
    }
}

package __Interview_pocketFM.Round2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
given an array a and integer k
return all subsets
that multiply to form value k
k=24
a=[1,2,3,4,5,6,7,8,12]
subsets
2,3,4
6,4
8,3
12,2
1,2,12
1,3,8
1,4,6
1,2,3,4

 */
public class Q1 {
    public static void main(String[] args) {

    int arr[] = {1,2,3,4,5,6,7,8,12};
    int k = 24;

    solve_brute_force(arr, k);
//        solve(arr, k, index++, 0, new ArrayList<>());
        System.out.println(finalList);
    }

    private static void solve_brute_force(int[] arr, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        int tempAns = 1;
        List<Integer> currList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){

            currList = new ArrayList<>();

            tempAns = arr[i]; // 2
            currList.add(arr[i]);

            int count = 0;

            for(int j=i+1; j< arr.length; j++){
                count++;
                tempAns *= arr[j]; // 2*3*4 => 24
                // 4*5 ->x -> 4*5*6 ->  4*5*6worked -> 4 * 6 -> 120 > k -> 4*5 * 7
                if(tempAns > k || k%tempAns != 0){
                    tempAns = tempAns/arr[j];
//                    j = i + count;
//                    count = 0;
                }
                else if(tempAns == k){
                    currList.add(arr[j]);
                    ans.add(currList);
                    break;
                }
                else{
                    currList.add(arr[j]);
//                    j++;
                }
            }

        }

        System.out.println(ans);
    }

    static List<List<Integer>> finalList = new ArrayList<>();
    static int index = 0;
    static void solve(int arr[], int k, int idx, int ans, List<Integer> currList){
        if(idx >= arr.length)
            return;

        ans *= arr[idx];
        if(ans == k) {
            currList.add(arr[idx]);
            finalList.addAll(Collections.singleton(currList));
//            System.out.println(idx);
            solve(arr, k, index++, 1, new ArrayList<>());
        }

        if(ans < k && k%ans == 0 ) {
            solve(arr, k, idx + 1, ans, currList);
            currList.add(arr[idx]);
        }

        else {
            solve(arr, k, idx + 1, ans / arr[idx], currList);
        }
    }
}

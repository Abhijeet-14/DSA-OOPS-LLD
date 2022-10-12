package __Interview_pocketFM.Round1;

import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        int arr[] = {5,3,4,9,1,2,7};

        int ans[] = solve(arr);

        printArr(ans);
        // 7 - -1
        // 2 - 7
        // 1 - 2
        // 9 - -1
        // 4 - 9
        // 3 - 4
        // 5 - 9
        // Op: 9,4,9,-1,2,7,-1

        // Brute - Force - O(N^2)
        // arr[i] - 5
        // max = -1
        // i+1 -> n-1 : j
        // arr[j] > arr[i] => max = Math.max(arr[j], max)

        // Approach 2 -AS -O(N) - TC -
        // travel from right -> left
        // stack -
        // 7 -> st.isEmpty -> -1 => st.push(7)
        // 2 -> st.peek() > curr -> 7 => st.push(2)
        // 1 -> st.peek() > curr -> 2
        // 9 -> st.peek() > curr -> False -> st.pop() ->st.isEmpty() => -1
        // 9,1,2,3,4,5,6
    }

    public static int[] solve(int arr[]){
        int len = arr.length;
        int result[] = new int[len];

        Stack<Integer> st = new Stack<>();

        for(int i=len-1; i>=0; i--){
            int curr = arr[i];
            if(st.isEmpty()){
                result[i] = -1;
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && st.peek() < curr){
                    st.pop();
                }
                if(st.isEmpty())
                    result[i] = -1;
                else{
                    result[i] = st.peek();
                }
                st.push(curr);
            }
        }

        return  result;
    }

    static void printArr(int arr[]){
        for(int val: arr){
            System.out.print(val + ", ");
        }
    }

}

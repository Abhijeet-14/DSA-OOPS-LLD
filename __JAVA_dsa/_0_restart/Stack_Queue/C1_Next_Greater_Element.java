package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class C1_Next_Greater_Element {
    public static void main(String[] args) {
        int arr[] = {13, 7, 6, 12, 10};
        // ans = [-1, 12, 12, -1, -1]

        int len = arr.length;
        int nGec[] = new int[len];

        // Naive Approach: O(N^2)
        // iterate over each element from i+1 -> n -> if found arr[i]<arr[j] => then put that for i value

        // Optimize App: O(N)
        // travel the arr 1 time.
        // and put element index to STACK - if peek > current
        // else pop peek -> and put current value to peek value index.
//        optimize(arr, nGec, len);

        optimize_reverse_loop(arr, nGec, len);
    }

    private static void optimize_reverse_loop(int[] arr, int[] nGec, int len) {
        Stack<Integer> s = new Stack<>();

        for(int i = len-1; i>=0;i--){
            int curr = arr[i];

            if(s.isEmpty()){
                nGec[i] = -1;
                s.add(curr);
            }
            else {
                if(curr <= s.peek()){
                    nGec[i] = s.peek();
                    s.add(curr);
                }
                else {
                    while(!s.isEmpty() && curr > s.peek())
                        s.pop();
                    if(s.isEmpty())
                        nGec[i] = -1;
                    else
                        nGec[i] = s.peek();

                    s.add(curr);
                }
            }
        }

        printArr(nGec);
    }

    private static void optimize(int arr[], int nGec[], int len){
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<len; i++){
            int current = arr[i];
            if(s.isEmpty())
                s.add(i);
            else if(arr[s.peek()] > current)
                s.add(i);
            else{
                while(!s.isEmpty() && arr[s.peek()] < current) {
                    int idx = s.pop();
                    nGec[idx] = current;
                }
                s.add(i);
            }
        }

        while(!s.isEmpty())
            nGec[s.pop()] = -1;

        printArr(nGec);
    }

    public static void printArr(int nGec[]){
        System.out.print("[ ");
        for(int val: nGec)
            System.out.print(val + ", ");
        System.out.print("]");
    }

}

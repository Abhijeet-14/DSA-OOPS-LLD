package ___KT_C3;

import java.util.Stack;

public class stock {
    public static void main(String[] args) {

        int arr[]= {7,1,5,3,6,4};
        int ans = maxProfit(arr);
        System.out.println(ans);

    }

    public static int maxProfit(int[] arr){
        Stack<Integer> st = new Stack<>();

        for(int val: arr){
            if(!st.isEmpty()) {
                int _top = st.peek();
                if (_top > val){
                    while (!st.isEmpty() && _top > val) {
                        st.pop();
                        if (!st.isEmpty())
                            _top = st.peek();
                    }
                    st.push(val);

                }
                else{
                    st.push(val);
                }
            }
            else{
                st.push(val);
            }
        }

        if (st.size() <=1)
            return 0;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        while(!st.isEmpty()){
            int current= st.pop();
            maxVal = Math.max(current, maxVal);
            minVal = Math.min(current, minVal);
        }
        System.out.println(minVal);
        System.out.println(maxVal);
        int maxProfit = maxVal - minVal;
        return maxProfit;
    }

}

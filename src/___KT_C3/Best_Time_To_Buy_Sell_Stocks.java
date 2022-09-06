package ___KT_C3;

import java.util.Stack;

public class Best_Time_To_Buy_Sell_Stocks {
    public static void main(String[] args) {

        int price[]= {7,1,5,3,6,4};


        // 1. Find Next Max Element to the right
        // 2. Find max difference at each price index
        int ans_best_time = bestTime(price);
        System.out.println(ans_best_time);

    }

        public static int bestTime(int[] prices) {
            Stack<Integer> s = new Stack<>();
            int len = prices.length;

            int nGec[] = new int[len];

            for(int i=len-1;i>=0; i--){
                int curr = prices[i];

                if(s.isEmpty()){
                    nGec[i] = -1;
                    s.add(curr);
                }
                else{
                    if(curr<=s.peek()){
                        nGec[i] = s.peek();
//                        s.add(curr);
                    }
                    else {
                        while (!s.isEmpty() && curr > s.peek()) {
                            s.pop();
                        }
                        if (s.isEmpty())
                            nGec[i] = -1;
                        else {
                            nGec[i] = s.peek();
                        }
                        s.add(curr);
                    }
                }
            }




            int max = 0;
            for(int i=0; i<len; i++){
                System.out.print(nGec[i] + " , ");
                int curr_prof = nGec[i] - prices[i];
                if(max<= curr_prof)
                    max =curr_prof;
            }

            System.out.println();
            return max;
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

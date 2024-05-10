package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

import java.util.Stack;

public class C4_Best_Time_To_Buy_Sell_Stocks {
    public static void main(String[] args) {

        int price[]= {7,1,5,3,6,4};


        int ans_best_time_brute_force = bestTime_brute_force(price); // TC O(N), AS O(N)
        System.out.println("TC-O(N^2), AS-O(1): " + ans_best_time_brute_force);

        // 1. Find Next Max Element to the right
        // 2. Find max difference at each price index
        int ans_best_time = bestTime(price); // TC O(N), AS O(N)
        System.out.println("TC-O(N), AS-O(N): " + ans_best_time);


        int ans_best_time_O1_Space = bestTime_O1_Space(price); // TC O(N), AS O(N)
        System.out.println("TC-O(N), AS-O(1): " + ans_best_time_O1_Space);
    }

    private static int bestTime_brute_force(int[] price) {
        int ans = 0;
        int len = price.length;
        for(int i=0; i<len; i++){
            int buy = price[i];
            for(int j=i+1; j<len;j++){
                int sell = price[j];
                if(sell>=buy)
                    ans = Math.max(ans, sell-buy);
            }
        }
        return ans;
    }

    private static int bestTime_O1_Space(int[] price) {
        // logic is to: find the minimum buying value at any index;
        int min_so_far = price[0];
        int max_ans = 0;
        for(int i=1; i<price.length; i++){
            if(price[i]-min_so_far >= 0)
                max_ans = Math.max(max_ans, price[i]-min_so_far);
            min_so_far = Math.min(price[i], min_so_far);
        }

        return max_ans;
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

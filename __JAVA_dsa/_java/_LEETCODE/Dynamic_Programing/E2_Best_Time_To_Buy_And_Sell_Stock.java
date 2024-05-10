package _dsa._java._LEETCODE.Dynamic_Programing;

/*
 * Question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Response: SOLVED: O(N), 98%.
 * 
 * NOTE: Recursion won't work here!
 */
public class E2_Best_Time_To_Buy_And_Sell_Stock {

	public static void main(String[] args) {
		int prices[] = {7,1,5,3,6,4};
		
		int ans = myApproach(prices);
		
		System.out.println("MyApproach 98% O(n), \n" + ans);
	}
	
	public static int myApproach(int[] prices) {
        int buy = prices[0];
        
        int mx = 0;
        for(int i=1; i<prices.length; i++){
            if(buy>prices[i])
                buy = prices[i];
            else{
                int pro = prices[i] - buy;
                if(pro>mx)
                    mx=pro;
            }
        }
        return mx;
    }
}

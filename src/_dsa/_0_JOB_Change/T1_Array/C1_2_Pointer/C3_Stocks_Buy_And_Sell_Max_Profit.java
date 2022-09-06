package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C3_Stocks_Buy_And_Sell_Max_Profit {
    public static int maxProfit(int prices[], int size)
    {

        // maxProfit adds up the difference between
        // adjacent elements if they are in increasing order
        int maxProfit = 0;

        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++) {
            int curr_price = prices[i];
            int prev_price = prices[i - 1];

            if (curr_price > prev_price)
                maxProfit += curr_price - prev_price;
        }
        return maxProfit;
    }

    // Driver code
    public static void main(String[] args)
    {

        // stock prices on consecutive days
        int price[] = {7,1,5,3,6,4};
//        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        // function call
        System.out.println(maxProfit(price, n));
    }
}

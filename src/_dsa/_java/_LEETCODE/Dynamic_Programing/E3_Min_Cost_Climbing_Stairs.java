package _dsa._java._LEETCODE.Dynamic_Programing;

import java.util.*;

/*
 * Question: https://leetcode.com/problems/min-cost-climbing-stairs/
 * 
 * RESPONSE: SOLVED.  Needs optimization,
 */

public class E3_Min_Cost_Climbing_Stairs {

	static int t[];
	
	public static void main(String[] args) {
		int cost[] = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int costs = myApproach(cost);
		
		System.out.println("MyApproach 77%: \n" + costs);
		
	}
	
    public static int myApproach(int[] cost) {
        t = new int[cost.length+1];
        
        Arrays.fill(t, -1);
        
        return Math.min(solve(cost, 0, 0), solve(cost, 1, 0));
    }
    
    public static int solve(int cost[], int i, int ans){
        if(i >= cost.length)
            return ans;
        
        if(t[i] != -1)
            return t[i];
        
        return t[i] = cost[i] + Math.min(solve(cost, i+1, ans), solve(cost, i+2, ans));
    }

}

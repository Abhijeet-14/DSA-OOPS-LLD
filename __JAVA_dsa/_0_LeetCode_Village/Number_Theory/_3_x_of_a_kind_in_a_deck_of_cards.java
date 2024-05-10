package _dsa._0_LeetCode_Village.Number_Theory;


import java.util.HashMap;
import java.util.Map;

public class _3_x_of_a_kind_in_a_deck_of_cards {
    /* Problem Statement: 
    * In a deck of cards, each card has an integer written on it.
    * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

    * Each group has exactly X cards.
    * All the cards in each group have the same integer.
    */
    public static void main(String[] args) {

    }

    private static boolean hasGroupsSizeX(int[] deck) {
        /* Logic:
        * say, { 2-4, 3-6, 4-8}
        * if we find minimum number divisible by all [4,6,8] -> 2
        * so need to make group of 2. |22|22|33|33|33|44|44|44|44| - all groups of same SIZE.
        * but {2-3, 3-2, 4-2} 
        * so, min is 2 -> |22|2|33|44| -> so all groups are not of same SIZE.
        * so, we need to use GCD for min-number-divisible by all numbers.

        * Time Complexity O(N * logN).
        */
        Map<Integer, Integer> count  = new HashMap<>();
        
        for(int i: deck){
            count.put(i, count.getOrDefault(i,0)+1);
        }
        
        int res = 0;
        for(int i: count.values()){ // O(N)
           res =  gcd(i, res); // O(log(N))
        }
        // Therefore, O(N * logN)
        return res>1;
    }

    private static int gcd(int a, int b){ // O(log(min(a, b))
        if(b == 0)
            return a;

        return gcd(b, a%b);
    }
}

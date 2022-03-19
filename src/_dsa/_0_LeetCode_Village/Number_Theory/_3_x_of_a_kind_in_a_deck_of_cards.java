package _dsa._0_LeetCode_Village.Number_Theory;


public class _3_x_of_a_kind_in_a_deck_of_cards {
    // PS: Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

    public static void main(String[] args) {

    }

    private static boolean hasGroupsSizeX(int[] deck) {
        /* Logic:
        * Counts all occurrence of all numbers.
        * Return if the greatest common divisor of counts > 1.
        *
        * Time Complexity O(N).
        */
        Map<Integer, Integer> count  = new HashMap<>();
        
        for(int i: deck){
            count.put(i, count.getOrDefault(i,0)+1);
        }
        
        int res = 0;
        for(int i: count.values()){
           res =  gcd(i, res);
        }
        
        return res>1;
    }

    private static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a%b);
    }
}

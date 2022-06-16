package _dsa._0_restart.Stack_Queue;

import java.util.Arrays;

public class C10_Non_Repeating_Char_In_Stream_String {
    public static void main(String[] args) {
        String inputArr = "abcabbdc";

        Pair[] arr = new Pair[26];
        Arrays.fill(arr, new Pair(0,-1));

        for(int i=0; i<inputArr.length(); i++){
            char val = inputArr.charAt(i);
            int idx = val - 'a';

            if(arr[idx].y == -1)
                arr[idx] = new Pair(arr[idx].x,i);
            if(arr[idx].x != 2)
                arr[idx] = new Pair(arr[idx].x+1, arr[idx].y);
            int ans = checkNonRepeating(arr);
            System.out.println("Ans " + val + ": " + (ans == Integer.MAX_VALUE ? -1 : ans));
        }
    }

    private static int checkNonRepeating(Pair arr[]){
        int _min = Integer.MAX_VALUE;
        for(Pair curr: arr){
            if(curr.y != -1 && curr.x == 1)
                _min = Math.min(_min, curr.y);
        }
        return  _min;
    }


    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

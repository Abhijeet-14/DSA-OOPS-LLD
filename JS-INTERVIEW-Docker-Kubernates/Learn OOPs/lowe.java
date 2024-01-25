package oops;

import java.util.HashMap;

public class lowe {
    public static void main(String[] args) {
        String input = "MCMIV" ;
        int len = input.length();
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('X', 10);
        map.put('I', 1);
        map.put('V', 5);
        map.put('M', 1000);
        map.put('C', 100);
        map.put('L', 50);
        map.put('D', 500);

        int result = 0;

        int greatest_number = Integer.MIN_VALUE;                                                

        for(int i = 0; i< input.length()-1; i++){
            char value = input.charAt(i);

            if(map.containsKey(value)) {
                int current_value = map.get(value);
                int forward_value = map.get(input.charAt(i+1));

                if(current_value > forward_value)
                    result += current_value;
                else
                    result -= current_value;
            }
        }
        result += map.get(input.charAt(len-1));

        System.out.println("Result: " +  result);
    }
}

//
//fun1(inpu1){
//    var a =10;
//    return fun2(a);
//}
//
//fun2(input2){
//
//}
//
//for(...6)
//        {
//            // i =1
//            setTimeout(i);
//        }
//let a =1
//var c= setTimeout(.., 10000);
//    let b =10
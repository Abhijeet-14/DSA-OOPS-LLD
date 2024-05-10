package _dsa._0_LeetCode_Village.Math;

public class _2_Reverse_Integer {
//    Given a signed 32-bit integer x, return x with its digits reversed.
//    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//    Example: X = 132   => result = 321
//    x = -231 => result =-132

    public static void main(String[] args) {
        System.out.println(reverse(321));
        System.out.println(reverse(-321));
        System.out.println(reverse(1534236469 ));
        System.out.println(reverse(-1534236469 ));
    }

    public static int reverse(int x) {
        // x - 132 => 231

        // rem  div     Formula (t=0)
        // 2    13      t=t*10 + r = 0 + 2
        // 3    1       t=2*10+3 =23
        // 1    0       t=23*10 + 1 = 231

        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            System.out.println("Max or Min Hit");
            return 0;
        }

        // Sign Management
        int sign = 1;
        if(x<0){
            sign = -1;
        }
        x = sign*x;


        int div = 0, rem=0, newX = 0;

        // Formula - newX = newX*10 + rem;
        while(x>0){
            rem = x%10;

            // Say IntMax = 20 & IntMin = -20
            // 19*10>20 -> so it will converted to a number, say 13.
            // in order to check
            // num > IntMax/10 -> mun*10 > IntMax/10*10
            // therefore we're using
            // num > IntMax/10 -> Crossed 32bits .. so return 0;
            // num < IntMin/10 -> crossed -2^31

            if(newX > Integer.MAX_VALUE/10 || newX < Integer.MIN_VALUE/10){
                System.out.println("Max or Min Hit");
                return 0;
             }

            newX = newX*10 + rem;

            x = x/10;
        }

        return sign*newX;
    }

}

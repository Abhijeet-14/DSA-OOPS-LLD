package _dsa.Flipkart;

public class Q4_1st_Non_repeating_Char {
    public static void main(String[] args) {
        String a = "abadbc";
        String b = "abcabc";

        System.out.println(solve(a));
        System.out.println(solve(b));
    }

    static int CHAR = 26;
    static int arr[];

    private static String solve(String a) {
        arr = new int[CHAR];
        String result = "";
        for(int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a']++;
            char val = nonRep(a);
            if(val != '-')
                result += val;
            else
                result += '#';
        }
        return result;
    }

    private static char nonRep(String a) {

        for(int i = 0; i < a.length(); i++) {
            if(arr[a.charAt(i) - 'a'] == 1)
                return a.charAt(i);
        }
        return '-';
    }
}

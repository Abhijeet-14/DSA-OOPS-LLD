package _dsa.Flipkart;

public class Q12_Serialize {
    public static void main(String[] args) {
        String arr[] = {"scaler", "academy"};

        String res = "";

        for(String val: arr){
            int N = val.length();
            res += val + N + "~";
        }

        System.out.println(res);

    }
}

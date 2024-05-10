package _dsa._15_12_21_practice.Array;

public class C1_Min_Max_Array {
    public static void main(String[] args) {
        int a[] = {1000, 11, 445, 1, 330, 3000};


        Pair res = getMinMax(a, a.length);
        System.out.println("min: " + res.min + " max: " + res.max);
    }

    private static Pair getMinMax(int[] a, int n) {

        if(n < 1)
            return null;

        if(n == 1) {
            Pair p = new Pair();
            p.min = a[0];
            p.min = a[0];
            return p;
        } else {
            Pair p = new Pair();
            p.min = Integer.MAX_VALUE;
            p.max = Integer.MIN_VALUE;
            for(int i = 1; i < n; i++) {
                p.min = Math.min(p.min, a[i]);
                p.max = Math.max(p.max, a[i]);
            }
            return p;
        }
    }

    static class Pair {
        int min;
        int max;

    }
}

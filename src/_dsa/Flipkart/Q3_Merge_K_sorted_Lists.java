package _dsa.Flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q3_Merge_K_sorted_Lists {
    public static void main(String[] args) {
        int a[] = {1, 10, 20};
        int b[] = {4, 11, 13};
        int c[] = {3, 8, 9};

        List<Integer> res = merge(a, b, c);
        System.out.println(res);
    }

    private static List<Integer> merge(int[] a, int[] b, int[] c) {
        int aN = a.length;
        int bN = b.length;
        int cN = c.length;
        int N = Math.min(aN, Math.max(bN, cN));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();

        int i = 0;
        while(i < N) {
            if(i < aN)
                pq.add(a[i]);
            if(i < bN)
                pq.add(b[i]);
            if(i < cN)
                pq.add(c[i]);

            res.add(pq.remove());
            i++;
        }

        while(!pq.isEmpty())
            res.add(pq.remove());

        return res;
    }
}

package _dsa._0_JOB_Change.T13_MonoTonic_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class C1_Intro {
    // A monotonic Queue is a data structure the elements from the front to the end is strictly either increasing or decreasing.
    public static void main(String[] args) {
        int arr[] = {5,3,1,2,4};

        Queue<Integer> q = new LinkedList<>();

        q.add(arr[0]);
        System.out.println("Monotonic Queue - Increasing");
        for(int i=1;i<arr.length;i++){
            while(!q.isEmpty() && q.peek() > arr[i])
                q.poll();
            q.add(arr[i]);
        }
        System.out.println(q);

        System.out.println("Monotonic Queue - Decreasing ?? need to solve");
        q = new LinkedList<>();
        q.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            while(!q.isEmpty() && q.peek() < arr[i])
                q.poll();
            q.add(arr[i]);
        }
        System.out.println(q);

    }
}

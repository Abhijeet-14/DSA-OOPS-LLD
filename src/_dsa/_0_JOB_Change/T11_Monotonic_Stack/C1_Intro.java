package _dsa._0_JOB_Change.T11_Monotonic_Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C1_Intro {
    // A monotonic Stack is a data structure the elements from the front to the end is strictly either increasing or decreasing.
    public static void main(String[] args) {
        int arr[] = {5,3,1,2,4};

        Stack<Integer> s = new Stack<>();

        s.add(arr[0]);
        System.out.println("Monotonic Stack - Increasing");
        for(int i=1;i<arr.length;i++){
            while(!s.isEmpty() && s.peek() > arr[i])
                s.pop();
            s.add(arr[i]);
        }
        System.out.println(s);

        System.out.println("Monotonic Stack - Decreasing");
        s = new Stack<>();
        s.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            while(!s.isEmpty() && s.peek() < arr[i])
                s.pop();
            s.add(arr[i]);
        }
        System.out.println(s);

    }
}

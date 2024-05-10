package _dsa._0_restart.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class C3_Stack_using_Queue {
    public static void main(String[] args) {
        // 2 method:
        // - push is costly
        // - add is costly

        // Ques: 1 5 3 pl 2 pl

        // First Method - push costly
        // push - O(N)
        // pop - O(1)
        StackUsingQueue_M1 s = new StackUsingQueue_M1();
        s.push(1);
        s.push(5);
        s.push(3);
        s.printStack();
        s.pop();
        s.printStack();
        s.push(2);
        s.printStack();
        s.pop();
        s.printStack();

        // 2nd Method - pop costly
    }


    static class StackUsingQueue_M1{
        Queue<Integer> q1;
        Queue<Integer> q2;

        public StackUsingQueue_M1() {
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        public void push(int element){
            while(!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            q1.add(element);
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
        }

        public void pop(){
            q1.poll();
        }

        public void printStack(){
            System.out.println("Stack1: " + q1);
        }
    }

}

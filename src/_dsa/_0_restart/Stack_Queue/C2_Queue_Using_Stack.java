package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class C2_Queue_Using_Stack {
    public static void main(String[] args) {
        // 2 Method:
        //      1. Enqueue is costly
        //      2. Dequeue is costly


        // First Method: Enqueue costly
        // Ques: 1 5 4 DQ 2 DQ
        // Logic:
        // - keep the first element at top.
        // - take 2 stack, s1 & s2  => s1: {} s2: {}
        // - before inserting a ELEMENT we will empty the s1 to s2, => s1: {1} s2: {}
        // - once s1 is empty, put new element at s1  => s1: {} s2: {1}
        // - then empty s2 and put all the element back to s1. => s1: {5} s2: {1}
        // - final: s1: {5, 1}, s2: {}
        // - so we see '1' is always on top.

        // so Dq - O(1)
        // but Enq - O(N)
        QueueUsingStack_M1 q_m1 = new QueueUsingStack_M1();
        q_m1.enqueue(1);
        q_m1.enqueue(5);
        q_m1.enqueue(4);
        q_m1.printQueue();
        q_m1.dequeue();
        q_m1.printQueue();
        q_m1.enqueue(2);
        q_m1.printQueue();
        q_m1.dequeue();
        q_m1.printQueue();

        // 2nd Method: Dequeue costly
        // Ques: 1 5 4 Dq 2 Dq
        // Logic:
        // - here we put element at last of stack,
        // - move all element to s2.
        // - once s1 is of size = 1, we pop it.
        // - s1: {1} s2: {}
        // - s1: {1, 5} s2: {}
        // - s1: {1,5,4} s2: {}
        // - s1: {1,5,4} s2: {}  => Dq
            // - s1: {1,} s2: {4,5}  => Dq -> 1
        // - s1: {} s2: {4,5} => move back to s1
        // - s1: {5,4} s2: {}

        // so Dq - O(N)
        // so Enq - O(1)

        QueueUsingStack_M2 q_m2 = new QueueUsingStack_M2();
        q_m2.enqueue(1);
        q_m2.enqueue(5);
        q_m2.enqueue(4);
        q_m2.printQueue();
        q_m2.dequeue();
        q_m2.printQueue();
        q_m2.enqueue(2);
        q_m2.printQueue();
        q_m2.dequeue();
        q_m2.printQueue();


        // Use: if say, EnQ (70% of time) & Dq (30% of time)
        // so we will use 2nd method, in vice-versa 1st method.
    }

    static class QueueUsingStack_M1 {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public QueueUsingStack_M1(){
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void enqueue(int element){
            if(!s1.isEmpty())
                while(!s1.isEmpty()){
                    s2.add(s1.pop());
                }
            s1.add(element);
            while(!s2.isEmpty()){
                s1.add(s2.pop());
            }
        }

        public void dequeue(){
            s1.pop();
        }

        public void printQueue(){
            System.out.println("Queue1: " + s1);
        }

    }

    static class QueueUsingStack_M2 {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public QueueUsingStack_M2(){
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void enqueue(int element) {
            s1.add(element);
        }

        public void dequeue(){
            if (s1.isEmpty())
                System.out.println("Queue is already Empty!!");


            while(s1.size() > 1){
                s2.add(s1.pop());
            }
            s1.pop();

            while(!s2.isEmpty()){
                s1.add(s2.pop());
            }
        }

        public void printQueue(){
            System.out.println("Queue2: " + s1);
        }

    }
}

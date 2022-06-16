package _dsa._0_restart.Stack_Queue;

import java.util.Stack;

public class C6_GetMin_in_O_1 {
    public static void main(String[] args) {
        // Logic:
        // we will do it with O(n) extra space.
        // we use another stack (minStack)
        // while pushing to s1.
        // - push to s1.
        // - now check the min b/w peek of s1 & peek of minStack.
        // - now push the min to minStack


        minStack s = new minStack();

        s.push(8);
        s.push(10);
        s.push(6);
        s.push(3);
        System.out.println("Min Value: " + s.getMin());
        s.pop();
        System.out.println("Min Value: " + s.getMin());
        s.push(7);
        System.out.println("Min Value: " + s.getMin());

    }

    static class minStack{
        Stack<Integer> s1;
        Stack<Integer> minStack;

        public minStack(){
            this.s1 = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int element){
            this.s1.add(element);
            if(minStack.isEmpty()){
                minStack.push(element);
            }
            else{
                int _min = Math.min(minStack.peek(), s1.peek());
                minStack.push(_min);
            }
        }

        public void pop(){
            s1.pop();
            minStack.pop();
        }

        public int getMin(){
            return minStack.peek();
        }

        public void printMinStack(){
            System.out.println("S1: " + s1);
            System.out.println("MinStack: " + minStack);
        }
    }
}


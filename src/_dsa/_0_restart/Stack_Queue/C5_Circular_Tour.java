package _dsa._0_restart.Stack_Queue;

public class C5_Circular_Tour {
    // PROBLEM:
    // - move left to right
    // - 1 unit petrol -> 1 unit distance
    // - [(d1, p1), (d2, p2) ... ]
    // - going from 0-index to 1-index => distance is d1 & petrol is p1.
    // - if d1<=p1 -> we can travel to next index.
    // - else not possible.

    // Need to find minimum index for a circular tour.

    // e.g., [(5,6), (6,7), (7,4), (8,10), (6,6), (4,5)]
    // 0->1 => d-5 & p-6, Bal - 1
    // 1->2 => d-6 & p-7 + Bal (8), Bal - 2
    // 2->3 => d-7 & p-4 + Bal (6), Bal - -1
    // so can't loop further.
    // So start again from index+1 position.
    // front = 3
    // 3-4 => d-8 & p-10 , bal - 2
    // 4-5 => d-6 & p-6 + bal, bal - 2 + 0
    // 5-6 => d-4 & p-5 + bal, bal - 2 + 1
    // 0-1 => d-5 & p-6 + bal, bal - 3 + 1
    // 1-2 => d-6 & p-7 + bal, bal - 4 + 1
    // 2-3 => d-7 & p-4 + bal, bal - 2
    // front == rear
    // HENCE Circular tour success at index(3)

    public static void main(String[] args) {

        Pair[] arr = {
                new Pair(5,6),
                new Pair(6,7),
                new Pair(7,4),
                new Pair(8,7),
                new Pair(6,7),
                new Pair(4,5),
        };

        // Naive
        // Optimize
        int min_index = optimize_circular_tour(arr);
        System.out.println("Index: " + min_index);
    }

    private static int optimize_circular_tour(Pair arr[]){
        int balance = 0;
        int prevBalance = 0;
        int front = 0;
        int rear = 0;
        int len = arr.length;
        boolean isFlag = false;

//        int i = 0;
//        while(!isFlag){
        for(int i=0; i<len; i++){
            Pair curr = arr[(i)%len];

            if(curr.dist <= curr.petrol + balance){
                rear = (i+1)%len;
//                isFlag = true;
            }

            balance += curr.petrol - curr.dist;

            if(balance<0){
                prevBalance += balance;
                balance = 0;
                front = i+1;
                rear = front;
            }

//            if(isFlag && front == rear)
//                return front;
//
//            isFlag = false;
//            i++;
        }

        if(prevBalance +balance >= 0)
            return front;

        return -1;
    }


    static class Pair {
        int dist;
        int petrol;

        public Pair(int dist, int petrol) {
            this.petrol =petrol;
            this.dist =dist;
        }
    }
}

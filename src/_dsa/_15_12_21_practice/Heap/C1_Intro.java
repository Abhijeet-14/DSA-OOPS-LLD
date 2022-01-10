package _dsa._15_12_21_practice.Heap;

public class C1_Intro {
    // Works for "Complete Binary Tree"
    // Why bcoz it follows "left(2i+1)-right(2i+2)-parent(i+1/2)"
    public static void main(String[] args) {
        int arr[] = {10, 80, 15, 100, 85, 18};

        MinHeap root = new MinHeap(arr);

        root.left(0);
        root.right(1);
        root.parent(5);
    }

    static class MinHeap {
        int arr[];
        int capacity;
        int size;

        private MinHeap(int arr[]) {
            this.arr = arr;
            this.size = arr.length;
            this.capacity = arr.length;
        }

        void left(int i) {
            if(i < this.size)
                System.out.println(this.arr[2 * i + 1]);
        }

        void right(int i) {
            if(i < this.size)
                System.out.println(this.arr[2 * i + 2]);
        }

        void parent(int i) {
            if(i < this.size)
                System.out.println(this.arr[(i - 1) / 2]);
        }
    }


}

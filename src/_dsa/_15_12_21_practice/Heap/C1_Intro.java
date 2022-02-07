package _dsa._15_12_21_practice.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1_Intro {
    // Works for "Complete Binary Tree"
    // Why bcoz it follows "left(2i+1)-right(2i+2)-parent(i+1/2)"
    // insert - O(logN)
    // search - O(N)
    // find_min - O(1)
    // delete_min - O(logN)
    public static void main(String[] args) {
        MinHeap root = new MinHeap();

        root.left(0);
        root.right(1);
        root.parent(5);
    }

    static class MinHeap {
        List<Integer> arr;
        int capacity;
        int size;

        private MinHeap() {
            this.arr = new ArrayList<>();
            this.size = arr.size();
        }

        void left(int i) {
            if(i < this.size)
                System.out.println(this.arr.get(2 * i + 1));
        }

        void right(int i) {
            if(i < this.size)
                System.out.println(this.arr.get(2 * i + 2));
        }

        void parent(int i) {
            if(i < this.size)
                System.out.println(this.arr.get((i - 1) / 2));
        }

        int peek() {
            if(this.size == 0)
                return -1;

            // return root
            return this.arr.get(0);
        }

        void add(int val) {
            this.arr.add(val);
            this.size += 1;
            // re-arrange last element
            upHeapify(this.size - 1);
        }

        private void upHeapify(int i) {
            if(i == 0)
                return;

            int parent_idx = (i - 1) / 2;

            if(this.arr.get(i) > parent_idx) {
                // swap parent & last leaf node
                swap(i, parent_idx);

                upHeapify(parent_idx);
            }
        }

        private int remove() {
            if(this.size == 0)
                return -1;

            // swap root & last leaf
            swap(0, this.size - 1);
            int val = this.arr.remove(this.size - 1);

            this.size -= 1;
            downHeapify(0);
            return val;
        }

        private void downHeapify(int parent) {
            if(this.size == 0)
                return;

            int li = 2 * parent + 1;
            int ri = 2 * parent + 2;

            int mini = parent;
            if(this.size > li && this.arr.get(mini) > this.arr.get(li)) {
                mini = li;
            }

            if(this.size > ri && this.arr.get(mini) > this.arr.get(ri)) {
                mini = ri;
            }

            // if mini != parent
            if(mini != parent) {
                swap(mini, parent);
                downHeapify(mini);
            }
        }


        private void swap(int i, int parent_idx) {
            int temp = this.arr.get(parent_idx);
            this.arr.set(parent_idx, this.arr.get(i));
            this.arr.set(i, temp);
        }

    }


}

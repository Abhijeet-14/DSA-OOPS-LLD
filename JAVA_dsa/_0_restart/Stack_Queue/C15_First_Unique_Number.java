package _dsa._0_restart.Stack_Queue;

import java.util.*;

public class C15_First_Unique_Number {
    public static void main(String[] args) {
        FirstUnique fu = new FirstUnique(new ArrayList<>(Arrays.asList(5,3,2,3)));
        fu.ShowFirstUnique();
        fu.add(5);
        fu.add(2);
        fu.add(3);
    }

    static class FirstUnique {
        List<Integer> arr = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        public FirstUnique(List<Integer> arr){
            for(int val: arr) {
                this.arr.add(val);
                if(map.containsKey(val))
                    this.map.put(val, map.get(val)+1);
                else
                    this.map.put(val, 1);
            }
        }

        public void ShowFirstUnique(){
            for(int key: map.keySet()){
                if(map.get(key) == 1){
                    System.out.println("FirstUnique: " + key);
                    return;
                }
            }

            System.out.println("FirstUnique: " + -1);
        }

        public void add(int element){
            this.arr.add(element);
            this.map.put(element, map.get(element)+1);
            this.ShowFirstUnique();
        }
    }
}

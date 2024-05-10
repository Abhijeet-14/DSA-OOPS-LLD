package _dsa._15_12_21_practice.LinkedList;

public class C1_Middle_Of_LL {


    public static void main(String[] args) {
        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
//        root.next.next.next.next = new Node(50);

        int res = findMiddle(root);
        System.out.println(res);
    }

    private static int findMiddle(Node root) {
        if(root == null)
            return -1;
        Node first = root; // 2 jump
        Node sec = root;  // 1 jump

        while(first != null && sec != null) {
            if(first.next != null) {
                first = first.next.next;
                sec = sec.next;
            } else
                first = null;
        }

        return sec.data;
    }
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

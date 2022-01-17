package _dsa._15_12_21_practice.LinkedList;

public class C3_Reverse_A_LL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
        root.next.next.next.next = new Node(50);

        Node tail = reverseALL(root);

        while(tail != null) {
            System.out.print(tail.data + "->");
            tail = tail.next;
        }
    }

    private static Node reverseALL(Node root) {
        if(root == null)
            return root;

        Node tail = null;
        Node head = root;

        while(head != null) {
            Node next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }

        return tail;
    }
}

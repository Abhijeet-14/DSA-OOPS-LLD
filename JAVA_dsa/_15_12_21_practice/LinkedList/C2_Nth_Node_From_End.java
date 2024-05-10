package _dsa._15_12_21_practice.LinkedList;

public class C2_Nth_Node_From_End {
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

        int N = 0;
        int res = findNnode(root, N);
        System.out.println(res);
    }

    private static int findNnode(Node root, int N) {
        Node first = root;
        Node sec = root;

        int len = 0;
        for(int i = 0; i < N; i++) {
            if(first == null)
                return -1;
            first = first.next;
        }

        while(first != null) {
            first = first.next;
            sec = sec.next;
        }

        if(sec == null)
            return -1;
        return sec.data;
    }
}

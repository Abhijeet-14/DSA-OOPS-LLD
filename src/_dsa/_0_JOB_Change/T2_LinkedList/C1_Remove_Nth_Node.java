package _dsa._0_JOB_Change.T2_LinkedList;

public class C1_Remove_Nth_Node {
    public static void main(String[] args) {
        // [1,2,3,4,5]
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        int n = 2;

        // N-loop first & 2-pointer
        removeNthFromEnd_2_Pointer(root, n);
        printLinkedList(root);
    }

    public static ListNode removeNthFromEnd_2_Pointer(ListNode head, int n) {
        ListNode temp_1 = head;
        ListNode temp_2 = head;

        while(n-->0)
            if(temp_2 != null)
                temp_2 =temp_2.next;

        ListNode prev = null;

        while(temp_2 != null && temp_1 != null){

            temp_2 = temp_2.next; // 3 4 5

            if(temp_1.next != null) // 1 2 3 4
                prev = temp_1;
            temp_1 = temp_1.next; // 2 3 4

        }

        // remove node
        if(prev == null)
            head = head.next;
        else if(temp_1 != null)
            prev.next = temp_1.next;

        return head;
    }


    private static void printLinkedList(ListNode root) {
        while (root!=null)
        {
            System.out.print(root.val);
            root = root.next;
        }
        System.out.println();
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C7_Rotate_List {

    // Question: https://leetcode.com/problems/rotate-list/

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode ans = solve_2_pointer(head, k);

        ListNode.printListNode(ans);
    }

    public static ListNode solve_2_pointer(ListNode head, int k){
        int find_node_length = 0;

        // find length LinkedList - start
        ListNode t4 = head;
        while(t4!=null){
            t4 = t4.next;
            find_node_length++;
        }
        // find length LinkedList - end

        if(find_node_length > 1) // corner case
            k = k%find_node_length;
        else
            return head;

        if(k == 0) // corner case
            return head;

        ListNode t1 = head;
        ListNode t2 = head;

        int n = k;

        while(n>0 && t2 != null){
            t2 = t2.next;
            n--;
        }

        ListNode prev= null;
        while(t2!=null && t1 !=null){
            t2 = t2.next;
            if(t1 != null){
                prev = t1;
                t1 = t1.next;
            }
        }

        // split node at k
        if(prev!=null)
            prev.next = null;

        // store at new node at k point
        ListNode t3 = t1;
        while(t1 != null && t1.next!=null) // corner case
            t1 = t1.next;

        // add prev node list & new list node from k-point
        t1.next = head;

        return t3;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public static void printListNode(ListNode ans){
          while(ans!=null){
              System.out.print(ans.val + ", ");
              ans = ans.next;
          }
          System.out.println();
      }
 }
}

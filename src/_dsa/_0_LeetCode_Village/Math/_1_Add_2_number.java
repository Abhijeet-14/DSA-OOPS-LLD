package _dsa._0_LeetCode_Village.Math;


public class _1_Add_2_number {
    /* Problem Statement: 
    * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    * Example: 
    * l1: 2->4->3 and  l2: 5->6->4 
    * result: 7->0->8
    */
    public static void main(String[] args) {

    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* Logic:
        * add l1.val + l2.val + carry
        * if total > 10... then take 0th digit number
        * and make carry as total/10
        *
        * In last if carry > 0 ... add that to last NODE.
        */
        ListNode curr = new ListNode(-1);
        ListNode res = curr;
        
        
        int carry = 0;
        while(l1!=null || l2 != null){
        
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            
            int sum  = x + y + carry;
            
            carry = sum / 10;
            
            curr.next = new ListNode( sum % 10);
            
            curr = curr.next;
            
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        
        if (carry>0)
            curr.next = new ListNode(carry);
        
        if(res.next == null)
            return new ListNode(0);
        
        return res.next ;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(){}
        public ListNode(int data){this.val = data;}
        public ListNode(int data, ListNode next){this.val = data; this.next = next;}

    }
}

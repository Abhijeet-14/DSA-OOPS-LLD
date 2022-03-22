package _dsa._0_LeetCode_Village.Math;


public class _1_Add_2_number {
    /* Problem Statement: 
    * An ugly number is a positive integer that is divisible by a, b, or c.
    * Given four integers n, a, b, and c, return the nth ugly number.    
    */
    public static void main(String[] args) {

    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
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
}

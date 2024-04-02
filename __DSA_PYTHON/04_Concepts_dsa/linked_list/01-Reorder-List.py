""" Problem: [https://leetcode.com/problems/reorder-list/]
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head

        curr = head
        # find middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        # reverse from midlle to end
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        tail = prev
        cs = head
        count = 0
        # Merge 2 List
        while tail and cs.next:
            if count % 2 == 0:
                temp = cs.next
                cs.next = ListNode(tail.val)
                if temp!=tail:
                    cs.next.next = temp

                tail = tail.next
            cs = cs.next
            count += 1

        

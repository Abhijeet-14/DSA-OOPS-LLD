"""LC: [https://leetcode.com/problems/reverse-nodes-in-k-group/]"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def build_from_arr(arr):
        """Build Linked List from Array"""
        head = None
        t = None
        for v in arr:
            if not head:
                head = ListNode(v)
                t = head
            else:
                t.next = ListNode(v)
                t = t.next
        return head

    @staticmethod
    def print_ll(head):
        curr = head
        while curr:
            print(curr.val)
            curr = curr.next


class Solution:
    def reverseKGroup(self, head: [ListNode], k: int) -> [ListNode]:
        """
        TC - O(N) SC - O(1)
        Approach:
            - check valid list & reverse sub-list
            - store tail -- and tail.next == new_reverse_list_head
        """

        def reverse(node, k):
            prev = None
            for _ in range(k):
                temp = node.next
                node.next = prev
                prev = node
                node = temp

            return prev, node

        def is_valid(node, k):
            track = node
            for i in range(k - 1):
                track = track.next
                if track == None:
                    return False
            return True

        curr = head

        prev_tail = (
            None  # store tail of each reverse -- and on next reverse list add it to reverse head
        )
        new_head = None  # new head after 1st reverse list

        while curr and is_valid(curr, k):
            start = curr
            reverse_list_head, curr = reverse(curr, k)

            if new_head is None:
                new_head = reverse_list_head

            if prev_tail:
                prev_tail.next = reverse_list_head  # add tail.next to new reverse

            prev_tail = start  # store tail

        if prev_tail:
            prev_tail.next = curr

        return new_head if new_head else head


arr = [1, 2, 3, 4, 5]
head = ListNode.build_from_arr(arr)

k = 2
res_head = Solution().reverseKGroup(head, k)

ListNode.print_ll(res_head)

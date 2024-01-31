class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


def detect_cycle(head):
    curr = head

    node_set = set()
    while curr:
        if curr.val in node_set:
            return True
        node_set.add(curr.val)
        curr = curr.next

    return False


head = None

for i in range(5):
    head = Node(i + 1, head)

# insert cycle
head.next.next.next.next.next = head.next.next

print("Cycle Found ", detect_cycle(head))

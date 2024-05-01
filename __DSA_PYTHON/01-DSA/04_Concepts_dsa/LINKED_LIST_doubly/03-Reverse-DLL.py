class DLL:
    def __init__(self, data, prev=None, next=None) -> None:
        self.data = data
        self.next = next
        self.prev = prev


def print_dll(head):
    curr = head
    while curr:
        print(curr.data, end="->")
        curr = curr.next
    print()


def reverse_dll(head):

    if not (head or head.next):
        return head

    prev = None
    curr = head
    while curr:
        # Swap
        prev = curr.prev  # 10 = 20.p = 30
        curr.prev = curr.next  #  20.p =  20.n= 30
        curr.next = prev  # 20.n = 10

        curr = curr.prev  # 20 = 20.p = 30

    return prev.prev


head = DLL(10)
head.next = DLL(20)
head.next.prev = head
head.next.next = DLL(30)
head.next.next.prev = head.next
head.next.next.next = DLL(40)
head.next.next.next.prev = head.next.next


print_dll(head)
head = reverse_dll(head)
print_dll(head)

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


def delete_head( head):
    temp = head.next
    head.next  = None
    temp.prev = None
    head = temp

    return head


head = DLL(10)
head.next = DLL(20)
head.next.prev = head
head.next.next = DLL(30)
head.next.next.prev = head.next
head.next.next.next = DLL(40)
head.next.next.next.prev = head.next.next


print_dll(head)
head = delete_head(head)
print_dll(head)
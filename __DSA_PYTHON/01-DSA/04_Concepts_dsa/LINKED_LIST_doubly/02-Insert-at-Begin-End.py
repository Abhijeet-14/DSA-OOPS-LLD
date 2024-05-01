class DLL:
    def __init__(self, data, prev=None, next=None) -> None:
        self.data = data
        self.next = next
        self.prev = prev


def insert_at_begin(data, head):
    temp = DLL(data)

    temp.next = head
    if head != None:
        head.prev = temp

    return temp


def insert_at_end(data, head):
    curr = head
    while curr.next:
        curr = curr.next

    temp = DLL(data)
    curr.next = temp
    temp.prev = curr

    return head


def print_dll(head):
    curr = head
    while curr:
        print(curr.data, end="->")
        curr = curr.next
    print()


head = DLL(10)
head.next = DLL(20)
head.next.prev = head
head.next.next = DLL(30)
head.next.next.prev = head.next

print_dll(head)
head = insert_at_begin(5, head)
print_dll(head)
head = insert_at_end(35, head)
print_dll(head)

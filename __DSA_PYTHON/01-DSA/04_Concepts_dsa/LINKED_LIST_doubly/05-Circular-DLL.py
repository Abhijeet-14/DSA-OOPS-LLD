class CircularDLL:
    _head = None
    _tail = None

    def __init__(self, data, prev=None, next=None):
        self.data, self.prev, self.next = data, prev, next

    def insert_node(self, data):
        temp = CircularDLL(data)

    @staticmethod
    def print_cdll():
        curr = CircularDLL._head

        while curr.next.data != CircularDLL._head.data:
            print(curr.data, end="->")
            curr = curr.next

CircularDLL._head = CircularDLL(10)
CircularDLL._head.next = CircularDLL(20)
CircularDLL._head.next.prev = CircularDLL._head
CircularDLL._head.next.next = CircularDLL(30)
CircularDLL._head.next.next.prev = CircularDLL._head.next
CircularDLL._head.next.next.next = CircularDLL._head
CircularDLL._head.prev = CircularDLL._head.next.next

CircularDLL.print_cdll()
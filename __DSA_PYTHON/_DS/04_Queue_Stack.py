##### SINGLE END QUEUE ######
from queue import Queue

print("========= QUEUE =========")

my_queue = Queue()

# Enqueue elements
my_queue.put(1)
my_queue.put(2)
my_queue.put(3)

print("QUEUE: ", my_queue)  # o/p - <queue.Queue object at Ox...>
print("QUEUE list: ", my_queue.queue)  # o/p - [1,2,3]

print("Peek: ", my_queue.queue[0])  # o/p - 1

# To pop - FIFO -- .get() or pop(0)
element = my_queue.get()
print("Dequeued element:", element)

# is_empty
print(my_queue.empty())  # o/p - False

# q-size
print(my_queue.qsize())  # o/p - 2

element = my_queue.pop(0)
print(element)  # o/p - 2


##### STACK ######
print("========= STACK =========")
stack = []
stack.append(2)
stack.append(5)
stack.append(9)

print("Stack: ", stack)
print("peek: ", stack[-1])
print("Pop: ", stack.pop())
print("Is_Empty: ", not bool(stack), len(stack) > 0)

##### DOUBLE END QUEUE ######
print("========= DOUBLE END QUEUE =========")
from collections import deque

my_deque = deque()

# append-right
my_deque.append(1)
my_deque.append(2)
my_deque.append(3)

# append-left
my_deque.appendleft(0)

# pop-right
my_deque.pop()

# pop-left
my_deque.popleft()

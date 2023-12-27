##### SINGLE END QUEUE ######
from queue import Queue

my_queue = Queue()

# Enqueue elements
my_queue.put(1)
my_queue.put(2)
my_queue.put(3)

# To pop - FIFO -- .get() or pop(0)
element = my_queue.get()
print("Dequeued element:", element)
print(my_queue) # o/p - <queue.Queue object at Ox...>

# is_empty
print(my_queue.empty()) # o/p - False

# q-size
print(my_queue.qsize()) # o/p - 2

element = my_queue.pop(0) 
print(element) # o/p - 2

print(my_queue) # o/p - <queue.Queue object at Ox...>


##### DOUBLE END QUEUE ######
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


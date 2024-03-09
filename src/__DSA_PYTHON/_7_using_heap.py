import heqpq


############### MIN-HEAP ##########
heap = []

# Push elements onto the heap
heapq.heappush(heap, 4)
heapq.heappush(heap, 1)
heapq.heappush(heap, 7)
heapq.heappush(heap, 3)

# Peek at the smallest element without removing it
smallest_element = heap[0]
print("Peeked Smallest Element:", smallest_element)  # o/p - 1

# Pop the smallest element from the heap
min_element = heapq.heappop(heap)

print("Popped Min-Element:", min_element)  # o/p - 1
print("Remaining Min-Heap:", heap)  # o/p - [3,4,7]


############# MAX-HEAP ############
max_heap = []

# Push elements onto the heap (negate values)
heapq.heappush(max_heap, -4)
heapq.heappush(max_heap, -1)
heapq.heappush(max_heap, -7)
heapq.heappush(max_heap, -3)

print("Max-Heap (Negated Values):", max_heap)  # o/p - [-7, -3, -4, -1]

# Pop the largest element from the max-heap (negate result)
max_element = -heapq.heappop(max_heap)

print("Popped Max-Element:", max_element)  # o/p - 7
print("Remaining Max-Heap (Negated Values):", max_heap)  # o/p - [-4,-3,-1]


############ CUSTOMIZE OBJECT SORTING #############
class CustomObject:
    def __init__(self, name, priority):
        self.name = name
        self.prioirty = priority

    def __lt__(self, other):
        # Customize the less-than comparison for sorting
        return self.priority < other.priority


custom_heap = []

# Push elements onto the heap using tuples (priority, object)
heapq.heappush(custom_heap, CustomObject("Object1", 3))
heapq.heappush(custom_heap, CustomObject("Object2", 1))
heapq.heappush(custom_heap, CustomObject("Object3", 5))

while custom_heap:
    custom_object = heapq.heappop(custom_heap)
    print(custom_object)  # o/p - 1 , 3 , 5

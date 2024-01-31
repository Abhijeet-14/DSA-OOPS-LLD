import heapq

print("\n======== Heap - Min========")
heap = []
# add
heapq.heappush(heap, 4)
heapq.heappush(heap, 2)
heapq.heappush(heap, 8)
heapq.heappush(heap, 6)

print("\tHeap: ", heap)
print("\tPeek min Element: ", heap[0])
print("\tPop min Element: ", heapq.heappop(heap))
print("\tHeap: ", heap)

print("\n======== Heap - Max ========")
max_heap = []
# add with adding -ve
heapq.heappush(max_heap, -7)
heapq.heappush(max_heap, -5)
heapq.heappush(max_heap, -3)
heapq.heappush(max_heap, -1)

print("\tMax-Heap: ", max_heap)
print("\tPeek max Element: ", max_heap[0])
print("\tPop max Element: ", -heapq.heappop(max_heap))
print("\tMax-Heap: ", max_heap)


print("\n======== Custom-Heap ========")


class CustomObject:
    def __init__(self, name, priority):
        self.name = name
        self.priority = priority

    def __lt__(self, other):
        return self.priority < other.priority  # min
        # return self.priority > other.priority  # max

    def __str__(self):
        return self.name


def view_heap(heap):
    heap_list = []
    for item in heap:
        heap_list.append(item.name)

    return heap_list


custom_heap = []
# add with adding -ve
heapq.heappush(custom_heap, CustomObject("Ob1", 9))
heapq.heappush(custom_heap, CustomObject("Ob2", 5))
heapq.heappush(custom_heap, CustomObject("Ob3", 7))

print("\tMax-Heap: ", view_heap(custom_heap))
print("\tPeek max Element: ", custom_heap[0])
print("\tPop max Element: ", heapq.heappop(custom_heap).name)
print("\tMax-Heap: ", view_heap(custom_heap))
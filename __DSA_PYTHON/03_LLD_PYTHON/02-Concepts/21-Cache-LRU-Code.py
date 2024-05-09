class DLLNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

    def __str__(self):
        return self.value


class LRU_Cache:
    def __init__(self, capcity) -> None:
        self.cache = {}
        self.capacity = capcity
        self.head: DLLNode = None
        self.tail: DLLNode = None

    def print_cache(self):
        map = {}
        for key, node in self.cache.items():
            map[key] = node.value
        print(map)

    def print_dll(self):
        curr = self.head
        while curr:
            print(curr.key, end=" -> ")
            curr = curr.next
        print()

    def delete_tail(self):
        temp = self.tail
        prev_node = temp.prev
        if prev_node:
            prev_node.next = None
        self.tail = prev_node
        return temp

    def delete_node_by_pointer(self, node):  # O(1)
        prev_node = node.prev
        next_node = node.next

        if prev_node:
            prev_node.next = next_node
        if next_node:
            next_node.prev = prev_node

        if node.key == self.tail.key:
            self.tail = prev_node

        node.prev = None
        node.next = None

    def set_node_to_head(self, node):
        if not self.head:
            node.next = self.tail
            self.tail = node
            self.head = node
            return
        temp = self.head
        temp.prev = node
        node.next = temp

        self.head = node

    def get(self, key):
        # key - exist
        #   No
        if not self.cache.get(key):
            return None

        #   Yes
        node: DLLNode = self.cache[key]

        #       1. re-arrange Key to Head
        self.delete_node_by_pointer(node)
        self.set_node_to_head(node)
        #       2. return value
        return node.value

    def put(self, key, value):
        # key exist
        # update
        if self.cache.get(key):
            node: DLLNode = self.cache[key]
            node.value = value
            return

        node: DLLNode = DLLNode(key, value)
        # not exist
        # is-Full?
        # No
        if len(self.cache.keys()) < self.capacity:
            # add_item
            self.cache[key] = node
            self.set_node_to_head(node)
            return

        # Yes
        print("Cache Capacity full")
        # delete Tail
        lru_node = self.delete_tail()
        del self.cache[lru_node.key]
        # add to head
        self.set_node_to_head(node)
        self.cache[key] = node


cache = LRU_Cache(2)

cache.put(3, 1)
cache.print_cache()
cache.print_dll()

cache.put(4, 2)
cache.print_cache()
cache.print_dll()

cache.put(1, 5)
cache.print_cache()
cache.print_dll()

res = cache.get(5)
print(res)
# cache.print_dll()

res = cache.get(4)
print(res)
cache.print_dll()

cache.put(5, 3)
cache.print_cache()
cache.print_dll()

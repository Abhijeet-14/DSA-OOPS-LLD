print("\n============ 2D matrix -> Graph ============")
# Pending

print("\n============ Graph ============")
graph = {}


def add_edge(node_1, node_2):
    if node_1 in graph:
        graph[node_1].append(node_2)
    else:
        graph[node_1] = [node_2]

    # bi-direction
    if node_2 in graph:
        graph[node_2].append(node_1)
    else:
        graph[node_2] = [node_1]


add_edge(0, 1)
add_edge(1, 2)
add_edge(1, 3)
add_edge(3, 4)


def print_graph(graph):
    for node in graph:
        print(f"{node}: {', '.join(map(str, graph[node]))}")


print_graph(graph)


def visited_node(n):
    return [False] * n


print("\n============ BFS ============")
visited = visited_node(5)
from queue import Queue


def bfs(source):
    q = Queue()
    q.put(source)
    visited[source] = True

    while not q.empty():
        parent_idx = q.queue[0]
        parent = graph.get(parent_idx)
        q.get()

        print(parent_idx, end=" -> ")

        for child in parent:
            if visited[child] == False:
                q.put(child)
                visited[child] = True
    print()


# bfs(0)

print("\n============ Count Graph ============")
count = 0
for i in graph.keys():
    if not visited[i]:
        print("Trip: ", count + 1)
        bfs(i)
        count += 1
print("\nBFs Count Graph: ", count)


print("\n============ DFS ============")
visited = visited_node(5)


def dfs(source):
    visited[source] = True

    parent = graph.get(source)
    print(source, end=" -> ")

    for child in parent:
        if visited[child] == False:
            dfs(child)


dfs(0)


print("\n============ Dijkstra - with Weight ============")
graph = {}


class Node:
    def __init__(self, to, wt):
        self.to = to
        self.wt = wt

    def __lt__(self, other):
        return self.wt < other.wt


def add_edge(u, v, wt):
    graph[u] = graph.get(u, []) + [Node(v, wt)]
    graph[v] = graph.get(v, []) + [Node(u, wt)]


add_edge(0, 1, 4)
add_edge(1, 2, 8)
add_edge(2, 3, 7)
add_edge(3, 4, 1)
add_edge(4, 5, 10)
add_edge(5, 6, 2)
add_edge(6, 7, 1)
add_edge(7, 0, 8)
add_edge(7, 1, 11)
add_edge(8, 7, 7)
add_edge(8, 6, 6)
add_edge(8, 2, 2)
add_edge(5, 2, 4)
add_edge(5, 3, 14)


def print_graph(graph):
    for node in graph:
        print(f"{node}", end=": ")
        for child in graph[node]:
            print(f"{child.to} ({child.wt})", end=", ")
        print()


print_graph(graph)


import heapq


def shortest_path(n):
    return [float("inf")] * n


shortest_path = shortest_path(9)


# """
# class Node:
#     def __init__(self, to, wt):
#         self.to = to
#         self.wt = wt


#
#     def __lt__(self, other):
#         return self.wt < other.wt
# """
class Node:
    def __init__(self, to, wt):
        self.to = to
        self.wt = wt

    def __lt__(self, other):
        return self.wt < other.wt


def dijkstra_w(source):
    heap = []

    heapq.heappush(heap, Node(source, 0))
    shortest_path[source] = 0

    while len(heap) > 0:
        parent_idx = heap[0]
        parent = graph.get(parent_idx.to)
        heapq.heappop(heap)

        for child in parent:
            if shortest_path[parent_idx.to] + child.wt < shortest_path[child.to]:
                shortest_path[child.to] = shortest_path[parent_idx.to] + child.wt
                heapq.heappush(
                    heap, Node(child.to, shortest_path[parent_idx.to] + child.wt)
                )


dijkstra_w(0)
print("\nShortest Path: ", shortest_path)


print("\n============ Cycle ============")
print("\n============ UnCycle ============")
print("\n============ Topological ============")


heap = []

heapq.heappush(heap, (5, 1))
heapq.heappush(heap, (4, 2))
heapq.heappush(heap, (3, 3))
heapq.heappush(heap, (2, 4))
heapq.heappush(heap, (1, 5))

print(heap)

heapq.heapify(heap, key=lambda x: x[1])
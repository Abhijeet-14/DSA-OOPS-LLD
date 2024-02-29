graph = {}


def add_edge(node_1, node_2, wt):
    if node_1 in graph:
        graph[node_1].append((node_2, wt))
    else:
        graph[node_1] = [(node_2, wt)]
    if node_2 in graph:
        graph[node_2].append((node_1, wt))
    else:
        graph[node_2] = [(node_1, wt)]


add_edge(0, 1, 4)
add_edge(1, 2, 8)
add_edge(2, 3, 7)
add_edge(3, 4, 9)
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


edge = 8
weight = [float("inf")] * (edge + 1)

import heapq


def dijikstra_W(source):
    heap = []

    heapq.heappush(heap, (source, 0))
    weight[source] = 0
    while len(heap) > 0:
        parent_tuple = heapq.heappop(heap)
        parent = graph.get(parent_tuple[0], [])

        print(weight)
        for child in parent:
            print(
                child,
                parent,
                parent_tuple,
                weight[parent_tuple[0]] + child[1],
                weight[child[0]],
            )
            if weight[parent_tuple[0]] + child[1] < weight[child[0]]:
                weight[child[0]] = weight[parent_tuple[0]] + child[1]
                heapq.heappush(heap, (child[0], weight[child[0]]))


dijikstra_W(0)
print(weight)

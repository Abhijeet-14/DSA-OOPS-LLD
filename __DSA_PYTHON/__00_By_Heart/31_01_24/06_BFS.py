graph = {
    1: [2, 3],
    2: [4, 5],
    4: [6],
    9: [7, 11],
    11: [12],
    12: [11],
    7: [8],
    8: [7],
    10: [8],
    8: [10],
}

from queue import Queue


def bfs(
    graph,
    visited,
    source,
):
    q = Queue()
    q.put(source)

    while not q.empty():
        parent_idx = q.get()
        parent = graph.get(parent_idx, [])

        visited.add(parent_idx)

        print(parent_idx, end=" -> ")
        for child in parent:
            if child not in visited:
                q.put(child)


# dfs(graph, visited, 1)


count = 0
visited = set()

for key in graph.keys():
    if key not in visited:
        bfs(graph, visited, key)
        count += 1
        print()

print("\nCount: ", count)

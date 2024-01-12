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

graph = {}


def add_edge(graph, node_1, node_2):
    if node_1 in graph:
        graph[node_1].append(node_2)
    else:
        graph[node_1] = [node_2]
    if node_2 in graph:
        graph[node_2].append(node_1)
    else:
        graph[node_2] = [node_1]


def print_graph(graph):
    print(graph.keys())
    for node in graph:
        print(f"{node}: {'->'.join(map(str, graph[node]))}")


add_edge(graph, 1, 2)
add_edge(graph, 1, 3)
add_edge(graph, 2, 4)
add_edge(graph, 2, 5)
add_edge(graph, 4, 6)

print_graph(graph)

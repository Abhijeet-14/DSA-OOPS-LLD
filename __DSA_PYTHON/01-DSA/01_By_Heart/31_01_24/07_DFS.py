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


def dfs(
    graph,
    visited,
    source,
):
    curr_node_list = graph.get(source, [])
    visited.add(source)
    # print(source, end=" -> ")
    for child in curr_node_list:
        if child not in visited:
            dfs(graph, visited, child)


# dfs(graph, visited, 1)


count = 0
visited = set()

for key in graph.keys():
    if key not in visited:
        print(key, visited)
        dfs(graph, visited, key)
        count += 1

print("\nCount: ", count)

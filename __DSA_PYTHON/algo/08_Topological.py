"""
It work on ONLY - Direacted Acycle Graph
Why Topological Sort?
    - it tell ORDERING of nodes in Directed Acyclic Graph
"""
adjacency_matrix = {"A": ["B", "C"], "B": ["D"], "C": ["D", "E"], "D": [], "E": []}


def topological_sort(node, visited, result):
    visited.add(node)
    for child in node:
        if child not in visited:
            topological_sort(child, visited, result)
    result.append(node)


visited = set()
result = []


for node in adjacency_matrix:
    if node not in visited:
        topological_sort(node, visited, result)
print(result)

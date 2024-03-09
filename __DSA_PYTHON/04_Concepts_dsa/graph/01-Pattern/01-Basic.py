"""
1. DFS - [TC - O(N) || DS - Hashset]
2. BFS - [TC - O(N) || DS - Queue, HashSet]
3. Union-Find - [TC - O(NlogN) || DS = Forest of Trees]
4. Topological Sort - [TC-O(N) || DS - HashSet]
5. Dijkstra - [TC-O(E*logV) || DS - Heap, Set]
6. Min Spanning Tree(Prim's or Krushkal's) - [TC - ?? || DS - ??]
7. Floyd Warshall's Algo - [TC - ?? || DS - ??]
"""

from collections import deque
import heapq


class Graph:
    def __init__(self):
        self.graph = {}
        self.visited = set()
        self.shortest_path = []

    def convert_adjancy_matrix_to_graph(self, matrix):
        for row_idx, row in enumerate(matrix):
            for col_idx, col in enumerate(row):
                if col == 1:
                    self.add_edge(row_idx, col_idx)

    def add_edge(self, node_1, node_2):
        if node_1 in self.graph:
            if node_2 not in self.graph[node_1]:
                self.graph[node_1].append(node_2)
        else:
            self.graph[node_1] = [node_2]

        # bi-direction
        if node_2 in self.graph:
            if node_1 not in self.graph[node_2]:
                self.graph[node_2].append(node_1)
        else:
            self.graph[node_2] = [node_1]

    def print_graph(self):
        for node in self.graph:
            print(f"{node}: {', '.join(map(str, self.graph[node]))}")

    def dfs(self, source):
        """[TC - O(N) || DS - Hashset]"""
        parent = self.graph.get(source)
        self.visited.add(source)
        print(source, end=" -> ")

        for child in parent:
            if child not in self.visited:
                self.dfs(child)

    def bfs(self, source):
        """[TC - O(N) || DS - Queue, HashSet]"""
        queue = deque()
        queue.append(source)
        self.visited.add(source)
        while len(queue) != 0:
            parent_value = queue.popleft()
            parent = self.graph.get(parent_value)
            print(parent_value, end=" -> ")
            for child in parent:
                if child not in self.visited:
                    queue.append(child)
                    self.visited.add(child)
        print()

    def dijkstra_bfs(self, source):
        """[TC-O(E*logV) || DS - Heap, Set]"""
        heap = []
        heapq.heappush(heap, source)
        self.shortest_path[source] = 0
        while len(heap) > 0:
            parent_value = heapq.heappop(heap)
            parent = self.graph.get(parent_value)
            for child in parent:
                if self.shortest_path[parent_value] + 1 < self.shortest_path[child]:
                    heapq.heappush(heap, child)
                    self.shortest_path[child] = self.shortest_path[parent_value] + 1

        print("Shortest Path with Weight 1: ", self.shortest_path)

    def dijkstra_weighted(self):
        pass

    def topological_sort(self, source, result: list[int]):
        """[TC-O(N) || DS - HashSet]"""

        parent = self.graph.get(source)
        self.visited.add(source)
        for child in parent:
            if child not in self.visited:
                self.topological_sort(child, result)

        result.append(source)


graph = Graph()

matrix = [[0, 1, 1, 0], [1, 0, 1, 1], [1, 1, 0, 1], [0, 1, 1, 0]]

### convert matrix to graph
graph.convert_adjancy_matrix_to_graph(matrix)
graph.print_graph()


graph.graph = {}
graph.add_edge(0, 1)
graph.add_edge(1, 3)
graph.add_edge(1, 4)
graph.add_edge(0, 2)
graph.add_edge(5, 2)
graph.add_edge(6, 2)

### DFS
graph.dfs(0)
print()

### BFS
graph.visited = set()
graph.bfs(0)

### Djikstra without weight
graph.shortest_path = [float("inf")] * len(graph.graph.keys())
graph.dijkstra_bfs(0)

### Topological Sort
graph.visited = set()
result = []
graph.topological_sort(0, result)
print(result)

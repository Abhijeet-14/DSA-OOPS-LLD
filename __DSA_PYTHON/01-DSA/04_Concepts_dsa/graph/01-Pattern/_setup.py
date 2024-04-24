class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, node_1, node_2, bi_directional=True):
        if node_1 in self.graph:
            if node_2 not in self.graph[node_1]:
                self.graph[node_1].append(node_2)
        else:
            self.graph[node_1] = [node_2]

        # bi-direction
        if bi_directional:
            if node_2 in self.graph:
                if node_1 not in self.graph[node_2]:
                    self.graph[node_2].append(node_1)
            else:
                self.graph[node_2] = [node_1]

    def print_graph(self):
        for node in self.graph:
            print(f"{node}: {', '.join(map(str, self.graph[node]))}")

    def convert_adjancy_matrix_to_graph(self, matrix):
        for row_idx, row in enumerate(matrix):
            for col_idx, col in enumerate(row):
                if col == 1:
                    self.add_edge(row_idx, col_idx)

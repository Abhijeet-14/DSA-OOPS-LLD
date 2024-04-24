from _setup import Graph

matrix = [
    [1, 1, 0, 0, 0],
    [1, 1, 0, 0, 0],
    [0, 0, 1, 0, 0],
    [0, 0, 0, 1, 1],
]

from collections import deque


def solution(matrix):
    if not matrix:
        return 0
    graph = Graph()
    graph.convert_adjancy_matrix_to_graph(matrix)

    def bfs(graph, visited, source):
        q = deque()
        q.append(source)
        visited.add(source)

        while len(q) > 0:
            parent_value = q.popleft()
            parent = graph.get(parent_value)

            for child in parent:
                if child not in visited:
                    q.append(child)
                    visited.add(child)

    count = 0
    visited = set()
    for idx, val in enumerate(matrix):
        if idx not in visited:
            bfs(graph.graph, visited, idx)
            count += 1

    return count


def solution_without_bfs(matrix):
    if not matrix:
        return 0

    visited = set()
    N = len(matrix)
    M = len(matrix[0])

    def is_safe(row, col):
        return 0 <= row < N and 0 <= col < M

    def bfs(r_source, c_source):
        q = deque()

        q.append((r_source, c_source))
        visited.add((r_source, c_source))

        directions = [
            (0, 1),
            (1, 0),
            (-1, 0),
            (0, -1),
        ]
        while len(q) > 0:
            (r_parent, c_parent) = q.popleft()
            for child_row, child_col in directions:
                child_col += c_parent
                child_row += r_parent
                if (
                    is_safe(child_row, child_col)
                    and matrix[child_row][child_col] == 1
                    and (child_row, child_col) not in visited
                ):
                    q.append((child_row, child_col))
                    visited.add((child_row, child_col))

    count = 0
    for row_idx, row in enumerate(matrix):
        for col_idx, col in enumerate(row):
            if col == 1 and (row_idx, col_idx) not in visited:
                bfs(row_idx, col_idx)
                count += 1

    return count


result_1 = solution(matrix)
print(result_1)
result_2 = solution([])
print(result_2)
result_3 = solution_without_bfs(matrix)
print(result_3)

"""
Given a Maze 2D-matrix, find shortest paths length for given destination

matrix = [
    [1, 1, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 1, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 1, 1, 1, 1]
]

start_point = (0, 0)
end_point = (4, 4)

OUTPUT:
Shortest distance from (0, 0) to (4, 4): 8
"""
from queue import Queue

matrix = [
    [1, 1, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 1, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 1, 1, 1, 1],
]
R = len(matrix)
C = len(matrix[0])

start_point = (0, 0)
end_point = (4, 4)

directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]


def is_safe(matrix, visited, curr_row, curr_col):
    if (
        curr_row < 0
        or curr_col < 0
        or curr_row > R - 1
        or curr_col > C - 1
        or matrix[curr_row][curr_col] != 1
        or (curr_row, curr_col) in visited
    ):
        return False
    return True


def lee_algorithm(matrix, start_row, start_col, end_point):
    queue = Queue()
    queue.put([start_row, start_col, 0])
    visited = set()

    while not queue.empty():
        curr_row, curr_col, distance = queue.get()

        if (curr_row, curr_col) == end_point:
            return distance

        for dir in directions:
            new_row = curr_row + dir[0]
            new_col = curr_col + dir[1]
            if is_safe(matrix, visited, new_row, new_col):
                queue.put([new_row, new_col, distance + 1])
                visited.add((new_row, new_col))

    return -1


distance = lee_algorithm(matrix, start_point[0], start_point[1], end_point)
print(distance)
print("TC - O(MxN), AS - O(MxN)")

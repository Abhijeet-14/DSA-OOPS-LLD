"""
Original Matrix:
[1, 1, 1, 1, 0]
[1, 1, 0, 1, 0]
[1, 1, 0, 0, 1]
[0, 0, 1, 1, 1]

Matrix after Flood-Fill:
[2, 2, 2, 2, 0]
[2, 2, 0, 2, 0]
[2, 2, 0, 0, 1]
[0, 0, 1, 1, 1]

- Flood-Fill is technique for Visiting & Changing to Connected Node
- We will use DFS over matrix
"""


matrix = [
    [1, 1, 1, 1, 0],
    [1, 1, 0, 1, 0],
    [1, 1, 0, 0, 1],
    [0, 0, 1, 1, 1],
]

R = len(matrix)
C = len(matrix[0])
print(R, C)


def flood_fill(matrix, start_row, start_col, new_color, original_color):
    if (
        start_row < 0
        or start_col < 0
        or start_row > R - 1
        or start_col > C - 1
        or matrix[start_row][start_col] != original_color
        or matrix[start_row][start_col] == new_color
    ):
        return

    matrix[start_row][start_col] = new_color

    flood_fill(matrix, start_row + 1, start_col, new_color, original_color)
    flood_fill(matrix, start_row - 1, start_col, new_color, original_color)
    flood_fill(matrix, start_row, start_col + 1, new_color, original_color)
    flood_fill(matrix, start_row, start_col - 1, new_color, original_color)


start_row = 0
start_col = 0
new_color = 2
original_color = matrix[start_row][start_col]

print(matrix)
flood_fill(matrix, start_row, start_col, new_color, original_color)
print(matrix)
print("TC - O(MxN), AS - O(MxN)")

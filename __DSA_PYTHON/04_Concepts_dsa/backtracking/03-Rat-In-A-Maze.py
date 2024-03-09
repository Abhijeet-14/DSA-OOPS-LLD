def print_board(board):
    for row in board:
        for col in row:
            print(col, end=", ")
        print()
    print()


def is_safe(row, col, maze, sol):
    N = len(maze)
    return 0 <= row < N and 0 <= col < N and maze[row][col] == 1


def solve_rat_in_maze(row, col, maze, sol):

    possible_moves = [(0, 1), (1, 0)]
    N = len(maze)

    if row == N - 1 and col == N - 1:
        sol[row][col] = 1
        return True

    for r, c in possible_moves:
        new_row = row + r
        new_col = col + c
        if is_safe(new_row, new_col, maze, sol):
            sol[new_row][new_col] = 1
            if solve_rat_in_maze(new_row, new_col, maze, sol):
                return True

            sol[new_row][new_col] = 0
    return False


maze = [[1, 0, 0, 0], [1, 1, 0, 1], [0, 1, 0, 0], [1, 1, 1, 1]]

n = len(maze)

sol = [[0] * n for _ in range(n)]

sol[0][0] = 1
solve_rat_in_maze(0, 0, maze, sol)
print_board(sol)

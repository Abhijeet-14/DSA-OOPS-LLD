def print_board(board):
    for row in board:
        for col in row:
            print(col, end=", ")
        print()
    print()


def is_safe(board, row, col):
    print_board(board)
    N = len(board)

    if 0 <= row < N and 0 <= col < N and board[row][col] == -1:
        return True
    return False


def knight_tour(board, row, col, move_no):
    possible_moves = [
        (2, 1),
        (1, 2),
        (-1, 2),
        (-2, 1),
        (-2, -1),
        (-1, -2),
        (1, -2),
        (2, -1),
    ]

    N = len(board)

    if move_no >= N * N - 1:
        return True

    for r, c in possible_moves:
        new_row = r + row
        new_col = c + col

        if is_safe(board, new_row, new_col):
            board[new_row][new_col] = move_no

            if knight_tour(board, new_row, new_col, move_no + 1):
                return True

            # backtrack
            board[new_row][new_col] = -1

    return False


n = 4

board = [[-1 for _ in range(n)] for _ in range(n)]


print_board(board)

# first move
board[0][0] = 0
knight_tour(board, 0, 0, 1)

print_board(board)

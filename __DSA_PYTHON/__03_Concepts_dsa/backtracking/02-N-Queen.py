#### N-queens ####
# The N-Queens problem involves placing N queens on an N×N chessboard such that no two queens threaten each other. In other words, no two queens share the same row, column, or diagonal.


def print_board(board):
    for row in board:
        for col in row:
            print(col, end=", ")
        print()
    print()


def is_safe(board, col, row):
    N = len(board)

    if col < 0 or col >= N or row < 0 or row >= N or board[row][col] == "Q":
        return False

    # back-horizontal
    for i in range(col):
        if board[row][i] == "Q":
            return False

    # back-diagonal up
    new_col = col - 1
    new_row = row - 1
    while new_col >= 0 and new_row >= 0:
        if board[new_row][new_col] == "Q":
            return False
        new_row -= 1
        new_col -= 1

    # back-diagonal down
    new_col = col - 1
    new_row = row + 1
    while new_col >= 0 and new_row < N:
        # back-diagonal up
        if board[new_row][new_col] == "Q":
            return False
        new_row += 1
        new_col -= 1

    return True


def place_queens(board, col):
    N = len(board)

    # Edge Case: Important
    if col >= N:
        return True

    for row in range(N):
        if is_safe(board, col, row):
            board[row][col] = "Q"
            if place_queens(board, col + 1):
                return True

            # backtrack
            board[row][col] = -1

    return False


print("Enter value of N: ")
n = int(input())

# Impt: else row points to same column
board = [[-1] * n for _ in range(n)]
place_queens(board, 0)

print_board(board)

########################
# N-Queen - is_safe() in O(1)
########################


def print_board(board):
    for row in board:
        for col in row:
            print(col, end=", ")
        print()
    print()


def is_safe_O1_time(
    row,
    col,
    board,
    occupied_rows: set,
    occupied_left_upper_diagonal: set,
    occupied_left_lower_diagonal: set,
):
    # Diff (row-col) in upper diagonal is CONSTANT
    # (0,0)=> 0-0 = 0
    # (1,1)=> 1-1 = 0
    # (2,2)=> 2-2 = 0
    # (3,3)=> 3-3 = 0
    # So, (row - col) in occupied_left_upper_diagonal:

    # Sum (row+col) in Lower diagonal is CONSTANT
    # (0,3)=> 0+3 = 3
    # (1,2)=> 1+2 = 3
    # (2,1)=> 2+1 = 3
    # (3,0)=> 3+0 = 3
    # So, (row + col) in occupied_left_lower_diagonal:
    if (
        row in occupied_rows
        or (row - col) in occupied_left_upper_diagonal
        or (row + col) in occupied_left_lower_diagonal
    ):
        return False

    return True


def place_queen_optimize(
    col,
    board,
    occupied_rows: set,
    occupied_left_upper_diagonal: set,
    occupied_left_lower_diagonal: set,
):
    """Optimized: TC-O(N!), is_safe() TC-O(1)"""
    N = len(board)
    if col >= N:
        return True

    for row in range(N):  # 4*3*2*1
        if is_safe_O1_time(
            row,
            col,
            board,
            occupied_rows,
            occupied_left_upper_diagonal,
            occupied_left_lower_diagonal,
        ):

            board[row][col] = " Q"
            occupied_rows.add(row)
            occupied_left_upper_diagonal.add((row - col))
            occupied_left_lower_diagonal.add((row + col))
            if place_queen_optimize(
                col + 1,
                board,
                occupied_rows,
                occupied_left_upper_diagonal,
                occupied_left_lower_diagonal,
            ):
                return True

            # backtrack
            board[row][col] = -1
            occupied_rows.remove(row)
            occupied_left_upper_diagonal.remove((row - col))
            occupied_left_lower_diagonal.remove((row + col))

    return False


N = 4
board2 = [[-1] * N for _ in range(N)]
place_queen_optimize(0, board2, set(), set(), set())
print("Optimized: TC-O(N!), is_safe() TC-O(1)")
print_board(board2)


print("See row-col & row+col is Constant: (row-col, row+col)")
board3 = [[(row - col, row + col) for col in range(N)] for row in range(N)]
print_board(board3)

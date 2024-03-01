"""
Major Priority of LLD -- is it SCALABLE? rest all not imp

But, How to approach LLD question?
-> Design BookMyShow

1. Clarify & ANALYZE the requirments
    -> find the flow -
        ex -> user -> come to portal -> movies by city -> ...
        -> whatever in the mind of Interviewer - by this try take it out 
        -> interviewer is your CLIENT.
        -> Ask him -> What now? -

    -> Define the Scope
        -> application can have 1000 features, but we don't want all
        -> it mean, define 'features' you are going to support. -> search(), book(). notification()
        -> after this, ask -> is it okay in requirement extraction?

2. List Down Objects
    -> go by flow, and write Objects.
        -> user, portal, movie, theater, seats, screen
    -> clarify with Interviewer -> is it okay? I have covered everything?

3. define Relationship bw Objects
    -> 'is_a' & 'has_a'
    -> define relationship bw objects, created at step 2.
    -> this is 'BruteForce'
    -> Confirm with Interviewer? anything left?

4. Optimize 3 by SOLID pri + Design Pattern
    -> check for each object -> Scalble?
    -> ask interviewer? - is theater scaleable?
    -> Theather -> NonAcTheater & Theater
"""

""" Tic Tac Toe:
- 3x3 matrix
- player 1(x) & 2(O)
- winner - if match in either ROW, COLUMN or diagronl
"""

"""4 Step of LLD
1. Requiremet:
    - 3x3 matrix
    - player 1 & 2
    - winner - if R, C or D

2. List Objects
    - game
    - board -> can  be N
    - player -> can be > 2
    - piece (X, O) -> can be more

3. Relation
    - enum PieceType
    - class Piece 
    - Piece 'Has_A' PieceType
    - Piece X 'Is_A' Piece
    - Piece O 'Is_A' Piece

    - class Board -> N-Size Board
    - Board 'Has_A' Piece

    - class Player
    - Player 'Has_A' piece

    - class game
    - game 'Has_A' *Player
    - game 'Has_A' Board

4. Solid & DP
"""

from enum import Enum, auto
from collections import deque


class PieceType(Enum):
    X = auto()
    O = auto()
    # Y = auto() # can add new type


class Piece:
    def __init__(self, piece_type: PieceType):
        self.piece_type = piece_type


class PieceX(Piece):
    def __init__(self):
        super().__init__(PieceType.X)


class PieceO(Piece):
    def __init__(self):
        super().__init__(PieceType.O)


class Player:
    def __init__(self, name: str, piece: Piece):
        self.name = name
        self.playing_piece = piece


class Board:
    def __init__(self, size: int):
        self.size = size
        self.board: list[list[PieceType]] = [[-1] * size for _ in range(size)]

    def add_piece(self, row, col, playing_piece: Piece):
        if not (self.size > row >= 0 or self.size > col >= 0):
            return False

        if self.board[row][col] != -1:
            return False

        self.board[row][col] = playing_piece.piece_type.name
        return True

    def find_free_space(self):
        for row_vals in self.board:
            for col_val in row_vals:
                if col_val == -1:
                    return True
        return False

    def print_board(self):
        for row_vals in self.board:
            for col_val in row_vals:
                print(col_val, end=" ")
            print()


class Game:

    def __init__(self):
        self.initialize_game()

    def initialize_game(self):
        self.players = deque()
        player_1 = Player("Player 1", PieceX())
        player_2 = Player("Player 2", PieceO())

        self.players.append(player_1)
        self.players.append(player_2)

        self.board = Board(3)

    def start_game(self):
        """Once start, didn't close unless someone wins"""
        is_winner = False
        while is_winner == False:
            current_player: Player = self.players.popleft()

            # logic
            self.board.print_board()
            free_spaces = self.board.find_free_space()
            if not free_spaces:
                print("Game is Tie")
                break

            print(f"Player {current_player.name}, its your turn: ")
            current_player_input = list(map(int, input().split(" ")))

            is_piece_added_to_board: bool = self.board.add_piece(
                current_player_input[0],
                current_player_input[1],
                current_player.playing_piece,
            )

            if not is_piece_added_to_board:
                print("Incorrect position chosen, try again!")
                self.players.appendleft(current_player)
                continue

            self.players.append(current_player)

            is_winner = self.is_there_any_winner(
                current_player_input[0],
                current_player_input[1],
                current_player.playing_piece.piece_type,
            )
            if is_winner:
                print(f"{current_player.name} has won!")

    def is_there_any_winner(self, row, col, piece_type: PieceType):

        piece_type = piece_type.name

        row_match = True
        col_match = True
        diagonal_match = True
        anti_diagonal_match = True

        # check horizontal
        for y in range(self.board.size):
            curr_posi = self.board.board[row][y]
            if curr_posi == -1 or curr_posi != piece_type:
                row_match = False

        # check vertical
        for x in range(self.board.size):
            curr_posi = self.board.board[x][col]
            if curr_posi == -1 or curr_posi != piece_type:
                col_match = False

        # check diagonal
        i = 0
        j = 0
        while i < self.board.size:
            curr_posi = self.board.board[i][j]
            if curr_posi == -1 or curr_posi != piece_type:
                diagonal_match = False
            i += 1
            j += 1

        # check anit-diagonal
        i = self.board.size - 1
        j = 0
        while i >= 0:
            curr_posi = self.board.board[i][j]

            if curr_posi == -1 or curr_posi != piece_type:

                anti_diagonal_match = False
            i -= 1
            j += 1

        return row_match or col_match or diagonal_match or anti_diagonal_match


if __name__ == "__main__":
    game = Game()
    game.initialize_game()
    game.start_game()

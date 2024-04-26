from models import Board, Dice, Player


class BoardController:
    # player(active, winner_position)
    def __init__(self, N, snakes, ladder) -> None:
        self.players: list[Player] = []
        self.board = Board(N, snakes, ladder)

    def valid_move(self, player: Player):
        dice_val = Dice().give_random_value()
        next_position = player.curr + dice_val
        print(
            f"Move by {player.name}:: dice({dice_val}) :: inital({player.curr})",
            end="->",
        )
        if next_position > self.board.size:
            print(f"Invalid move by player: {player.name}")
            return

        # snake
        if next_position in self.board.snakes:
            print(f"snake at({next_position}) ", end=" -> ")
            next_position = self.board.snakes[next_position]
            print(f"with snake at({next_position}) ", end=" -> ")

        # ladder
        elif next_position in self.board.ladder:
            print(f"ladder at({next_position}) ", end=" -> ")
            next_position = self.board.ladder[next_position]
            print(f"with ladder at({next_position}) ", end=" -> ")

        print(f"final_position({next_position})")
        player.curr = next_position

    def add_player(self, name):
        new_player = Player(name, 0)
        self.players.append(new_player)

    def start_game(self):
        is_winner = False
        total_player = len(self.players)
        if total_player < 2:
            print("Can't playe the game")
            return
        player_turn = 0
        while not is_winner:
            curr_player = self.players[player_turn]
            
            self.valid_move(curr_player)
            if curr_player.curr == self.board.size:
                print(f"Winner: {curr_player.name}")
                is_winner = True
                return
            player_turn = (player_turn + 1) % total_player

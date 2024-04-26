from views import BoardController

if __name__ == "__main__":
    snakes = {}
    snake_lenght = 9
    snakes[62] = 5
    snakes[33] = 6
    snakes[49] = 9
    snakes[88] = 16
    snakes[41] = 20
    snakes[56] = 53
    snakes[98] = 64
    snakes[93] = 73
    snakes[95] = 75

    ladder = {}
    ladder_lenght = 8
    ladder[2] = 37
    ladder[27] = 46
    ladder[10] = 32
    ladder[51] = 68
    ladder[61] = 79
    ladder[65] = 84
    ladder[71] = 91
    ladder[81] = 100

    no_of_player = 2
    player_1 = "Gaurav"
    player_2 = "Sagar"
    board_ctrl = BoardController(100, snakes, ladder)

    board_ctrl.add_player(player_1)
    board_ctrl.add_player(player_2)

    board_ctrl.start_game()

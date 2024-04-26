import random

class Player:
    def __init__(self, name, curr):
        self.name = name
        self.curr = curr

    def new_position(self, position):
        self.curr = position


class Board:
    def __init__(self, size, snakes={}, ladder={}):
        self.ladder: dict[int, int] = ladder # bottompoint - toppoint
        self.snakes: dict[int, int] = snakes # toppoint - bottompoint
        # self.board: list[int] = [0] * size
        self.size = size

class Dice:
    def give_random_value(self):
        return random.randint(1, 6)

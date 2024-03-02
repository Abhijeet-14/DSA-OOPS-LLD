# Creational Desing Pattern

############################
# Builder Design Pattern
############################
"""
- it is a CREATIONAL design pattern -- helps in Creation of an Object.

- PROBLEM:

"""


class CustomizeComputer:
    def __init__(
        self, name=None, mouse=None, screen=None, storage=None, ram=None, keyboard=None
    ):
        self.name = name
        self.mouse = mouse
        self.screen = screen
        self.storage = storage
        self.ram = ram
        self.keyboard = keyboard

    def __str__(self):
        return f"""Computer: {self.name}(
            mouse={self.mouse} 
            screen={self.screen}
            storage={self.storage}
            ram={self.ram}
            keyboard={self.keyboard}
        )
        """


from abc import ABC, abstractmethod


class CustomizeComputerBuilder(ABC, CustomizeComputer):

    def add_name(self, name):
        self.name = name
        return self

    def add_mouse(self, mouse):
        self.mouse = mouse
        return self

    def add_screen(self, screen):
        self.screen = screen
        return self

    def add_storage(self, storage):
        self.storage = storage
        return self

    def add_ram(self, ram):
        self.ram = ram
        return self

    def add_keyboard(self, keyboard):
        self.keyboard = keyboard
        return self

    @abstractmethod
    def set_computer_components(self):
        pass

    def build(self):
        self.computer = CustomizeComputer(
            self.name,
            self.mouse,
            self.keyboard,
            self.ram,
            self.storage,
            self.screen,
        )
        return self.computer


class GameComputer(CustomizeComputerBuilder):

    def set_computer_components(self, name):
        self.add_name(name)
        self.add_mouse("Gaming mouse")
        self.add_keyboard("Gaming keyboard")
        self.add_ram("Gaming ram")
        self.add_storage("Gaming storage")
        self.add_screen("Gaming screen")
        return self


class OfficeComputer(CustomizeComputerBuilder):

    def set_computer_components(self, name):
        self.add_name(name)
        self.add_mouse("Office mouse")
        self.add_keyboard("Office keyboard")
        # self.add_ram("Office ram")
        # self.add_storage("Office storage")
        self.add_screen("Office screen")
        return self


class Director:
    @staticmethod
    def construct(computer_builder: CustomizeComputerBuilder):
        return computer_builder.build()


game_pc = GameComputer()
game_pc.set_computer_components("Gaming PC101")

office_pc = OfficeComputer()
office_pc.set_computer_components("Office PC101")

game = Director.construct(game_pc)
office = Director.construct(office_pc)

print(game)
print(office)

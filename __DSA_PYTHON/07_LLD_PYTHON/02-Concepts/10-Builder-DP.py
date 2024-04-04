# Creational Desing Pattern

############################
# Builder Design Pattern
############################
"""
- it is a CREATIONAL design pattern -- helps in Creation of an Object.

- Builder - create object STEP-By-STEP

- PROBLEM: Suppose you have a class with Required & Optional parameter, total 100 parameters
    1. Huge Constructor's paramter
        - object - with multiple Parameter - Required & Optional
        - say we have 100 parameters
        - so constructor becomes huge

    2. Multiple Object Creation Constructor
        - as we have optional parameter -- so we can create object in multiple permutaion of parameters
        - Student(roll, name) or Student(roll, name, age) or Student(roll, age) ......
        - so mutiple object combination of constructor

- SOLUTION:
    - Builder DP, it is Step-By-Step object creation
    - example: - building a house
        - first build walls -- return Under-Construction House
        - then build Roof -- return Under-Construction House
        - then build Gate -- return Under-Construction House
        - then build Window -- return Under-Construction House
        - ...
        - at each step we are getting 'Under-Construction House'
        - now build this 'Under-Construction House' -> 'Ready House'

        - so we build 'Ready-House' step-by-step adding component of it.

    - so eariler -- we direct build 'Ready House'
    - but here -- we add compo in 'Under-Construction'
    -> and finally called - build -- we build actual 'Ready House'

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
        return f"""Computer: {self.name} (
            mouse={self.mouse} 
            screen={self.screen} 
            storage={self.storage} 
            ram={self.ram} 
            keyboard={self.keyboard}
        )
        """


from abc import ABC, abstractmethod


class CustomizeComputerBuilder(ABC, CustomizeComputer):
    def __init__(self):
        self.computer = CustomizeComputer()

    def add_name(self, name):
        self.computer.name = name
        return self

    def add_mouse(self, mouse):
        self.computer.mouse = mouse
        return self

    def add_screen(self, screen):
        self.computer.screen = screen
        return self

    def add_storage(self, storage):
        self.computer.storage = storage
        return self

    def add_ram(self, ram):
        self.computer.ram = ram
        return self

    def add_keyboard(self, keyboard):
        self.computer.keyboard = keyboard
        return self

    @abstractmethod
    def set_computer_components(self):
        pass

    def build(self):
        if not self.computer.name:
            raise Exception("You need to add compoents first")
        return self.computer


class GameComputer(CustomizeComputerBuilder):

    def set_computer_components(self, name):
        self.add_name(name)
        self.add_mouse("Gaming mouse")
        self.add_keyboard("Gaming keyboard")
        self.add_ram("Gaming ram")
        self.add_storage("Gaming storage")
        self.add_screen("Gaming screen")


class OfficeComputer(CustomizeComputerBuilder):

    def set_computer_components(self, name):
        self.add_name(name)
        self.add_mouse("Office mouse")
        self.add_keyboard("Office keyboard")
        # self.add_ram("Office ram")
        # self.add_storage("Office storage")
        self.add_screen("Office screen")
        # return self


class Director:
    @staticmethod
    def construct(computer_builder: CustomizeComputerBuilder):
        return computer_builder.build()


game_pc = GameComputer()
game_pc.set_computer_components("Gaming PC101")

game = Director.construct(game_pc)
print(game)


office_pc = OfficeComputer()
office_pc.set_computer_components("Office PC101")

office = Director.construct(office_pc)
print(office)


###########
# Diff bw Builder DP & Decorator DP
###########
"""
Decorator & Builder looks same but Builder has some problem

- in Decorator DP -
    - any combination of object can be created
    - WITHOUT creating specific class of that Combination.
    - Chicken(cheese(Spicy(BasePizza())))
    - without cheese - Chicken(Spicy(BasePizza()))

- in Builder DP -
    - any combination of object can be created
    - BUT, need to create specific class of that Combination.
    - for same combo
        - class ChickenCheeseSpicyPizza():
            // add_chicken, add_cheese, add_spicy
    - if want only chicken Spicy
        - class ChickenSpicyPizza():
            // add_chicken,  add_spicy


- So Decorator - give Dynamic combo of objects
"""


# # Product
# class Product:
#     def __init__(self):
#         self.parts = []

#     def add_part(self, part):
#         self.parts.append(part)

#     def show(self):
#         print("Product Parts:", ", ".join(self.parts))


# # Builder Interface
# class Builder:
#     def build_part_a(self):
#         pass

#     def build_part_b(self):
#         pass

#     def get_result(self):
#         pass


# # Concrete Builder
# class ConcreteBuilder(Builder):
#     def __init__(self):
#         self.product = Product()

#     def build_part_a(self):
#         self.product.add_part("Part A")

#     def build_part_b(self):
#         self.product.add_part("Part B")

#     def get_result(self):
#         return self.product


# # Director
# class Director:
#     def __init__(self, builder):
#         self.builder = builder

#     def construct(self):
#         self.builder.build_part_a()
#         self.builder.build_part_b()


# # Client code
# builder = ConcreteBuilder()
# director = Director(builder)
# director.construct()

# product = builder.get_result()
# product.show()

# Structural DP
from abc import ABC, abstractmethod

########################################
# Decorator Design Pattern
########################################
""" Defi
let,
class A -> feature F1

now if we want to add feature over F1 --> then wrap it
class B -> B(class A) -> F1 + F2
class C -> C(B(A)) -> F1 + F2 + F3

class N -> N(...C(B(A))) -> F1 + F2 + F3 + ... + FN

so we can wrap feature over another by Decorating.
"""

""" Use-Case
1. Pizza Shop
    - 1 BasePizza
    - Add cheese - chesse + BasePizza
    - Add Sprice - spicy + chesse + BasePizza
    - Add Chicken - chicken + spicy + cheese + BasePizza
    - ....
    - ...

2. Coffe
    - Coffeee
    - Add sugar - sugar + coffe
    - add create - cream + sugar + coffe
    - add extraMilk - extraMilk + cream + sugar + coffe
    - ....
    - ...

3. Car
    - BaseCar
    - add AC - AC + BaseCar
    - add Sunroof - sunroof + AC + BaseCar
    - add foglight - foglight + sunroof + AC + BaseCar
    - ...
    - ...
"""

""" Why you need Decorator Pattern

- to prevent from class "Expoistion"

- because if don't use decorator -- then only inhertiance will work

- class BaseCar
- class AcCar extend BaseCar

"""
""" Why you need Decorator Pattern

- to prevent from class "Expoistion"

- because if don't use decorator -- then only inhertiance will work

- class BaseCar
- class Ac_Car extend BaseCar
- class Sunroof_Car extend BaseCar
- class Sunroof_AC_Car extend BaseCar
- class Foglight_Car extend BaseCar
- class Foglight_AC_Car extend BaseCar
- class Foglight_AC_Sunroof_Car extend BaseCar
- ......
- ...

- so itni class Ban jayegi ki.. manage hi nahi hoga

- Solution
- interface Base
- interface A 'Is-A' Base
- interface A 'Has-A' Base
"""


class BasePizza(ABC):
    def __init__(self, name):
        self.name = name

    @abstractmethod
    def cost(self):
        pass

    @abstractmethod
    def get_total_name(self):
        pass


class ToppingDecorator(BasePizza):  # "Is-A"
    def __init__(self, base_pizza: BasePizza):  # "Has-A"
        self.base_pizza = base_pizza

    @abstractmethod
    def cost(self):
        pass

    @abstractmethod
    def get_total_name(self):
        pass


class ConcreateBasePizza(BasePizza):
    def __init__(self, name):
        super().__init__(name)

    def cost(self):
        return 60

    def get_total_name(self):
        return self.name


class SpicyPizza(ToppingDecorator):
    def __init__(self, base_pizza):
        super().__init__(base_pizza)

    def cost(self):
        return self.base_pizza.cost() + 20

    def get_total_name(self):
        return "Spicy" + " -> " + self.base_pizza.get_total_name()


class CheesePizza(ToppingDecorator):
    def __init__(self, base_pizza):
        super().__init__(base_pizza)

    def cost(self):
        return self.base_pizza.cost() + 40

    def get_total_name(self):
        return "Cheese" + " -> " + self.base_pizza.get_total_name()


class ChickenPizza(ToppingDecorator):
    def __init__(self, base_pizza):
        super().__init__(base_pizza)

    def cost(self):
        return self.base_pizza.cost() + 60

    def get_total_name(self):
        return "Chicken" + " -> " + self.base_pizza.get_total_name()


if __name__ == "__main__":
    my_pizza = ConcreateBasePizza("Normal")

    # add chicken
    my_pizza_chicken = ChickenPizza(my_pizza)

    # add Cheese
    my_pizza_chesse = CheesePizza(my_pizza_chicken)

    # add Spicy
    my_pizza_spicy = SpicyPizza(my_pizza)

    print(my_pizza_chesse.get_total_name(), my_pizza_chesse.cost())
    print(my_pizza_spicy.get_total_name(), my_pizza_spicy.cost())


# Questions:
# Design PizzaShop
# Design Coffe Machine

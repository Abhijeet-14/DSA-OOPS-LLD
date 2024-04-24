# private variable
__private_variable = 12

# static variable
_static_variable = 23


# private function
def __private_func():
    pass


# static function
def _static_func():
    pass


# Class
class Dog:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def bark(self):
        print(f"Simple Simple")


# Object instance
my_dog = Dog("Buddy", 23)

# attribute
my_dog.name

# method
my_dog.bark()


# Inheritence - where a new class can inherit attributes and methods from an existing class,
class Labrador(Dog):
    def swim(self):
        print(f"{self.name} can swim!")


# Encapsulation - bundling of data (attributes) and methods
class Car:

    def __init__(self, model, fuel_type):
        self.model = model
        # PRIVATE ATTRIBUTE
        self.__fuel_type = fuel_type

    def get_fuel_type(self):
        return self.__fuel_type

    def __my_private_method(self):
        print("This is a private method.")


# Abstraction - Abstraction is like using a toy phone -
#               – you press buttons to talk, but you don't need to know how it works inside.
#       - and Interface same for Python Case
from abc import ABC, abstractmethod


class Shape(ABC):
    @abstractmethod
    def area(self):
        pass


class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return 3.14 * self.radius * self.radius


class Square(Shape):
    def __init__(self, side_length):
        self.side_length = side_length

    def area(self):
        return self.side_length * self.side_length


# Polymorphism - overriding of a function compile/runtime
class Animal:
    def speak(self):
        pass

    def speak(self, message):  # complie time
        pass


class Dog(Animal):
    def speak(self):  # runtime override
        return "Woof!"


# SINGLETON Design Pattern:
# A class can have only 1 instance
class Logger:
    # static variable
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = Logger()
        return cls._instance


# SOLID
"""
S - Single Responvity Principle
    definition - 
        - A class should have one & only one reason to change
        - assume a class is updating DB and send mail... 2 task
"""


class Calculator:
    def add(self, a, b):
        return a + b


"""
O - Open/Closed
    definition - entities(classes, module, function etc) should be open
                for EXTENSION BUT closed for MODIFICATION

                - assume a class CalculateArea{}..
                - it works for Square and Rectangle
                - but for Circle -- need to add new logic in Shape
                - HENCE, violates the Open Closed Principle.
                - solution, in class Circle, modify it--but not in shape
"""


class Shape:
    def CalculateArea(self, L, B):
        return L * B


"""
L - Liskov subsitiution
    definition - a class can be replaced by its sub-class in all
                particular usage scenarios.

                - e.g., 'class Bird' & 'class Sparrow'
                        Bird can Fly
                    - Sparrow extends Bird
                        so, sparrow also fly... bcoz of parent
                    Now,
                    - Ostrich extend Bird
                        and Ostrich Also fly... bcoz of parent.
                        but in Real Ostrich DOES NOT fly.

                - so, 'GrandParent' class Bird & 'Parent' class FlyingBird
                    - so, FlyingBird extends Bird
                    - Sparrow extends FlyingBird
                    - Ostric only extends Bird
"""


class Bird:
    def fly(self):
        pass


class Sparrow(Bird):
    def fly(self):
        return "Sparrow is flying"


"""
I - Interface segregation
    definition - it says, a client should not be FORCED to implement
                    an interface that it DOES NOT required.

                - means breaking interface into small small interfaces.
                    so purpose can be achieved

                - Example
                    'Worker' Interface(work() & sleep())
                        so..
                    if 'Human' implements Worker
                        then Human(work() & sleep())
                    also,
                    if 'Robot' implements Worker
                        then Robot(work() & sleep())
                    But that is NOT possible in REAL.

                - So, sub-interface needs to create.
                - 'Worker' interface &
                - 'Sleeping' interface
                - so,
                    Human -> Worker & Sleeping
                        Human(work() & sleep())

                    Robot -> Worker
                        Robot(work())
"""


class Worker:
    def work(self):
        pass


class Eater:
    def eat(self):
        pass


# D - Dependency Inversion
# definition - high-level modules should not depend on low-level modules -
#           - both should depend on abstraction
# DIDN'T Understand
from abc import ABC, abstractmethod


class Switchable(ABC):
    @abstractmethod
    def turn_on(self):
        pass

    @abstractmethod
    def turn_off(self):
        pass


class LightBulb(Switchable):
    def turn_on(self):
        return "LightBulb is on"

    def turn_off(self):
        return "LightBulb is off"


# Mulitple Inheritence
class ClassA:
    def method_A(self):
        return "Method A from ClassA"


class ClassB:
    def method_B(self):
        return "Method B from ClassB"


class MyClass(ClassA, ClassB):
    def my_method(self):
        return "My method in MyClass"

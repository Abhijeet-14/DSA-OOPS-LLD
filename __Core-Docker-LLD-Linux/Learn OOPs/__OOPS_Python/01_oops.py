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


# Inheritence
class Labrador(Dog):
    def swim(self):
        print(f"{self.name} can swim!")


# Encapsulation
class Car:
    def __init(self, model, fuel_type):
        self.model = model
        # PRIVATE ATTRIBUTE
        self.__fuel_type = fuel_type

    def get_fuel_type(self):
        return self.__fuel_type

    def __my_private_method(self):
        print("This is a private method.")


# Abstraction -- and Interface same for Python Case
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


# Polymorphism
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
# S - Single Responvity Principle
# definition - a class should have one reason to change
class Calculator:
    def add(self, a, b):
        return a + b


# O - Open/Closed
# defi - open for extension but closed for modification
class Circle:
    def area(self, radius):
        return 3.14 * radius * radius


# L - Liskov subsitiution
# definition - object of Parent can replacebale with Object of Child
class Bird:
    def fly(self):
        pass


class Sparrow(Bird):
    def fly(self):
        return "Sparrow is flying"


# I - Interface segregation
# definition - a class should not be forced to implement interfaces it does not use.
class Worker:
    def work(self):
        pass


class Eater:
    def eat(self):
        pass


# D - Dependency Inversion
# definition - high-level modules should not depend on low-level modules -
#           - both should depend on abstraction
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

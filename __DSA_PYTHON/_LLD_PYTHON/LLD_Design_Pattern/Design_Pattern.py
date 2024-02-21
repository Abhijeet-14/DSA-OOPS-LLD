"""
Top 4 Design Pattern which are widely used in Industry.
    1. SingleTon 
            => Purpose: Ensure class has ONLY 1 Instance & provide global access to it
            => UseCase: logging, DB connection, User session
            => Pros: Global point of access, Single Instance, Lazy initialization
            => Cons: Global state, difficulty in testing

    2. Factory Method
            => Purpose: Defines an Interface for creating an object, 
                        but lets subclass change the type of objects 
                        that will be created
            => UseCase: Product Creation
            => Pros: Encapsulation of Object creation, flexibity in object creation
            => Cons: Increased no of class
    3. Observer
            => Purpose: 1-to-Many dependency b/w objects -
                        - so that when 1 object changes state, 
                        - all its dependents are notified & updated automatically.
            => UseCase: Notification
            => Pros: Loose coupling, easy extension, easy maintian
            => Cons: not-interested user also receive notification
    4. Strategy
            => Purpose: family of Algorithm, ecapsulate each one & make them interchangeable
                        - let client choose in run-time.
            => UseCase:Payment Strategy (UPI, Card)
            => Pros: Flexibility, reusable
            => Cons: Increased classes, potential complexity
"""

#### Singleton ####
print("\n==== Singleton Pattern ====")


class Singleton:
    """
    Def: a class has only 1 instance & global access.
    Real World Example: Database, Logging
    """

    # static variable -- class variable
    _instance = None

    # with init --> infinte loop --> cause Singleton() -> create_instance -> Singleton()
    @staticmethod
    def create_instance():
        if not Singleton._instance:
            Singleton._instance = Singleton()
        return Singleton._instance

    def get_instance(self):
        return self._instance


s1 = Singleton().create_instance()
s2 = Singleton().create_instance()

print(s2 is s1)
print(s1)
print(s2)


#### Factory Method Pattern ####
print("\n==== Factory Method Pattern ====")
from abc import ABC, abstractmethod

"""
Def: interface for creating object, but subclass change type of objects 
        that will be created.
Real World Ex: Product creation, diff category(Books, electronics) can have 
                their own Factory methods for creating product.
"""


class Product(ABC):
    """
    Product Interface
    """

    @abstractmethod
    def get_info(self):
        pass


class Laptop(Product):
    """
    Concreate Product
    """

    def get_info(self):
        print("Mouse Created")
        print("Keyboard created")
        return "Laptop created"


class Book(Product):
    """
    Concreate Product
    """

    def get_info(self):
        return "Book Created"


class ProductCreator(ABC):
    """
    Creator Interface
    """

    @abstractmethod
    def create_product(self):
        pass


class LaptopCreator(ProductCreator):
    """
    Concreate creator interface
    """

    def create_product(self):
        return Laptop()


class BookCreator(ProductCreator):
    """
    Concreate creator interface
    """

    def create_product(self):
        return Book()


laptop_creator = LaptopCreator()
book_creator = BookCreator()

laptop = laptop_creator.create_product()
book = book_creator.create_product()

print(laptop.get_info())
print(book.get_info())


#### Observer Pattern ####
print("\n==== Observer Pattern ====")
"""
Def: 1-to-Many dependency b/w objects -
        - when 1 objects changes states, all get notified & updated automatic
Real World Ex: Notification
Pros:
    1. Loose Coupling: Subjects and observers are loosely coupled.
    2. Extensibility: Easily add or remove observers.
Cons:
    1. Unexpected Updates: Observers might receive updates they are not interested in.
    2. Ordering of Notifications: The order in which observers are notified can be challenging to control.
"""
from abc import ABC, abstractmethod


class Observer(ABC):
    @abstractmethod
    def update(self, availability):
        pass


class Subject(ABC):
    _observers = []

    def attach(self, observer: Observer):
        self._observers.append(observer)

    def detach(self, observer):
        # remove first occurance of value
        self._observers.remove(observer)

    def notify(self, availability):
        for observer in self._observers:
            observer.update(availability)


class ProductAvailability(Subject):
    availability = False

    def set_availability(self, availability):
        print("\n--- Product status change ---")
        self.availability = availability
        self.notify(self.availability)

    def get_availability(self):
        return self.availability


class Customer(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, availability):
        product_status = "Available" if availability else "Out Of Stock"
        print(f"Customer {self.name}: Product is {product_status}")


product_availability = ProductAvailability()

customer_1 = Customer("Alice")
customer_2 = Customer("Bob")

product_availability.attach(customer_1)
product_availability.attach(customer_2)

product_availability.set_availability(True)

product_availability.set_availability(False)


#### Strategy Pattern ####
print("\n==== Strategy Pattern ====")
"""
Def: 1-to-Many dependency b/w objects -
        - when 1 objects changes states, all get notified & updated automatic
Real World Ex: Notification
Pros:
    1. Loose Coupling: Subjects and observers are loosely coupled.
    2. Extensibility: Easily add or remove observers.
Cons:
    1. Unexpected Updates: Observers might receive updates they are not interested in.
    2. Ordering of Notifications: The order in which observers are notified can be challenging to control.
"""

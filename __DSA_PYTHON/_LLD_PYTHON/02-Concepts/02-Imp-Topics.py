"""
1. OOPs
2. SOLID
3. Design Pattern
"""

""" SOLID
S - Single Responsibility Principle
O - Open/Closed Principle
L - Liskov Substitution Principle
I - Interface Segmented Principle
D - Dependency Inversion Principle
"""

""" Advantage
- Avoid Duplicate Code
- Easy to Maintain
- Easy to Understand
- Flexible Software
- Reduce Complexity
"""


from abc import ABC, abstractmethod

########################
# S - Single Responsibility Principle
########################
"""
S - A class should have only 1 reason to change
"""


class Marker:

    def __init__(self, name: str, color: str, year: int, price: int):
        self.name = name
        self.color = color
        self.year = year
        self.price = price


class Invoice:
    # Has-a Marker

    def __init__(self, marker: Marker, quantity: int):
        self.marker = marker
        self.quantity = quantity

    def calcute_price(self):
        price = self.marker.price * self.quantity
        return price

    def print_invoice(self):
        # print invoice logic
        pass

    def save_to_db(self):
        # save to db
        pass


""" Reason to Change Invoice
    - if 'calculate_price' -> involes GST now -> 1st reason to change

    - if 'print_invoice' -> new print logic -> 2nd reason to change

    - if 'save_to_db()' -> now save to File -> 3rd reason to change

Total - 3 reason to change --> FAIL to 'S'

How to improve??
"""

""" To improve:
class Invoice --> only calulate price
class InvoicePrinter -> only print invoice
class InvoiceSave -> only save to db
"""


class Invoice:
    def __init__(self, marker: Marker, quantity: int):
        # Has-A Marker
        self.marker = marker
        self.quantity = quantity

    def calculate_price(self):
        # price logic 1
        price = self.marker.price * self.quantity

        # price logic 2 - with GST
        return price


class InvoicePrinter:
    def __init__(self, invoice: Invoice):
        # Has-A invoice
        self.invoice = invoice

    def print_invoice(self):
        # print logic 1
        # print logic 2
        pass


class InvoiceSave:
    def __init__(self, invoice: Invoice):
        self.invoice = invoice

    def save_to_db(self):
        # save logic 1
        # save logic 2
        pass


########################
# O - Open/Closed Principle
########################
""" 
O - open for Extension, but closed for Modification
"""


class InvoiceSave:
    def __init__(self, invoice: Invoice):
        self.invoice = invoice

    def save_to_db(self):
        # save to db
        pass


# Now if requirement come to save_to_file. Then?
class InvoiceSave:
    def __init__(self, invoice: Invoice):
        self.invoice = invoice

    def save_to_db(self):
        # save to db
        pass

    def save_to_file(self):
        # save to file
        pass


""" 
Problem:
    - now class got modified with new function -- instead of extension.
Solution:
    - create interface InvoiceSave
    - create  InvoiceSaveToDb & extend InvoiceSave to it
    - create  InvoiceSaveToFile & extend InvoiceSave to it
"""


# interface/abstraction of InvoiceSave
class InvoiceSave(ABC):
    @abstractmethod
    def save(self):
        pass


# now extend Invoice save
class DatabaseInvoiceSave(InvoiceSave):

    def save(self):
        # SAVE to DB logic
        pass


class FileInvoiceSave(InvoiceSave):

    def save(self):
        # SAVE to File logic
        pass


# now come save to MongoDB --> simple extend InvoiceSave
class MongoDBInvoiceSave(InvoiceSave):

    def save(self):
        # save to MongoDB logic
        pass


########################
# L - Liskov Substitution Principle
########################
"""
L - if class B is subtype of class A
    -> then we should replace object of A with B -
    -> without breaking the Behaviour of Program

mean? 
    - agar function HumanTest(human: class A) hai, 
    - to agar ismein class A ka jagha class B ka object daal do..
    - to HumanTest exactly waise hi chalna chaiye

it should extend the capability of parent not narrow it down.
    class A - move(), walk() 
    class B - move(), walk(), dance()
    but NOT -> class B -  move()
"""


# Interface/Abstraction of Bike
class Bike(ABC):
    @abstractmethod
    def turnOnEngine(self):
        pass

    @abstractmethod
    def accelare(self):
        pass


class MotorCycle(Bike):
    def __init__(self, isEngineOn, speed):
        self.isEngineOn = isEngineOn
        self.speed = speed

    def turnOnEngine(self):
        self.isEngineOn = True

    def accelare(self):
        self.speed = self.speed + 10


class BiCycle(Bike):
    def __init__(self, isEngineOn, speed):
        self.isEngineOn = isEngineOn
        self.speed = speed

    def turnOnEngine(self):
        raise Exception("there is no engine")

    def accelare(self):
        self.speed = self.speed + 10


# function goToTrip(vehicle: Bike)
"""
1.) goToTrip( motorCycle) -> turnOnEngine() -> it worked
2.) goToTrip( biCycle) -> turnOnEngine() -> it breaks
so,
It has reduce the feature of Bike, only accelare is working.

Solution? 
in interface only keep generic feat, and later extend it to feat class
Vehicle( accelerate())
EngineVehicle extend Vechile (hasEngine() & accelerate())
NonEngineVehicle extend Vechile (accelerate())

So, 
Car extend EngineVehicle(hasEngine() && acceleare())
BiCycle extend NonEngineVehicle(acceleare())
"""


########################
# I - Interface Segmented Principle
########################
"""
I - Interface should be such, 
    -> the client should NOT implement UNNECESSARY functions that they do not need. 

so, break interface into small-small, that client not implement non-required.
"""


class RestaurantEmployee(ABC):
    @abstractmethod
    def wash_dishes(self):
        pass

    @abstractmethod
    def cook_food(self):
        pass

    @abstractmethod
    def serve_customers(self):
        pass


class Waiter(RestaurantEmployee):

    def wash_dishes(self):
        return super().wash_dishes()

    def cook_food(self):
        return super().cook_food()

    def serve_customers(self):
        return super().serve_customers()


""" 
Prolem:
    - Waiter, unnecessary implementing cook_food & was_dishes
    - it has only work is -- serve_customers

Solution:
    - WaiterEmployee - server_customer() & take_order()
    - ChefEmployee - cook_food() & decide_menu()
    - helperEmployee - wash_dishes()
"""


class WaiterEmployee(ABC):
    @abstractmethod
    def server_customer(self):
        pass

    @abstractmethod
    def take_order(self):
        pass


class ChefEmployee(ABC):
    @abstractmethod
    def cook_food(self):
        pass

    @abstractmethod
    def decide_menu(self):
        pass


class HelperEmployee(ABC):
    @abstractmethod
    def wash_dishes(self):
        pass


class Waiter(WaiterEmployee):
    def server_customer(self):
        print("Serving customer")

    def take_order(self):
        print("taking orders")

    pass


########################
# D - Dependency Inversion Principle
########################
"""
D - class should Depend ON INTERFACES - not Concreate classes.

Problem: suppose you have:
    - Keyboard interface 
         -> WiredKeyboard concreate class
         -> BluetoothKeyboard concreate class
    - Mouse interface 
         -> WiredMouse concreate class
         -> BluetoothMouse concreate class
"""


class Keyboard(ABC):
    pass


class MouseKeyboard(Keyboard):
    pass


class WiredKeyboard(Keyboard):
    pass


class BlueToothKeyboard(Keyboard):
    pass


class Mouse(ABC):
    pass


class WiredMouse(ABC):
    pass


class BlueToothMouse(ABC):
    pass


class KeyboardMouse(ABC):
    pass


"""
now a Macbook class create
    has a -> WiredKeyboard
    has a -> MouseKeyboard
so now this Macbook, can't be used for BluetoothKeyboard or BluetoothMouse
Bcoz it depends on Conreate class 'Wired....'
"""


class Macbook:
    def __init__(self):
        self.mouse = WiredMouse()
        self.keyboard = WiredKeyboard()


"""
so use interface, instead of Concreate class
"""


class Macbook:
    def __init__(self, keyboard: Keyboard, mouse: Mouse):
        self.mouse = mouse
        self.keyboard = keyboard


################################################

################################################
""" Cheatsheet
SIP - 1 class -> 1 responsibility
O/C - use Interface
LSP - interfac -> class A & class B -> if feat(A) ke jagha feat(B) ho -- then feat should work as expected -- no removing of functionality. break interface to feat class
ISP - break interface into small-small -> class only use required one.
DIP - use interface, not concreate class of interface
"""

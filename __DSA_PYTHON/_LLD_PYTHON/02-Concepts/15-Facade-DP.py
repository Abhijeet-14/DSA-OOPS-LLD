########################################
# Facade Design Pattern
########################################
"""
- Structural DP

- it is very simple -- widely used

- When to use?
    - when we have to HIDE the System Complexity from client -- Facade
    - Ex:
        - Car -> acceleate -- speed increase
        - Car -> break -- speed decrease
        - but how it Increase or Decrease?? - does client know? -- NO

        - so acceleate & break -- is in Facade layer

- Facade -- reduce complexity to client

- Facede is layer bw client & system

- client -> Facade -> System


- Facade "HAS_A" System --> initialize System

- we shouldn't FORCE client to use Facade .. its can interact directly with System.

- can also have -- Multi-Facade
- client -> Facade_1 -> Facade_2 -> System
"""


class EmployeeDao:

    def insert(self):
        print("insert logic")
        pass

    def update(self):
        print("update logic")
        pass

    def delete(self):
        print("delete logic")
        pass

    def get(self):
        print("get logic")
        pass

    # 100 different layer


class EmployeeDaoFacade:

    def __init__(self):
        # 'HAS_A' EmployeeDao
        self.employee_dao: EmployeeDao = EmployeeDao()

    def insert(self):
        self.employee_dao.insert()

    def get(self):
        self.employee_dao.get()


def client():

    employee_dao_facade: EmployeeDaoFacade = EmployeeDaoFacade()
    employee_dao_facade.insert()
    employee_dao_facade.get()

    # employee_dao_facade.update()  ## Client has no access to this

    # client do not know about 100 other feat.. only care about important one need to him.


client()
"""
- Client do not know about 100 other feat.. 
- only care about important one need to him.
"""


""" Exaample 2
- client -> can interact directly -> System
- want to create order
- and system -> creates -> Product() -> Payment() -> Invoice() -> SendNotification()

- so client has implements this on own. [GetProduct, MakePayment, GenerateInvoice, SendNotification]

- Problem: now any method change or added - Delivery() - client needs to changes or add its logic - else break.

- So need to keep it in Facade layer -- client will only say -- create order.
"""

print("\nExample 2: Order")


class Product:
    def get_product(self):
        print("get product")


class Payment:
    def make_payment(self):
        print("make Payment")


class Invoice:
    def generate_invoice(self):
        print("generate Invoice")


class SendNotification:
    def send_notification(self):
        print("Sending Notification")


# Use Facade Layer
class OrderFacade:

    def __init__(self):
        # 'Has_A' Product, Payment, Invoice, SendNotification
        self.product_dao = Product()
        self.payment_dao = Payment()
        self.invoice_dao = Invoice()
        self.send_notification_dao = SendNotification()

    def create_order(self):
        self.product_dao.get_product()
        self.payment_dao.make_payment()
        self.invoice_dao.generate_invoice()
        self.send_notification_dao.send_notification()


def client():
    order = OrderFacade()

    order.create_order()


client()
"""
- So client only needs to know -- create_order -
- if we removed send_notification -- client no need to do any thing -- it will work
"""

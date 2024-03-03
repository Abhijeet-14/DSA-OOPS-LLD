########################################
# Proxy Design Pattern
########################################
"""
- Structural DP

- generally, client ----> Real Object
- but in-between, we add Procy Object
- client --> Proxy Object -- Real Object
- so now,
    - if request, go thro Proxy Object.

- Example:
    - college_laptop ---> Proxy(Blocked Website List) ---> Real Internet
        - if try Blocked website -- it stop & reply back to client -- don't call Real Internet

    - Pre-possing & Post-Possing
        - client ---req--> Proxy ---> Response

        - log it, 
            - in Proxy --> Log Enter
                       --> Log Exit

        - Publish Event on Exit


- create Interface -- Employee_Interface
- create concrete class -- ConcreateEmployee 'IS_A' Employee_Interface
- create proxy concreate -- ConcreateEmployeeProxy 'IS_A Employee Interface
- now,
    - ConcreateEmployeeProxy 'HAS_A" ConcreateEmployee

# Requirement -- client want to create Employee, check its role & then allow.
        - to check role -- use proxy
"""
from abc import ABC, abstractmethod


class EmployeeInterface(ABC):
    @abstractmethod
    def create(self, client):
        pass

    @abstractmethod
    def delete(self, client):
        pass

    @abstractmethod
    def get(self, client):
        pass


class EmployeeDAO(EmployeeInterface):
    def create(self, client):
        print("New Employee Created")

    def delete(self, client):
        print("Successfully Deleted one Employee")

    def get(self, client):
        print("get Employee")


class EmployeeDAOProxy(EmployeeInterface):
    def __init__(self, employee_dao: EmployeeDAO):
        self.employee_dao = employee_dao

    def create(self, client):
        if client == "USER":
            self.employee_dao.create(client)
            return
        print("Access Denied")

    def delete(self, client):
        if client == "ADMIN":
            self.employee_dao.delete(client)
            return
        print("Access Denied")

    def get(self, client):
        if client in ["GUEST", "USER", "ADMIN"]:
            self.employee_dao.get(client)
            return
        print("Access Denied")


# Client want to Interact with EmployeeDao

employee_dao: EmployeeInterface = EmployeeDAOProxy(EmployeeDAO())
employee_dao.create("USER")
employee_dao.delete("GUEST")
employee_dao.get("ADMIN")

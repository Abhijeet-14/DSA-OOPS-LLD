# Structural DP

# Walmart Interview Question
# In Amazon, "notify me" when certain subsribed product is available or out of stock.

from abc import ABC, abstractmethod

########################################
# Observer Design Pattern
########################################
"""
2 things are there -- Subject && Observer
    - Observer is OBSERVING Subject
    - whenever "State Change" happen in Subject.
    - Subject's UPDATES all the observers

So, 
Subject will have list of Observer who are observing it.

And Subject has 3 feat:
- add observer
- remove
- notify

And, Observer has 1 feat:
- update [by SMS | Email | Phone]
"""

# Solution
"""
1. Create Subject Interface -- Has-A multi Observer
2. Create Observer Interface 
3. create Concreate Subject cls & Concreate Observer cls
"""


class Observer(ABC):
    def update(self, subject):
        pass


class Subject(ABC):
    # List of Observer -- create it in Concreate
    @abstractmethod
    def add(self, observer: Observer):
        pass

    @abstractmethod
    def remove(self, observer: Observer):
        pass

    @abstractmethod
    def notify(self):
        pass

    @abstractmethod
    def set_data(self, data):
        """Implement on what condition notify observer"""
        pass

    @abstractmethod
    def get_data(self):
        """get instance of subject"""
        pass


class ConcreateSubject(Subject):
    def __init__(self, name):
        self.observers: list[Observer] = []
        self.data = 0
        self.name = name

    def add(self, observer: Observer):
        self.observers.append(observer)

    def remove(self, observer: Observer):
        self.observers.remove(observer)

    def notify(self):
        for observer in self.observers:
            observer.update(self)

    def set_data(self, data):
        if self.data %2 == 0:
            self.notify()

        self.data += data

    def get_data(self):
        return self.data


class ConcreateMobileObserver(Observer):

    def __init__(self, subject: Subject, phone: int):
        self.subject = subject
        self.phone = phone

    def update(self, subject):
        stock = subject.get_data()
        sms_message = (
            f"Message sent to {self.phone}, {subject.name} is available, {stock}"
        )
        self.send_msg(sms_message)

    def send_msg(self, message):
        print(message)


class ConcreateEmailObserver(Observer):

    def __init__(self, subject: Subject, email: str):
        self.subject = subject
        self.email = email

    def update(self, subject):
        stock = subject.get_data()
        email_message = f"Email sent to {self.email}, {subject.name} is available"
        self.send_email(email_message)

    def send_email(self, message):
        print(message)


if __name__ == "__main__":
    iphoneSubject: Subject = ConcreateSubject("Iphone X")

    observer1: Observer = ConcreateEmailObserver(iphoneSubject, "test1@t.com")
    observer2: Observer = ConcreateEmailObserver(iphoneSubject, "test2@t.com")
    observer3: Observer = ConcreateMobileObserver(iphoneSubject, 7209428891)

    iphoneSubject.add(observer1)
    iphoneSubject.add(observer2)
    iphoneSubject.add(observer3)

    iphoneSubject.set_data(10)  # sent only first time
    iphoneSubject.set_data(11)

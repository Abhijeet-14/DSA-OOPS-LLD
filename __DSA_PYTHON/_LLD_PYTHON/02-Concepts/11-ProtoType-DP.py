# Creational Desing Pattern

############################
# Prototype Design Pattern
############################
"""
- it is a CREATIONAL design pattern -- helps in Creation of an Object.

- Prototype - create object by COPYING/Clone existing object

- Most Simplest one

- Problem:
    - suppose you have SportsCar - very complex & expensive
    - now you want to clone this -
        - and make SuperCar -
        - with some minior modifation or adding new feature
    - but so cloning will become very EXPENSIVE.

- Solution:
    - Prototype DP
"""


###### Simple Approach ######
class Student:

    def __init__(self, age=None, roll=None, name=None):
        self.name = name
        self.age = age
        self.__roll = roll  # private
        # can have 100


# now create original object
original_object = Student(12, 23, "Original Student")

# now clone original_object. -- But HOW?
clone_object = Student()
clone_object.age = original_object.age
clone_object.name = original_object.name
# clone_object.__roll = original_object.__roll  # __roll - private -> exception

"""
now problem,
  - as roll is private -- so how we clone this???
  - client -- need to know -- all variables of original object - Very Difficult
  - so if 100 varible -- client will go mad

Solution:
    - Prototype DP
    - it say -
        - clone is not responsibility of client
        - clone is responsibility of class itself.
    - so all cloining logic will be inside Class

- create interface - Prototype
- interface method - clone()
- each class - 'Is_A' - Prototype
- class has to implement 'clone()

"""

from abc import ABC, abstractmethod


###### Prototype DP - Approach ######
class Prototype(ABC):
    @abstractmethod
    def clone(self):
        pass


class StudentProto(Prototype):
    def __init__(self, name, roll, age) -> None:
        self.name = name
        self.roll = roll
        self.age = age

    def clone(self) -> Prototype:

        return StudentProto(self.name, self.roll, self.age)


# client
original_object_proto = StudentProto("Student", 29, 12)

clone_object_proto: StudentProto = original_object_proto.clone()

print(original_object_proto)
print(clone_object_proto)
print(original_object_proto == clone_object_proto)

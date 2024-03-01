from abc import ABC, abstractmethod

########################################
# Factory & Abstract Factory Design Pattern
########################################
""" 
- Jaha bhi object create karna hai -- but on basis of some condition -> Factory DP

-> condition 1 -> Rectange
-> condition 2 -> circle .. etc

-> class A -> if(condi 1) => Rectange()
-> class B -> if(condi 2) => Rectange()
-> class C -> if(condi 3) => Rectange()
-> class D -> if(condi 4) => Rectange()
-> ...

so there is duplicate creation of Rectange, to avoid this use Factory pattern.
"""

""" Solution
 - create interface Shape
 - Circle 'Is-A' Shape
 - Square 'Is-A' Shape
 - Rectange 'Is-A' Shape

 Now, create Factory
 - class ShapeFactory 'Has-A' Shape
 - if condi 1 - Rectange()
 - if condi 2 - Cicle()
 - if condi 3 - Square()
"""


class Shape(ABC):
    @abstractmethod
    def draw(self):
        pass


class Circle(Shape):
    def draw(self):
        print("Shape is Circle")


class Square(Shape):
    def draw(self):
        print("Shape is Square")


class Rectangle(Shape):
    def draw(self):
        print("Shape is Rectangle")


# Now create Factory  -- ShapeFactory
# this Factory will create Shape Object.
class ShapeFactory:
    def get_shape(self, _type: str):
        _type = _type.upper()
        if _type == "RECTANGLE":
            return Rectangle()
        elif _type == "CIRCLE":
            return Circle()
        elif _type == "SQUARE":
            return Square()
        else:
            print("Invalid input _type")


if __name__ == "__main__":
    factory = ShapeFactory()

    factory.get_shape("Hj")


########################################
# Abstract Factory Design Pattern
########################################
""" 
- it is Abstract of Factory.. Factory ka Factory
Example:
- interface Vehicle (average())
- class LuxaryV1 - 'IS_A' - Vehicle
- class NormalV1 - 'IS_A' - Vehicle
- class LuxaryV2 - 'IS_A' - Vehicle
- class NormalV2 - 'IS_A' - Vehicle

Now, we can group Vehicle By its type & creates its Factory.
- but this Factory comes from Vehicle Factory interface
So
- interface VehicleFactory
- class LuxaryFactory "HAS_A" LuxaryV1 or LuxaryV2
- class NormalFactory "HAS_A" NormalV1 or NormalV2

- class VehicleFactoryKaFactory - 'Has_A' - VehicleFactory
"""


class Vehicle(ABC):
    pass


class LuxV1(Vehicle):
    pass


class NormalV1(Vehicle):
    pass


class LuxV2(Vehicle):
    pass


class NormalV2(Vehicle):
    pass


# Now A Factory to create condition based Luxary or Noamral
class VehicleFactory(ABC):
    pass


class LuxaryFactory(VehicleFactory):
    pass


class OrdinaryFactory(VehicleFactory):
    pass


# Now a Factory -- to chose bw LuxaryFactory & NormalFactory.
# So, "Factory ka Factory"
class VehicleFactory_Ka_Factory:
    # "HAS_A" VechicleFactory

    def get_shape(self, is_condition):
        if is_condition:
            return OrdinaryFactory()
        else:
            return LuxaryFactory()

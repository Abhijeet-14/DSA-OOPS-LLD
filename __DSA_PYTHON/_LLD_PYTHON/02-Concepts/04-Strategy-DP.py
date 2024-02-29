from abc import ABC, abstractmethod

#################################
# Strategy Design Pattern
#################################
# Is-A => Inheritance of class X
# Has-A => contain class X as variable

""" Problem:
When only pure Inheritence causes issue. How it causes issue in Scaling. 

Whenever, child is inheriting parent -- doing duplicate code by child -- use strategy pattern.
In Simple,
    - wherever you need choose strategy for feat.
"""


class Vehicle:

    def drive(self):
        print("Vehicle Drive")


class OffRoadVehicle1(Vehicle):

    def drive(self):
        print("Special Drive feature - off road")  # override


class PassengerVehicle1(Vehicle):

    def drive(self):
        super().drive()


class SportsVehicle1(Vehicle):

    def drive(self):
        print("Special Drive feature - Sports")  # override


"""
So, we see that, multiple child of Vehicle need to override drive feat - if they want to enhance it. 
Duplicate Code

Solution:
use interface --> and create each's drive strategy

and 'Vehicle' Has-A - this Interface
"""


# interface of Strategy
class DriveStrategy(ABC):
    @abstractmethod
    def drive(self):
        pass


# differnet Strategy
class SportsDriveStrategy(DriveStrategy):
    def drive(self):
        print("Sports Drive Strategy")


class PassengeDriveStrategy(DriveStrategy):
    def drive(self):
        print("Normal Drive Strategy")


class OffRoadDriveStrategy(DriveStrategy):
    def drive(self):
        print("Off Road Drive Strategy")


#### create Vehicles - Vehicles Has-A DriveStrategy
class Vehicle:
    def __init__(self, driveStrategy: DriveStrategy):
        self.driveStrategy = driveStrategy

    def test_drive(self):
        self.driveStrategy.drive()


#### create different Vehicle
class OffRoadVehicle(Vehicle):

    def __init__(self):
        super().__init__(OffRoadDriveStrategy())


class PassengerVehicle(Vehicle):

    def __init__(self):
        super().__init__(PassengeDriveStrategy())


class SportsVehicle(Vehicle):

    def __init__(self):
        super().__init__(SportsDriveStrategy())


if __name__ == "__main__":
    vehicle: Vehicle = SportsVehicle()
    # vehicle: Vehicle = PassengerVehicle()
    # vehicle: Vehicle = OffRoadVehicle()
    vehicle.test_drive()

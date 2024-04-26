from abc import ABC, abstractmethod

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
    class B - move(), walk(), dance() -- OK
    but NOT -> class B -  move() -- NOT OK
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
Vehicle( no_of_wheels())
EngineVehicle extend Vechile (hasEngine() & no_of_wheels())
NonEngineVehicle extend Vechile (no_of_wheels())

So, 
Car extend EngineVehicle(hasEngine() && no_of_wheels())
BiCycle extend NonEngineVehicle(no_of_wheels())
"""


### Solution
class Bike(ABC):
    @abstractmethod
    def no_of_wheels(self):
        pass


class NonEngineBike(Bike):
    def no_of_wheels(self):
        return 2


class EngineBike(Bike):
    def no_of_wheels(self):
        return 4

    def has_engine(self):
        pass


# Now
class MotorCycle(EngineBike):
    pass


class Scooty(EngineBike):
    pass


class BiCycle(NonEngineBike):
    pass


if __name__ == "__main__":
    bikeList: list[Bike] = []

    bikeList.append(MotorCycle())
    bikeList.append(Scooty())
    bikeList.append(BiCycle())

    for bike in bikeList:
        print(bike.no_of_wheels())  # this works
        print(
            bike.has_engine()
        )  # get runtime error on BiCycle, in java it give compile time

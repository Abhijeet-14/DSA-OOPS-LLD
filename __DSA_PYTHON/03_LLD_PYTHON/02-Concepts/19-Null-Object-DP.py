###############################
# Null Object Design Pattern
###############################
"""
- LLD of handling Null

- Problem:
    - in function(vehicle: MotoVehicle) { vehicle.do_action() }
    - now,
        - vehicle can be -- MotoVehicle -- or -- Null
        - so,
        - when passed - motorvehicle -> do_action() - worked
        - when passed - None --> Error
"""


class Vehicle:
    def get_seating_capacity(self):
        return 5

    def get_fuel_capacity(self):
        return 44


def print_vehicle_details(vehicle: Vehicle):
    print("Seat Capactity: ", vehicle.get_seating_capacity())
    print("Fuel-Tank Capactity: ", vehicle.get_fuel_capacity())


# print_vehicle_details(Vehicle())  # works

# but break for null
# print_vehicle_details(None)

""" Solution:
def function(vehicle: Vehicle):
    if vehicle != None:
        //// work....

        
- but if you have 1000 of function
- every where you need to do this duplicate code

- Solution - Null Object Desing Pattern
    1. null object REPLACE Null return type
    2. No need to put CHECK ->if checking Null
    3. Null objects reflects 'do nothing' or 'Default Behavior'

    - create interface Vehicle
    - concrete class CarVehicle
    - concrete class "NullVehicle"

    - class VehicleFactory -
        -> create CarVehicle
        -> else NullVehicle
"""
from abc import ABC, abstractmethod


class Vehcile2(ABC):
    @abstractmethod
    def get_seating_capacity(self):
        pass

    @abstractmethod
    def get_fuel_capacity(self):
        pass


class NullObjectVehicle(Vehcile2):
    def get_fuel_capacity(self):
        return 0

    def get_seating_capacity(self):
        return 0


class CarVehicle(Vehcile2):
    def get_fuel_capacity(self):
        return 33

    def get_seating_capacity(self):
        return 5


class VehicleFactory:

    def get_vehicle_object(self, type_of_vehicle):
        if type_of_vehicle == "CAR":
            return CarVehicle()
        return NullObjectVehicle()


def client():
    vehicle: Vehcile2 = VehicleFactory().get_vehicle_object("CAR")

    print("Seat Capactity: ", vehicle.get_seating_capacity())
    print("Fuel-Tank Capactity: ", vehicle.get_fuel_capacity())

    print("\nNull Object")
    nullVehicle: Vehicle = VehicleFactory().get_vehicle_object("BIKE")
    print("Seat Capactity: ", nullVehicle.get_seating_capacity())
    print("Fuel-Tank Capactity: ", nullVehicle.get_fuel_capacity())


client()

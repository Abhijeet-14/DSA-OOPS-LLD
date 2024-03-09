###############################
# State Design Pattern
###############################

"""
- 

- Design LLD of Vending Machine - V.V.I
    -    Cold Drink Vending Machine   
        --------------------------------  
        |  Coke    |  Pepsi   |  7UP   |  
        |----------|----------|--------|  
        |   Sprite |  Fanta   | Water  |  
        |----------|----------|--------|  
        |   Juice  |  Ice Tea |        |  
        |------------------------------|  
        |    Insert Money and Select   |  
        |    the Drink of Your Choice  |  
        |------------------------------|  

    - clarify requirement
        - it has Item(name, code, price, is_available)
        - it has Item-Shelf
        - insert cash button
        - insert cash (Coin)
        - select product button - 102
        - if inserted cash > product price -> return change
        - if inserted cash < product price -> raise Exception("Insuffient fund")
        - delivery product -> Product Dischange
        - cancel button -> return change -> Idle

    - Happy FLow:
        - turn on VM
        - client descide Want Fanta -
        - insert cash button -
        - insert put coins
        - select product
        - check price -> return Change || raise Exception
        - submit_button
        - deliver product
        - cancel request.

        - STATE WISE
            - turn_on --> Idle State

            - insert cash button() --> Has_Money_State
            - insert cash coint --> Has_Money_state
                - cancel coin --> refund --> Idle state

            - select product --> Selection_state
                - cancel product --> refund --> Idle state

            - submit product --> check Price vs Product --> calculate change -> Delivery State
    
            - Delivery product --> Delier Product -> return change
                -> Idle State

                
        - So, vending machine -- State Wise Operation
            - Idle STATE:
                - Press, Insert, Cash button 
            - HasChange STATE:
                - Inner coin
                - select product
                - cancel button -> Idel state
            - Selection STATE:
                - chosse product
                - return change
                - cancel/refund product -> Idel state
            - Dilever STATE
                - deliver product
                - Idle state 

    - Example TV:
        - State Wise Operation:
            - Off STATE:
                - turn On TV.
            - On STATE:
                - change channel
                - change volume
                - turn off TV
"""

################
# Solution
################
"""
- Product
- interface - State (all possible operation [op1, op2, op3, op4])
- concreate class - State1 [op1(imp), op2, op3, op4,...]
    - implement Strictly to operation realted to it.
    - else -> throw exception or default.
- concreate class - State2 [op1, op2(imp), op3, op4,...]
- concreate class - State3 [op1, op2, op3(imp), op4,...]
- concreate class - State4 [op1, op2, op3, op4(imp),...]
- .....

- Product 'HAS_A' State
"""

################
# UML
################
"""
- Vending machine
- interface State -> 'Has_A' Vending machine
    - press insert cash button
    - insert coin
    - submit button
    - select product
    - get product
    - cancel
- concreate class Idle 'IS_A' State 
    - press insert cash button - logic
    - insert coin -> throw exc
    - submit button -> throw exc
    - select product -> throw exc
    - get product -> throw exc
    - cancel
- concreate class HasMoney 'IS_A' State
    - press insert cash button - logic
    - insert coin -> throw exc
    - submit button -> throw exc
    - select product -> throw exc
    - get product -> throw exc
    - cancel
- concreate class Selection 'IS_A' State
    - press insert cash button - logic
    - insert coin -> throw exc
    - submit button -> throw exc
    - select product -> throw exc
    - get product -> throw exc
    - cancel
- concreate class Deliver 'IS_A' State
    - press insert cash button - logic
    - insert coin -> throw exc
    - submit button -> throw exc
    - select product -> throw exc
    - get product -> throw exc
    - cancel
"""

from abc import ABC, abstractmethod


# State interface
class TrafficLightState(ABC):
    @abstractmethod
    def handle(self):
        pass


# ConcreteState classes
class RedState(TrafficLightState):
    def handle(self, traffic_light):
        return f"Stop, the light is red. @{traffic_light}"


class YellowState(TrafficLightState):
    def handle(self, traffic_light):
        return f"Prepare to stop, the light is yellow.@{traffic_light}"


class GreenState(TrafficLightState):
    def handle(self, traffic_light):
        return f"Go, the light is green.@{traffic_light}"


# Context class
class TrafficLight:
    _count = 1

    def __init__(self):
        self.name = f"Tracif Light {TrafficLight._count}"

        # Default state is Red
        self.state = RedState()

        TrafficLight._count += 1

    def change_state(self, new_state):
        self.state = new_state

    def request(self):
        return self.state.handle(self)

    def __str__(self):
        return self.name


# Example usage
traffic_light = TrafficLight()
print(traffic_light.request())  # Output: Stop, the light is red.

traffic_light.change_state(YellowState())
print(traffic_light.request())  # Output: Prepare to stop, the light is yellow.

traffic_light.change_state(GreenState())
print(traffic_light.request())  # Output: Go, the light is green.

""" Diff bw State-DP & Chain Of Responsibilit-DP
- State DP:
    - object behavior change -- when its internal state changes
- Chain Of Responsibility:
    - it PASSES request along chain of handlers
"""

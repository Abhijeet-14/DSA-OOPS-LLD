########################################
# Adapter Design Pattern
########################################
"""
- Structural DP

- this is used heavily in REAL life.

- when client does understand a response -- Adapter -- simplify for client

- Indian Plug - Adapter - American Socket
- mobile - Adapter - socket
- need_json - CONVERTER - XML_response

- Defination - its BRIDGE bw Existing-Interface & Expected-Interface
    - Client ---  <<Adapter Interface>> --Is_A--> concreate Adapter
    - concreate Adapter --Has_A--> Existing Interface

- Example:
    - so, client - Indian-Plug
    - Exiting Interface - American Socket.
    - Adapter - bride bw client & Exiting Interface to interact

Solution:
    - have Existing Interface
    - Create Adapter Interface
    - concreate_adapter 'Is_A' Adapter Interface
    - concreate_adapter 'Has_A' Exiting Interface
"""

from abc import ABC, abstractmethod


class WeightMachine(ABC):
    @abstractmethod
    def get_weight_in_pound(self):
        pass


class WeightMachine_US(WeightMachine):
    def get_weight_in_pound(self):
        return 28


class WeightAdapter(ABC):
    @abstractmethod
    def get_weight_in_kg(self):
        pass


class WeightMachine_IND(WeightAdapter):
    def __init__(self, weightMachine: WeightMachine):
        self.weightMachine = weightMachine

    def get_weight_in_kg(self):
        weight_in_pound = self.weightMachine.get_weight_in_pound()
        return weight_in_pound * 0.45


us_weight_machine = WeightMachine_US()

# client don't understant Pound
# Added Concreate Adapter - WeightMachine_IND -- bw client & WeightMachine
ind_weight_machine = WeightMachine_IND(us_weight_machine)
print(ind_weight_machine.get_weight_in_kg())

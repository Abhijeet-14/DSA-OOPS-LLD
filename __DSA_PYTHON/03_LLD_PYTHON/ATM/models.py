from enum import Enum


class OperationType(Enum):
    CHECK_BALANCE = "CHECK_BALANCE"
    CASH_WITHDRAW = "CASH_WITHDRAW"


class Card:
    def __init__(self, id, pin, account):
        self.id = id
        self.pin = pin
        self.account = account


class User:
    def __init__(self, id, name, account):
        self.id = id
        self.name = name
        self.account = account


class BankAccount:
    def __init__(self, id, name, balance):
        self.id = id
        self.name = name
        self.balance = balance


class ATM:
    def __init__(self, id, atm_balance):
        self.id = id
        self.has_card = False
        self.atm_balance = atm_balance

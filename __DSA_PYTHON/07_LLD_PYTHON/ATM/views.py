import models
import repository


class CardView:

    def create_card(self, id, pin, account):
        card = models.Card(id, pin, account)
        repository.CARDRepo().add_card(card)
        return card


class BankAccountView:

    def create_bank_account(self, id, name, balance):
        account = models.BankAccount(id, name, balance)
        repository.BankAccountRepo().add_account(account)
        return account


class ATMView:

    def create_atm(self, id, balance):
        atm = models.ATM(id, balance)
        repository.ATMRepo().add_atm(atm)
        return atm

    def insert_card(self, atm):
        atm = repository.ATMRepo().get_atm(atm)
        if atm.has_card:
            raise Exception("Atm is busy")
        atm.has_card = True

        return atm

    def verify_card(self, card, pin):
        card = repository.CARDRepo().get_card(card)
        accounts = repository.BankAccountRepo().get_all_account()
        if card.account not in accounts:
            raise Exception("Account doesnot exist")
        if card.pin != pin:
            raise Exception("Incorrect Pin")
        return card

    def cash_withdraw(self, account, amount, atm):
        account = repository.BankAccountRepo().get_account(account)
        atm = repository.ATMRepo().get_atm(atm)
        if amount > atm.atm_balance:
            raise Exception("Atm doesnot have that much cash")
        if amount > account.balance:
            raise Exception("Not enough balance")
        account.balance -= amount
        repository.BankAccountRepo().update_account(account)

        return "WIthdraw"

    def check_balance(self, account):
        account = repository.BankAccountRepo().get_account(account)
        return account.balance

import views


class ATMApi:
    __atm_service: views.ATMView = None

    @staticmethod
    def create_atm_service():
        if not ATMApi.__atm_service:
            ATMApi.__atm_service = views.ATMView()

        return ATMApi.__atm_service

    def create_atm(self, id, balance):
        return self.__atm_service.create_atm(id, balance)

    def insert_card(self, atm):
        return self.__atm_service.insert_card(atm)

    def verify_card(self, card, pin):
        return self.__atm_service.verify_card(card, pin)

    def cash_withdraw(self, account, amount,atm):
        return self.__atm_service.cash_withdraw(account, amount, atm)

    def check_balance(self, account):
        return self.__atm_service.check_balance(account)


class CardApi:
    __card_service: views.CardView = None

    @staticmethod
    def create_card_service():
        if not CardApi.__card_service:
            CardApi.__card_service = views.CardView()
        return CardApi.__card_service

    def create_card(self, id, pin, account):
        return self.__card_service.create_card(id, pin, account)


class BankAccountApi:
    __bank_account_service: views.BankAccountView = None

    @staticmethod
    def create_bank_account_service():
        if not BankAccountApi.__bank_account_service:
            BankAccountApi.__bank_account_service = views.BankAccountView()
        return BankAccountApi.__bank_account_service

    def create_bank_account(self, id, name, balance):
        return self.__bank_account_service.create_bank_account(id, name, balance)

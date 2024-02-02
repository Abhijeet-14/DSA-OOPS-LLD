class CARDRepo:

    __card = None

    @staticmethod
    def create_card_repo():
        if not CARDRepo.__card:
            CARDRepo.__card = {}
        return CARDRepo.__card

    def add_card(self, card):
        if self.__card.get(card.id):
            raise Exception("card ALready Exist")
        self.__card[card.id] = card

        return self.__card[card.id]

    def get_card(self, card):
        return self.__card.get(card.id)

    def get_all_card(self):
        return self.__card.values()


class ATMRepo:

    __atm = None

    @staticmethod
    def create_atm_repo():
        if not ATMRepo.__atm:
            ATMRepo.__atm = {}
        return ATMRepo.__atm

    def add_atm(self, atm):
        if self.__atm.get(atm.id):
            raise Exception("atm ALready Exist")
        self.__atm[atm.id] = atm

        return self.__atm[atm.id]

    def get_atm(self, atm):
        return self.__atm.get(atm.id)

    def get_all_atm(self):
        return self.__atm.values()


class BankAccountRepo:

    __bank_accounts = None

    @staticmethod
    def create_bank_account_repo():
        if not BankAccountRepo.__bank_accounts:
            BankAccountRepo.__bank_accounts = {}
        return BankAccountRepo.__bank_accounts

    def add_account(self, account):
        if self.__bank_accounts.get(account.id):
            raise Exception("Account ALready Exist")
        self.__bank_accounts[account.id] = account

        return self.__bank_accounts[account.id]

    def get_account(self, account):
        return self.__bank_accounts.get(account.id)

    def update_account(self, account):
        self.__bank_accounts[account.id] = account

    def get_all_account(self):
        return self.__bank_accounts.values()

import api
import repository

atm_repo = repository.ATMRepo.create_atm_repo()
card_repo = repository.CARDRepo.create_card_repo()
bank_account_repo = repository.BankAccountRepo.create_bank_account_repo()

atm_service = api.ATMApi.create_atm_service()
card_service = api.CardApi.create_card_service()
bank_account_service = api.BankAccountApi.create_bank_account_service()
# print(atm_service)
# print(card_service)
# print(bank_account_service)

atm_1 = atm_service.create_atm(1, 11200)

bank_account_1 = bank_account_service.create_bank_account(1, "U1", 1000)
card_1 = card_service.create_card(1, "123", bank_account_1)

bank_account_2 = bank_account_service.create_bank_account(2, "U2", 2000)
card_2 = card_service.create_card(2, "123", bank_account_1)

# print(atm_1)
# print(bank_account_1)
# print(card_1)
# print(bank_account_2)
# print(card_2)

print(atm_service.insert_card(atm_1))
print(atm_service.verify_card(card_1, "123"))
print(atm_service.check_balance(bank_account_1))
print(atm_service.cash_withdraw(bank_account_1, 200, atm_1))
print(atm_service.check_balance(bank_account_1))

print(atm_service.cash_withdraw(bank_account_1, 10000, atm_1))
print(atm_service.check_balance(bank_account_1))

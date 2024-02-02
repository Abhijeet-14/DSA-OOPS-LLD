# Problem Statement
Design an ATM machine

# FLow Discussion
- user -> insert card
- after PIN verify
- Type of operation need to perform (Cash Withdraw, Check Balance)
- Perform that Operation
- remove the card
- exit

# Gather Requirements
- User, Card, BankAccount, ATM, 
# Entity
- user(id, name, card)
- card(id, PIN, account)
- bankAccount(id, balance)
- ATM(id, balance, hasCard)
- ATMState - abstract class

# Fields

# Behaviour
- ATM (cashWithdraw, checkBalance, insertCard, PIN Verification, selectOperation, performOperation, removeCard, exit)
  - ATMState -> NoCard, HasCard, PIN Verify, SelectOperation, PerformOp,
- bankAccount(update Balance)
- card(PIN Verification)

# Expectation
Bonus: Cash Withdrawal based on max amount currency available first
    e.g., 1700 - 1-(1000 Note) + 1-(500 Note) + 2-(100 Note)

# Code
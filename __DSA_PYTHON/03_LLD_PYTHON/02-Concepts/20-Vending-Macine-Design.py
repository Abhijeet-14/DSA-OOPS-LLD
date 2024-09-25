"""
Design A Vending Machine
- Follow MVC
    - M - VendingMachine etc
    - C - VendingMachineManager
    - View - client()
"""

from enum import Enum, auto


class CoinType(Enum):
    ONE = 1
    TWO = 2
    FIVE = 5
    TEN = 10


class Coin:
    def __init__(self, coin_type: CoinType):
        self.coin_type = coin_type

    def __str__(self):
        return self.coin_type.value


class VendingMachineStateType(Enum):
    IDLE = auto()
    HAS_MONEY = auto()
    SELECT_PRODUCT = auto()
    DELIVER_PRODUCT = auto()


class ItemType(Enum):
    COKE = auto()
    PEPSI = auto()
    SPRITE = auto()

    def __str__(self):
        return self.name


class Item:
    def __init__(self, item_type: ItemType, price):
        self.item_type = item_type
        self.price = price


class ItemShelf:
    def __init__(self, item: Item, code, stock: int):
        self.item: Item = item
        self.code = code
        self.stock = stock

    def deliver_item(self):
        if self.stock != 0:
            self.stock -= 1
            return
        print(f"Stock is already empty for {self.item.item_type}")

    def is_out_of_stock(self):
        return not bool(self.stock)


class Inventory:
    def __init__(self):
        self.item_shelfes: list[ItemShelf] = []

    def add_item_shelfes(self, item_shelf: ItemShelf):
        self.item_shelfes.append(item_shelf)

    def is_inventory_empty(self):
        return not bool(len(self.item_shelfes))


from abc import ABC, abstractmethod


class StateInterface(ABC):
    def __init__(self, name, default_err_msg):
        self.name = name
        self.default_err_msg = default_err_msg

    def raise_default_err(self):
        print(self.default_err_msg)

    @abstractmethod
    def insert_cash_button(self, machine):
        self.raise_default_err()

    @abstractmethod
    def insert_coin(self, machine, coin):
        self.raise_default_err()

    @abstractmethod
    def select_product_button(self, machine):
        self.raise_default_err()

    @abstractmethod
    def choose_product(self, product_code, machine):
        self.raise_default_err()

    @abstractmethod
    def deliver_product_to_client(self, machine):
        self.raise_default_err()

    @abstractmethod
    def cancel_button(self, machine):
        self.raise_default_err()

    def __str__(self):
        return f"{self.name}"


class VendingMachine:  # Model
    def __init__(self, inventory: Inventory, state: StateInterface):
        self.inventory: Inventory = inventory
        self.coin_list: list[Coin] = []
        self.state: StateInterface = state
        self.product_to_be_deliver: Item = None

    def insert_cash_button_request(self):
        self.get_vending_machine_state()
        self.state.insert_cash_button(self)

    def insert_coin_request(self, coin: Coin):
        self.get_vending_machine_state()
        self.state.insert_coin(self, coin)

    def select_product_button_request(self):
        self.get_vending_machine_state()
        self.state.select_product_button(self)

    def cancel_button_request(self):
        self.get_vending_machine_state()
        self.state.cancel_button(self)

    def choose_product_request(self, product_code):
        self.get_vending_machine_state()
        self.state.choose_product(product_code, self)

    def deliver_product_to_client_request(self):
        self.get_vending_machine_state()
        self.state.deliver_product_to_client(self)

        self.get_vending_machine_state()

    def get_vending_machine_state(self):
        print("\nVending Machine State: ", self.state)
        return self.state

    def set_vending_machine_state(self, state: StateInterface):
        self.state = state

    def get_vending_machine_inventory(self):
        return self.inventory

    def set_vending_machine_inventory(self, inventory: Inventory):
        self.inventory = inventory

    def get_vending_machine_coin_list(self):
        return self.coin_list

    def set_vending_machine_coin_list(self, coin_list: Inventory):
        self.coin_list = coin_list

    def get_sum_of_coins(self) -> int:
        return sum(coin.__str__() for coin in self.coin_list)

    def refund_amount(self) -> int:
        amount_to_refund = self.get_sum_of_coins()
        self.set_vending_machine_coin_list([])
        self.set_vending_machine_state(IdleSTATE())

        print(f"Refunding the amount: {amount_to_refund}")

    def set_product_to_deliver(self, item):
        self.product_to_be_deliver = item

    def deliver_product(self):

        for item_shelf in self.inventory.item_shelfes:
            if item_shelf.item == self.product_to_be_deliver:
                item_shelf.deliver_item()
                self.set_vending_machine_coin_list([])
                self.set_vending_machine_state(IdleSTATE())
                print(
                    f"Please collect your product: {self.product_to_be_deliver.item_type}"
                )
                return
        print("Selected product is out of stock")


class VendingMachineManager:  # Collector

    def __init__(self, machine: VendingMachine):
        self.machine: VendingMachine = machine


class DeliverSTATE(StateInterface):
    def __init__(self):
        super().__init__(
            VendingMachineStateType.DELIVER_PRODUCT, "Err: Deliver product is in progress"
        )

    def insert_cash_button(self, machine: VendingMachine):
        super().insert_cash_button()

    def insert_coin(self, machine: VendingMachine, coin: Coin):
        super().insert_coin()

    def select_product_button(self, machine: VendingMachine):
        super().select_product_button()

    def choose_product(self, product_code, machine):
        super().choose_product()

    def deliver_product_to_client(self, machine: VendingMachine):
        machine.deliver_product()

    def cancel_button(self, machine: VendingMachine):
        super().cancel_button(machine)
        print("Cancelling not allowed")


class SelectProductSTATE(StateInterface):
    def __init__(self):
        super().__init__(
            VendingMachineStateType.SELECT_PRODUCT, "Err: Select product is in progress"
        )

    def insert_cash_button(self, machine: VendingMachine):
        super().insert_cash_button()

    def insert_coin(self, machine: VendingMachine, coin: Coin):
        super().insert_coin()

    def select_product_button(self):
        super().select_product_button()

    def choose_product(self, product_code, machine: VendingMachine):
        selected_item: Item = None
        for item_shelf in machine.inventory.item_shelfes:
            if item_shelf.code == product_code:
                selected_item = item_shelf.item
                break

        # check totol amount paid vs item price
        total_amount_paid = machine.get_sum_of_coins()
        if selected_item.price > total_amount_paid:
            print(
                f"Insufficent amount paid, required {selected_item.price}. Order cancelled"
            )
            machine.refund_amount()
            return

        machine.set_product_to_deliver(selected_item)

        amount_to_return = self.get_change(total_amount_paid, machine)
        print("Returing amount: ", amount_to_return)

        machine.set_vending_machine_state(DeliverSTATE())

    def deliver_product_to_client(self, machine: VendingMachine):
        return super().deliver_product_to_client(machine)

    def get_change(self, total_amount_paid: int, machine: VendingMachine):
        return abs(machine.product_to_be_deliver.price - total_amount_paid)

    def cancel_button(self, machine: VendingMachine):
        print("Cancelling order")
        machine.refund_amount()


class HasMoneySTATE(StateInterface):
    def __init__(self):
        super().__init__(
            VendingMachineStateType.HAS_MONEY, "Err: Insert Coin operation is in progress"
        )

    def insert_cash_button(self, machine):
        return super().insert_cash_button(machine)

    def insert_coin(self, machine: VendingMachine, coin: Coin):
        print(f"{coin.coin_type} accpeted")
        machine.get_vending_machine_coin_list().append(coin)

    def select_product_button(self, machine: VendingMachine):
        print("Activating 'select product button'")
        machine.set_vending_machine_state(SelectProductSTATE())

    def choose_product(self, product_code, machine):
        return super().choose_product(product_code, machine)

    def deliver_product_to_client(self, machine: VendingMachine):
        return super().deliver_product_to_client(machine)

    def cancel_button(self, machine: VendingMachine):
        print("Cancelling order")
        machine.refund_amount()


class IdleSTATE(StateInterface):
    def __init__(self):
        super().__init__(
            VendingMachineStateType.IDLE,
            "Err: Machine is IDLE, click Insert Cash Button first",
        )

    def insert_cash_button(self, machine: VendingMachine):
        machine.set_vending_machine_coin_list([])
        machine.set_vending_machine_state(HasMoneySTATE())

    def select_product_button(self, machine):
        return super().select_product_button(machine)

    def choose_product(self, product_code, machine):
        return super().choose_product(product_code, machine)

    def cancel_button(self, machine):
        return super().cancel_button(machine)

    def deliver_product_to_client(self, machine: VendingMachine):
        return super().deliver_product_to_client(machine)

    def insert_coin(self, machine, coin):
        return super().insert_coin(machine, coin)


def vending_machine_client():  # View
    coin_ONE = Coin(CoinType.ONE)
    coin_TWO = Coin(CoinType.TWO)
    coin_FIVE = Coin(CoinType.FIVE)
    coin_TEN = Coin(CoinType.TEN)

    item_COKE = Item(ItemType.COKE, 10)
    item_PEPSI = Item(ItemType.PEPSI, 12)
    item_SPRITE = Item(ItemType.SPRITE, 17)

    item_shelf_one = ItemShelf(item_COKE, 101, 3)
    item_shelf_two = ItemShelf(item_PEPSI, 102, 1)
    item_shelf_three = ItemShelf(item_SPRITE, 102, 0)

    inventory = Inventory()

    inventory.add_item_shelfes(item_shelf_one)
    inventory.add_item_shelfes(item_shelf_two)
    inventory.add_item_shelfes(item_shelf_three)

    machine = VendingMachine(inventory, IdleSTATE())
    print("Vending Machine Inventory is ready")

    # current_state: StateInterface = machine.get_vending_machine_state()
    machine.insert_cash_button_request()
    # current_state.insert_cash_button(machine)

    # current_state = machine.get_vending_machine_state()
    machine.insert_coin_request(coin_TEN)
    machine.insert_coin_request(coin_FIVE)

    # current_state = machine.get_vending_machine_state()
    machine.select_product_button_request()
    # machine.cancel_button_request()

    # current_state = machine.get_vending_machine_state()
    machine.choose_product_request(102)

    # current_state = machine.get_vending_machine_state()
    machine.deliver_product_to_client_request()

    # current_state = machine.get_vending_machine_state()


vending_machine_client()

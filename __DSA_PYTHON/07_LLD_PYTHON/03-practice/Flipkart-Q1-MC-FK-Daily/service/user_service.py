from .db import DB
from model.user import User


class UserService:
    def __init__(self) -> None:
        self.users = DB.users

    def add_user(self, name, address, wallet):
        if name in self.users:
            raise Exception("User with this name already exist")
        user = User(name, address, wallet)
        self.users[name] = user
        print(f"Successfully added user:{user.name}")

    def get_user_by_name(self, user_name):
        if user_name not in self.users:
            raise Exception("User doesnot exist")
        return self.users[user_name]


class CartService:
    def __init__(self) -> None:
        self.users = DB.users
        self.user_service = UserService()

    def add_cart(self, user_name, brand, category, item, unit):
        user = self.user_service.get_user_by_name(user_name)
        user.cart.add_item(brand, category, item, unit)
        # self.get_cart(user.name)

    def remove_cart(self, user_name, brand, category, unit):
        pass

    def update_cart(self, user_name, brand, category, unit):
        pass

    def get_cart(self, user_name):
        user = self.user_service.get_user_by_name(user_name)
        cart = user.get_cart()

        if not cart.items.keys():
            raise Exception("Empty Cart")

        total = self.calculate_cart_total(cart)
        for brand, categories in cart.items.items():
            for category, value in categories.items():
                print(brand, end="->")
                print(category, end="->")
                print(value[1])

        print(f"total price: {total}\n")

    def calculate_cart_total(self, cart: dict):
        items = cart.items
        if not items.keys():
            raise Exception("No order to checkout")
            
        cart_total = 0
        for brand, categories in items.items():
            for category, val in categories.items():
                curr_item = val[0]
                curr_item_quantity = val[1]
                curr_item_price = curr_item.price * curr_item_quantity
                cart_total += curr_item_price
        return cart_total

    def checkout(self, user_name):
        user = self.user_service.get_user_by_name(user_name)
        amount_to_deduct = self.calculate_cart_total(user.get_cart())

        if user.wallet < amount_to_deduct:
            raise Exception(f"Insufficent Wallet amount, require {amount_to_deduct}")
        user.checkout(amount_to_deduct)
        print(f"Successful checkout , new wallet amount: {user.wallet}")

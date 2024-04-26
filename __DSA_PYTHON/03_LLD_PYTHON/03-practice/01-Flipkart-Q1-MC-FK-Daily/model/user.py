from .cart import Cart


class User:
    def __init__(self, name, address, wallet=0) -> None:
        self.name = name
        self.address = address
        self.wallet = wallet
        self.cart = Cart()

    def get_cart(self):
        return self.cart

    def checkout(self, amount_to_deduct):
        

        self.wallet = self.wallet - amount_to_deduct

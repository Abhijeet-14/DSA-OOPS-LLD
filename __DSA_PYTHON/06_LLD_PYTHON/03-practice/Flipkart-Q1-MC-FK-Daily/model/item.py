class Item:
    def __init__(self, brand, category, price) -> None:
        self.brand = brand
        self.category = category
        self.price = price

    def update_price(self, price):
        self.price = price

    def __str__(self): return f"{self.brand}, {self.category}, {self.price}"

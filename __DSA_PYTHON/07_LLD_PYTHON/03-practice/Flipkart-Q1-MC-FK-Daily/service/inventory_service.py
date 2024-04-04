from .db import DB
from model.item import Item

from abc import ABC, abstractmethod


class FilterSearchStrategy(ABC):
    def __init__(self, min_price, max_price, brands=[], categories=[]):
        self.min_price = min_price
        self.max_price = max_price
        self.brands = brands
        self.categories = categories

    def search(self, items: dict):
        print("\n---Searching---")
        for brand, categories in items.items():
            if not self.brands or brand in self.brands:
                for category, val in categories.items():
                    if not self.categories or category in self.categories:
                        if (not self.min_price or val[0].price >= self.min_price) and (
                            not self.max_price or val[0].price <= self.max_price
                        ):
                            print(brand, end="-> ")
                            print(category, end="-> ")
                            print(f"{val[0].price} -> {val[1]}")
                    


class InventoryService:
    def __init__(self) -> None:
        self.items = DB.items
        self.active_items = DB.active_items

    def get_item_by_name_categoy(self, brand, categoy):
        if brand not in self.items:
            raise Exception("Brand does not exist in inventory")
        if categoy not in self.items[brand]:
            raise Exception("Category does not exist in inventory")

        return self.items[brand][categoy]

    def add_item(self, brand, category, price):
        if brand not in self.items:
            self.items[brand] = {}
        if category not in self.items[brand]:
            self.items[brand][category] = None
        item = Item(brand, category, price)
        self.items[brand][category] = item
        return self.items

    def check_item_exist_in_inventory(self, brand, category):
        if brand not in self.active_items:
            print("Brand does not exist in inventory")
            self.active_items[brand] = {}
        if category not in self.active_items[brand]:
            print("Category does not exist in inventory")
            self.active_items[brand][category] = (None, 0)
        return self.active_items[brand][category]

    def add_inventory(self, brand, category, unit):
        item = self.get_item_by_name_categoy(brand, category)
        prev_item, old_unit = self.check_item_exist_in_inventory(brand, category)
        old_unit = 0
        self.active_items[brand][category] = (item, old_unit + unit)
        return self.active_items

    def update_inventory(self, brand, category, unit):
        item, old_unit = self.check_item_exist_in_inventory(brand, category)

        self.active_items[brand][category] = (item, old_unit+unit)

    def view_inventory(self):
        for brand, categories in self.active_items.items():
            for category, val in categories.items():
                print(brand, end="->")
                print(category, end="->")
                print(val[1])

    def search_items(
        self, brands: list[str], categories: list[str], min_price: int, max_price: int
    ):
        strategy = FilterSearchStrategy(
            brands=brands,
            categories=categories,
            min_price=min_price,
            max_price=max_price,
        )

        strategy.search(self.active_items)

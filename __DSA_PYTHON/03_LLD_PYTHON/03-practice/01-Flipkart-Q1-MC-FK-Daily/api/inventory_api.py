from service.inventory_service import InventoryService
from .exception import handle_exception


class InventoryAPI:
    def __init__(self) -> None:
        self.__inventory_service = InventoryService()

    @handle_exception
    def add_item(self, brand, category, price):
        return self.__inventory_service.add_item(brand, category, price)

    @handle_exception
    def add_inventory(self, brand, category, unit):
        return self.__inventory_service.add_inventory(brand, category, unit)

    @handle_exception
    def update_inventory(self, brand, category, unit):
        return self.__inventory_service.update_inventory(brand, category, unit)

    @handle_exception
    def view_inventory(self):
        return self.__inventory_service.view_inventory()

    def search_items(
        self, brands=[], categories=[], min_price=0, max_price=float("inf")
    ):
        self.__inventory_service.search_items(brands, categories, min_price, max_price)

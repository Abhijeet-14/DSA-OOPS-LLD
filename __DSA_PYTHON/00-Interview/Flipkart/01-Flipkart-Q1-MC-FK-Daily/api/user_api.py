from service.user_service import UserService, CartService
from service.inventory_service import InventoryService
from .exception import handle_exception


class UserAPI:
    def __init__(self) -> None:
        self.__user_service = UserService()
        self.__cart_service = CartService()
        self.__inventory_service = InventoryService()

    @handle_exception
    def add_user(self, name, address, wallet):
        self.__user_service.add_user(name, address, wallet)

    @handle_exception
    def add_cart(self, user_name, category, brand, unit):
        item = self.__inventory_service.get_item_by_name_categoy(brand, category)
        self.__cart_service.add_cart(user_name, brand, category, item, unit)

    @handle_exception
    def get_cart(self, user_name):
        self.__cart_service.get_cart(user_name)
    @handle_exception
    def checkout(self, user_name):
        self.__cart_service.checkout(user_name)

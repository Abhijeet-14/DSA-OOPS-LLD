from api.user_api import UserAPI
from api.inventory_api import InventoryAPI

inventory_api = InventoryAPI()
user_api = UserAPI()


inventory_api.add_item("Amul", "Milk", 100)
inventory_api.add_item("Amul", "Curd", 50)
inventory_api.add_item("Nestle", "Milk", 60)
inventory_api.add_item("Nestle", "Curd", 90)

inventory_api.add_inventory("Amul", "Milk", 10)
inventory_api.add_inventory("Nestle", "Milk", 15)
inventory_api.add_inventory("Nestle", "Curd", 10)
inventory_api.add_inventory("Amul", "Milk", 10)
inventory_api.add_inventory("Amul", "Curd", 5)

inventory_api.view_inventory()

user_api.add_user("Jhonny", "”Flipkart Bellandur, Bangalore 560068”", 600)
user_api.add_user("Naruto", "BTM Layout, Bengaluru, 560042", 500)
user_api.add_user("Goku", "Vijay nagae", 3000)

user_api.add_cart("Jhonny", "Milk", "Nestle", 15)

inventory_api.update_inventory("Amul", "Curd", 5)
user_api.add_cart("Goku", "Milk", "Nestle", 10)

user_api.get_cart("Jhonny")
user_api.get_cart("Goku")
user_api.get_cart("Naruto")

inventory_api.view_inventory()

print("-- Search --")
inventory_api.search_items(["Nestle"], min_price=65)
inventory_api.search_items(["Nestle", "Amul"], ["Curd"])
inventory_api.search_items(["Nestle"], ["Curd", "Milk", "Paneer"])
user_api.checkout("Goku")
user_api.checkout("Jhonny")
user_api.checkout("Naruto")
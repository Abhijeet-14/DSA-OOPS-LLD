from .item import Item


class Cart:
    def __init__(self) -> None:
        self.items: dict[str, dict[str, list]] = {}

    def get_items(self, brand, category):

        return self.items[brand][category]

    def add_item(self, brand, category, item, unit):
        self.items[brand] = {category: (item, unit)}

    def udpate_item(self, brand, category, item, unit):
        item, item_unit = self.get_item(brand, category)

        item_unit += unit
        if item_unit == 0:
            del self.items[brand][category][item]
        else:
            self.items[brand][category] = (item, item_unit)

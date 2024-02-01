class User:
    def __init__(self, id, name):
        self.id = id
        self.name = name


class Rating:
    def __init__(self, id, value, restaurant, user, dish, message):
        self.id = id
        self.value = value
        self.dish = dish
        self.message = message
        self.restaurant = restaurant
        self.user = user


class Restaurant:
    def __init__(self, id, name):
        self.id = id
        self.name = name
        self.average_rating = 0
        self.ratings = []

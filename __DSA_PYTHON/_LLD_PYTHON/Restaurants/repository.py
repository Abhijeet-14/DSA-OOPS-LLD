from models import *


class UserRepo:
    __users = None

    @staticmethod
    def create_user_table():
        if not UserRepo.__users:
            UserRepo.__users = {}
        return UserRepo.__users

    def add_user(self, user):
        if self.__users.get(user.id):
            raise Exception("User Alredy exist")

        self.__users[user.id] = user

        return self.__users[user.id]

    def get_user_by_id(self, user):
        if not self.__users.get(user.id):
            raise Exception("User doesnot exist")
        return self.__users.get(user.id)

    def get_all_users(self):
        return self.__users.values()


class RestaurantRepo:
    __restaurants = None

    @staticmethod
    def create_restaurant_table():
        if not RestaurantRepo.__restaurants:
            RestaurantRepo.__restaurants = {}
        return RestaurantRepo.__restaurants

    def add_restaurant(self, resaturant):
        if self.__restaurants.get(resaturant.id):
            raise Exception("Restaurant Already exist")

        self.__restaurants[resaturant.id] = resaturant
        return resaturant

    def add_rating(self, resaturant: Restaurant, rating: Rating):
        restaurant_instance = self.__restaurants[resaturant.id]
        restaurant_instance.ratings.append(rating)
        self.__restaurants[resaturant.id] = restaurant_instance
        return self.__restaurants[resaturant.id]

    def get_restaurant_by_id(self, resaturant):
        if not self.__restaurants.get(resaturant.id):
            raise Exception("Restaurant doesnot exist")
        return self.__restaurants.get(resaturant.id)

    def get_all_restaurants(self):
        return self.__restaurants.values()

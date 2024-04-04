from views import UserView, RestaurantView


class UserApi:
    __user_service: UserView = None

    @staticmethod
    def create_user_service():
        if not UserApi.__user_service:
            UserApi.__user_service = UserView()

        return UserApi.__user_service

    def add_user(self, id, name):
        return self.__user_service.add_user(id, name)


class RestaurantAPI:
    __restaurant_service: RestaurantView = None

    @staticmethod
    def create_restaurant_service():
        if not RestaurantAPI.__restaurant_service:
            RestaurantAPI.__restaurant_service = RestaurantView()

        return RestaurantAPI.__restaurant_service

    def add_restaurant(self, id, name):
        return self.__restaurant_service.add_restaurant(id, name)

    def add_rating(self, id, value):
        return self.__restaurant_service.add_rating(id, value)

    def add_rating(self, value, user, dish, message):
        return self.__restaurant_service.add_rating(value, user, dish, message)

    def get_restaurant_details(self):
        return self.__restaurant_service.get_restaurant_details_with_average_rating()

    def get_all_restaurant_by_average_rating(self):
        return RestaurantView.get_all_restaurant_by_average_rating()

    def get_all_restaurant_by_average_rating(self, low, high):
        return RestaurantView.get_all_restaurant_by_rating_range(low, high)

import models
import repository


class UserView:
    def add_user(self, id, name):
        user = models.User(id, name)
        # user_db = repository.UserRepo().create_user_table()
        return repository.UserRepo().add_user(user)


class RestaurantView:
    @staticmethod
    def get_average_rating(ratings):
        no_of_ratings = len(ratings)
        if no_of_ratings < 1:
            return 0

        total_rating_value = 0
        for rating in ratings:
            total_rating_value += rating.value
        return round(total_rating_value / no_of_ratings, 1)

    def add_restaurant(self, id, name):
        restaurant = models.Restaurant(id, name)
        return repository.RestaurantRepo().add_restaurant(restaurant)

    def add_rating(self, id, value, resaturant, user):
        rating = models.Rating(id, value, resaturant, user)
        return repository.RestaurantRepo().add_rating(resaturant, rating)

    def add_rating(self, value, resaturant, user, dish="", message=""):
        rating = models.Rating(id, value, resaturant, user, dish, message)
        return repository.RestaurantRepo().add_rating(resaturant, rating)

    def get_restaurant_details_with_average_rating(self, resaturant):
        restaurant = repository.RestaurantRepo().get_restaurant_by_id(resaturant)
        resaturant.average_rating = self.get_average_rating(resaturant.ratings)
        return restaurant.__dict__

    @staticmethod
    def get_all_restaurant_by_rating_range(low, high=10):
        if low > high:
            return []
        restaurants = repository.RestaurantRepo().get_all_restaurants()
        result = []

        for resaturant in restaurants:
            resaturant.average_rating = RestaurantView.get_average_rating(
                resaturant.ratings
            )
            if resaturant.average_rating in range(low, high + 1):
                result.append(resaturant.__dict__)
        return result

    @staticmethod
    def get_all_restaurant_by_average_rating():
        restaurants = repository.RestaurantRepo().get_all_restaurants()
        result = []

        for resaturant in restaurants:
            resaturant.average_rating = RestaurantView.get_average_rating(
                resaturant.ratings
            )
            result.append(resaturant.__dict__)
        result.sort(key=lambda x: -x["average_rating"])
        return result

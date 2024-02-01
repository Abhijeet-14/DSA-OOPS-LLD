# if __name__ == "__main__":
#     print("Running Restaurant Application")

import api

import views
import repository
import models

user_db = repository.UserRepo.create_user_table()
restaurant_db = repository.RestaurantRepo.create_restaurant_table()
print(user_db, restaurant_db)

user_service = api.UserApi.create_user_service()

user_1 = user_service.add_user(1, "ABC")
user_2 = user_service.add_user(2, "XYZ")
print(user_1, user_2)
print(repository.UserRepo().get_all_users())

restaurant_service = api.RestaurantAPI.create_restaurant_service()

restaurant_1 = restaurant_service.add_restaurant(1, "Restaurant 1")
restaurant_service.add_rating(7, restaurant_1, user_1)
restaurant_service.add_rating(9, restaurant_1, user_2, "DOSA", "GOOD")

restaurant_2 = restaurant_service.add_restaurant(2, "Restaurant 1")
restaurant_service.add_rating(3, restaurant_2, user_1)
restaurant_service.add_rating(5, restaurant_2, user_2, "DOSA", "BAD")

print(restaurant_service.get_restaurant_details_with_average_rating(restaurant_1))

print(restaurant_service.get_all_restaurant_by_rating_range(8))
print(restaurant_service.get_all_restaurant_by_rating_range(9))

print(restaurant_service.get_all_restaurant_by_average_rating())

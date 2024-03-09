"""
### Problem Statement
Your aim is to implement a restaurant rating system. 
Following are the features that it should have:
    1. Register: Users should be able to register to give ratings 
        for restaurants.
    2. Rate: Among the pre-populated list of restaurants, 
            registered users can give rating between 1 to 10. 
            If the same user gives a new rating for the same 
            restaurant, it should be overwritten.
    3. Rate with options: Along with a rating, users can add 
                        optional dish name(s) and rating description.
    4. List reviews: When fetching reviews for a restaurant based on 
                filter and order by
            1. Filter: Ratings should be able to be filtered based on range 
                of rating (eg. ratings between 4 (lower range) 
                and 7 (higher range)).
                1. Lower range value
                2. Higher range value
                Note: Filter can have lower range, higher range or both
            2. Order By: Order by
                1. Ascending order of rating
                2. Descending order of rating
            Default should be with a higher rating first without any filter.
    5. Describe: When describing a restaurant, along with the name, 
                give the average rating it received so far.
    6. List: List restaurants based on descending order of (average) 
            rating.


#### Bonus
1. Upgrade:  For each user a level will be defined which determines 
their foodiness. A new user by default will have level 1. 
The level would be allotted based on the number of ratings given 
by a user
      1. 4 ratings: level 2
      2. 8 ratings: level 3
      3. 16 ratings: level 4
2. List reviews:
      1. Filter: Add range of levels of reviewers whose ratings 
      you want to fetch
      2. Order by: Order reviews by levels of reviewers
"""

""" SOLUTION
# Requirements - clarification
    1. Actor - resaturant, user
    2. restaurant can register
    3. user created
    4. user can rate  restaurant
    5. user can rate restaurant with dish & message
    6. resturant get restaurant details with average rating
    7. list all rating with filter(low, high) and order by rating
    8. list top restaurant based on average rating

# Sample Input
    1. r1 - Restaurant
    2. u1 - user
    3. u1.add_rating(4)
    4. u1.add_rating(4, DOSA, "Bad")
    5. r1.get_details() - {..., average_rating: 3.2}
    6. Restaurant.get_all_restaurant_by_rating_range(6, 8)
    7. Restaurant.get_all_restaurant_by_average_rating()

# Class Diagram attributes
    1. user(id, name)
    2. Rating(id, restaurant_id, user_id, value, dish, message)
    3. Restaurant(id, name, average_rating)

"""

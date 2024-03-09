### AMAZON - Leetcode
# Q1 (Sept 2022)
"""
Write code that will be used by a Shopping cart service to enforce rules on the order

eg. Offer free 2 day shipping on orders > $35 if customer is not a prime member Offer free 2 day shipping on all orders if customer is a prime member Offer free 1 day shipping for order that are > $125 Offer free 2 hour shipping for prime customer that have > $25 and the items are grocery items

Make this extensible to add other rules in the future Apply a 10% discount if an item has been marked for subscribe and save

I was thinking of creating a Shopping cart class and create one prime member class and other non prime member.
interfaces for Shipping speed calculator and one for discount calculator
What should be best design for this
"""

# Q2 (June 2022)
"""
Design a chain of pharmacy stores.

    1. If a medicine is not available in Area pharmacy centre, we check in Additional pharmacy centre.
    2. If it is not present there, we check in Main pharmacy centre.
My solution :
    Use Chain of Responsibilty pattern. Create a chain of pharmacy stores. Each pharmacy store checks whether the medicine is present in it or not. If it is present, it returns the medicine. Else, it forwards the requests to the next centre in the chain.
    I gave the above solution but I could not clear this round. It looked like the interviewer was looking for something else.
"""

# Q3 (Feb 2024)
"""
I attended interview of amazon seattle for SDE1 and there was one medium level leetcode question and other design was asked. Which is below.
Design a file explorer search mechanisim for searching files with given name in the whole file explorer.
"""

# Q4 (Aug 2022)
"""
Newsfeed - Low Level Design
1)user login for newsfeed

2)user can see pages which they follow

3) user can see other user post which they follow - these will be sorted in a customized order as decided at runtime

4) User can create posts on their own or friends profile

5)User can react, comment, like/dislike posts and comments.

6)Users can also reply to comments
"""

# Q (March 2022)
"""
Design a vending machine which has different products in various slots and can except 10, 20,50 and 100 Notes, it can also except wallet payment. Each product has certain Quantity and it will decrease once u take out that product from vending machine.

Accepting cash & wallet payment
Select slot ,Price ,Pay
Vend the Product / Cancel the transaction
Admin ->Loads the product in Vending Machine[Once in a day]
"""

# Q6 (Jan 2021)
"""
In design round i was asked to Design a coupon and voucher managment system's Low level design.

Requirements were:
    Admin will create coupons with rules(like match age>18 and cart_value>1000);
    Coupons will have (averall uses limit / per ser limit ), expiry date , active/inactive etc.

Vouchers will be of type
    Unassigned : anyone can use but only one uses
    "PreAssigned": Voucher attached to user id

Was asked to design api too:
    User will see list of coupons available and Vouchers;
    Admin can delete/ create , activate or disable coupons etc.

Comment your Approach
"""

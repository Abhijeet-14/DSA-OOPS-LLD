# Req
- deliver grocery & daily ess by next morn
- user -> search for items from inventory 
- search with some filteers
- place order -> only iff have suffi balance

# Feat:
- inventory mng 
    - create Item (brand, category, price, quanity)
- add/remove item and /update quantity of items - in user cart
- get user Cart info
- create wallet for user -> some balance
- add monry in wallet
- checkout - using wallet money


## Test Case
- Add/Update Item (brand, category, price)
- Add inventory (category,brand, quantity) 
- Add user (“Name”,”Address”,”Wallet Amount”)
- Add user (“Name”,”Address”,”Wallet Amount”)
- Search (“brand”,”category”)  
    - expected response  <brand, category, price, remaining_inventory_count>
    - {Bonus} - Multiple filter
- Add to cart(user, category, brand, quantity)
- Get cart info(user) 
- Remove from cart 
- Checkout

## Check
- checkout - user wallet suffi

# I/O
# AddItem(<item_brand>, <item_category>, <item_price>)
    - AddItem(Amul, Milk, 100) 

# AddInventory(<item_brand>, <item_category>, <units>)
    - AddInventory(Amul, Milk, 10) 

## Final View Inventory :
Amul - > Milk -> 20 
Amul -> Curd -> 5 
Nestle -> Milk -> 15 
Nestle -> Curd -> 10 

# AddUser(<Name>,<Address>,<Wallet Amount>)
    - AddUser(Jhonny, ”Flipkart Bellandur, Bangalore 560068”,  600)

# AddToCart(<User_Name>, <item_category>, <item_brand>, <units>)
AddToCart(Jhonny, Milk, Nestle, 5) 

# UpdateIentory(<item_brand>, <item_category>, <units>)
UpdateInventory(Nestle, Milk, 5) 

# GetCart(<User_Name>)
GetCart(Goku)
    - Nestle -> Milk -> 5 -> Total Price 25
    - Empty Cart 

# search
## expected response  <brand, category, price, remaining_inventory_count>

SearchItems([Nestle]) 
Nestle -> Curd-> 90 -> 10

# SearchItems([Nestle, Amul], [Curd]) 
Amul -> Curd -> 50 -> 5 
Nestle -> Curd -> 90 -> 10 

# Checkout(<Name>)
Checkout(Goku)
-> Successful checkout , new wallet amount: 2950

Checkout(Naruto)
-> No order to checkout

Checkout(Goku)
-> Not enough wallet amount, required amount: 2950


# List Objects
- user - name, address, cart, wallet amount
- cart - {brand: {category: unit}}
- item - brand, price, category

# DB
- users - {name: user}
- inventory - 
  - items -  {brand: {category: item}}
  - active_items: {brand: {category: (item,unit)}}
- 
# Service
- user-service
- 
- cart-service

- inventory-service
    - filter_search-builder
      - 
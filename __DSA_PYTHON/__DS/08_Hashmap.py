""" INTERNAL WORKING OF HASHMAP
Key of hashmap - can be string or int etc. by HOW?
    - ARRAY - Values are stored in Array -- but Index is find by Hash-Function
    - Hash-Function -- this is used to convernt any KEY (str, int etc) to a Hash-Code.
    - this hash-code is then used in index-calculation in array.
    - Collision - when 2 diff key has same hash-code -- in this 
        case algo look for next available slot.
    - Dynamic Resizing -- if 75% filled -- double the size.
"""

hash_map = {}

hash_map["name"] = "John"
hash_map["age"] = 25
hash_map["city"] = "Pune"

print(hash_map["city"])
del hash_map["city"]

print(hash_map["age"])
hash_map["age"] = 29

hash_map[1] = "ABC-Integer"

if "age" in hash_map:
    print(hash_map["age"])

for key, value in hash_map.items():
    print(key, ": ", value)

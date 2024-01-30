hash_map = {}

hash_map["name"] = "John"
hash_map["age"] = 25
hash_map["city"] = "Pune"

print(hash_map["city"])
del hash_map["city"]

print(hash_map["age"])
hash_map["age"] = 29

if "age" in hash_map:
    print(hash_map["age"])

for key, value in hash_map.items():
    print(key, ": ", value)

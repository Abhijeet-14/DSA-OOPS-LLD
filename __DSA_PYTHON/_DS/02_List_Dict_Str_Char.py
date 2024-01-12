print("\n========== LIST ==========")
arr_1 = []

arr_1.append(2)
arr_1.append(1)

arr_2 = [30, 20]
arr_1.extend(arr_2)
print("\tExtend => ", arr_1)

print("\tLength => ", len(arr_1))

for i in range(len(arr_2)):
    print(f"\tBy Index {i}:", arr_2[i])

print("\n========== 2D-LIST ==========")
col = 3
row = 4
arr_1 = [[0] * col] * row


print("\n========== String ==========")
string = "ab"
print("\tLength => ", len(string))
for c in string:
    print("\tBy Character: ", c)

print("\n========== Sort List ==========")
arr_2.sort()
print("\tSort List", arr_2)

print("\n========== Sort String ==========")
string = "shivam"
print("\tSorted String", sorted(string))

print("\n========== Dictonary ==========")
_dict = {"1": "Dhoni", "2": "Dravid", "3": "Sachin"}
print("\tItems: ", _dict.items())
print("\tKeys: ", _dict.keys())
print("\tValues: ", _dict.values())
for key, value in _dict.items():
    val = value


print("\n========== Set ==========")
my_set = set()
my_set.add(1)
my_set.add(2)
my_set.add(3)
my_set.add(1)
print(my_set)
my_set.remove()

print("\n========== Character To Int ==========")
char = "A"
char_to_int = ord(char)
print("\tChar To Int: ", char_to_int)

print("\n========== Int to Character ==========")
int_to_char = chr(97)
print("\tInt to Char: ", int_to_char)

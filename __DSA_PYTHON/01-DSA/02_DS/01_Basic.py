print("=====List=====")
# for Loop
arr_1 = [1, 2, 3, 4]
for val in arr_1:
    val = val * 10
print(arr_1)

print("List Repetation: ", arr_1 * 2)


# Copy List and mutated
arr_2 = [val * val for val in arr_1]
print("Copy List & Mutated: ", arr_2)

arr_2.sort(key=lambda x: x["age"])
# Concatenation array
arr_3 = arr_2 + arr_1
print("Concatenation List: ", arr_3)


print("\n=====Tuple=====")
tup = (0, 1, 2)
print(tup, tup[2])

print("\n=====Divide=====")
print("Float: ", 7 / 2)
print("Int: ", 7 // 2)

print("\n=====While=====")
a = 2
while a > 0:
    print(a)
    a -= 1

print("\n=====Reverse List=====")
print(list(reversed(arr_1)))

print("\n=====Sum List=====")
print(sum(arr_1))

print("\n=====MAP=====")
arr_4 = list(map(lambda val: val * 10, arr_1))
print(arr_4)

print("\n=====ROUND=====")
print(round(7 / 2))

print("\n=====INFINITE=====")
min_int = float("-inf")
print(3 > min_int)

max_int = float("inf")
print(2 > max_int)

print("\n=====JOIN=====")
words = ["ABC", "DEF", "GHI"]
joined_string = "-> ".join(words)
print(joined_string)

print(5 // 2, 5 / 2, 5 % 2)
print("\n===== GCD (Greatest Common Divisor) =====")


def gcd(a, b):
    if b == 0:
        return a
    print(a % b)
    return gcd(b, a % b)


print(gcd(16, 72))

print("\n=====ABSOLUTE=====")
negative_number = -10
absolute_value = abs(negative_number)
print(absolute_value)


print("\n=====SQUARE=====")
x = 2
print(x**2)


# Sort Array with custom function
def custom_function(item):
    return item[1]

data = [('apple', 3), ('banana', 1), ('cherry', 2)]
data.sort(key=custom_function)
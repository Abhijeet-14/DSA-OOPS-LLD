# abs(), map(), bool(), sum(), reversed(), round(), isinstance(), min
print(max(1,2))
print(min(1,2))

print(float('inf')) # Integer MAX
print(float('-inf')) # integer Min


print(max(2, float('-inf')))
print(min(2, float('-inf')))


# Example using round to round a floating-point number
floating_number = 3.14159
rounded_number = round(floating_number, 2)
print(rounded_number)

# Example using reversed to reverse a list
numbers = [1, 2, 3, 4, 5]
reversed_numbers = list(reversed(numbers))
print(reversed_numbers)


# Example using sum to calculate the sum of elements in a list
numbers = [1, 2, 3, 4, 5]
total_sum = sum(numbers)
print(total_sum)


# Example using abs to get the absolute value of a number
negative_number = -10
absolute_value = abs(negative_number)
print(absolute_value)

# Example using map to square each element in a list
numbers = [1, 2, 3, 4, 5]
squared_numbers = list(map(lambda x: x**2, numbers))
print(squared_numbers)


# Example using join to concatenate elements of a list into a string
words = ["Hello", "World", "!"]
joined_string = " ".join(words)
print(joined_string)


# Example 2: Using list comprehension to square each number
numbers = [1, 2, 3, 4, 5]

# Square each number using list comprehension
squared_numbers = [x**2 for x in numbers]

print(squared_numbers)

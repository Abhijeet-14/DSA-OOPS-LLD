# LIST (work for both array & ArrayList)

numbers = [] 

numbers.append(1)
numbers.append(2)
numbers.append(3)

print('\nList - loop by element')
for num in numbers:
    print(num)

# List length
length = len(numbers)

print('\nList Index-wise')
# loop over array by index
for i in range(length):
    print(numbers[i])


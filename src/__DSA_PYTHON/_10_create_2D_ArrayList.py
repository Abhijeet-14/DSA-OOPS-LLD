# Create a 2D list
rorow = 4
col = 5

mat = [[0]*ccorowrow

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

            # Access elements in the 2D list
print(matrix[0][0])  # Output: 1
print(matrix[1][2])  # Output: 6

            # Modify elements in the 2D list
 matrix[1][1] = 99
print(matrix[1][1])  # Output: 99

            # Iterate through the 2D list
for row in matrix:
    for element in row:
      print(element, end=' ')
    print()



# Create an empty 2D list
rows = 3
cols = 3
matrix = [[0 for _ in range(cols)] for _ in range(rows)]

# Now you have a 3x3 matrix filled with zeros
print(matrix)

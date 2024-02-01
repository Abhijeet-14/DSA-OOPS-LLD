# Open a File
file = open("abc.txt", "r")

# write
file.write("HEllo Hello")

# CLosing file
file.close()

# Reading
content = file.read()

# 'with' - this ensure proper OPEN & CLOSE of file
with open("abc.txt", "r") as file:
    content = file.read()

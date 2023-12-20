# Initialize an empty list as the stack
stack = []

# Push elements onto the stack
stack.append(1)
stack.append(2)
stack.append(3)

# Peek at the top element without removing it
peeked_element = stack[-1]

# Pop an element from the stack
popped_element = stack.pop()

# Check if the stack is empty
is_empty = not bool(stack)

print("Peeked Element:", peeked_element)
print("Popped Element:", popped_element)
print("Is Stack Empty:", is_empty)

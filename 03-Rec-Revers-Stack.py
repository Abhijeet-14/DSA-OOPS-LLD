def insert(stack: list, val):
    """
    TC - O(N)
    SC - O(N), Recursion Stack -- No Extra space
    """
    # Base-Condition
    if len(stack) == 0:
        stack.append(val)
        return

    # Hypothesis
    temp = stack[-1]
    stack.pop()
    insert(stack, val)

    # Induction
    stack.append(temp)


def reverse(stack: list):
    """
    TC - O(N)*O(N) - O(N^2)
    SC - O(N), Recursion Stack -- No Extra space
    """
    # Base Condition
    if len(stack) == 1:
        return

    # Hypothesis
    temp = stack[-1]
    stack.pop()
    reverse(stack)

    # Induction
    insert(stack, temp)  # O(N)


stack = [1, 2, 3, 4, 5]
reverse(stack)
print(stack)

"""
# Dry-Run
reverse(stack: list): // ([1,2,3,4,5]) // ([1,2,3,4]) // ([1,2,3]) // ([1,2]) // ([1])
if len(stack) == 1: // F // F // F // F // T
    return

temp = stack[-1] // 5 // 4 // 3 // 2
stack.pop() // 5 // 4 // 3 // 2
reverse(stack) // ([1,2,3,4]) // ([1,2,3]) -> [3,2,1] // ([1,2]) -> [2, 1]  // ([1]) -> [1]

insert(stack, temp) // ([1], 2) // [2,1], 3

insert(stack: list, val): // ([1], 2) // ([],2) // ([2,1],3) // ([2], 3)
if len(stack) == 0: // F // T // F // F // T
    stack.append(val) // // [2] // [3]
    return

temp = stack[-1] // 1 // 1 // 2
stack.pop() // 1 // 1 // 2
insert(stack, val) // ([], 2) -> [2] // ([2],3) -> [3,2] // [], 3 -> [3] //

stack.append(temp) [2, 1] // [3, 2] // [3,2,1]
"""

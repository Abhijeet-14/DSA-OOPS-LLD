def delete_at_k(stack: list, k):
    # Base Condition
    if k == 1:
        stack.pop()
        return
    temp = stack[-1]
    stack.pop()
    delete_at_k(stack, k - 1)
    stack.append(temp)


def delete_middle_element(stack):
    if len(stack) == 0:
        return
    middle = len(stack) // 2 + 1
    print(middle)
    delete_at_k(stack, middle)
    return stack


stack = [5, 1, 0, 2, 4]
delete_middle_element(stack)
print(stack)

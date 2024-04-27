def insert(arr: list, temp, depth, dry_run=False):
    """
    TC - O(N)
    SC - O(N), Recursion Stack -- No Extra space
    """
    depth += 1
    # Base Condition
    if len(arr) == 0 or arr[-1] < temp:
        # dry_run and print(depth * "    " + "|-- insert() :: BC - True", arr, temp)
        arr.append(temp)
        return
    # dry_run and print(depth * "    " + "|-- insert() :: BC - False", arr, temp)

    # Hypotheis
    val = arr[-1]
    arr.pop()
    # dry_run and print(depth * "    " + "|-- insert() :: Hyp", arr, temp)
    insert(arr, temp, depth + 1, dry_run)

    # Induction
    # dry_run and print(depth * "    " + "|-- insert() :: Induc", arr, temp)
    arr.append(val)


def sort(arr: list, depth=0, dry_run=False):
    """
    TC - O(N)*O(N) - O(N^2)
    SC - O(N), Recursion Stack -- No Extra space
    """
    # Base Condition
    if len(arr) == 1:
        # dry_run and print(depth * "    " + "|-- sort() :: BC - True", arr)
        return
    # dry_run and print(depth * "    " + "|-- sort() :: BC - False", arr)

    # Hypotheis
    temp = arr[-1]
    arr.pop()
    # dry_run and print(depth * "    " + "|-- sort() :: Hyp", arr, temp)
    sort(arr, depth + 1, dry_run)

    # Induction
    # dry_run and print(depth * "    " + "|-- sort() :: Induc", arr, temp)
    insert(arr, temp, depth, dry_run)  # O(N)


arr = [5, 3, 4, 2]
sort(arr, dry_run=True)
print(arr)

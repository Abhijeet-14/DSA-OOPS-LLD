def double(arr, val):
    print("L2", val)

    def helper():
        for i, n in enumerate(arr):
            arr[i] *= 2

        # will only modify val in helper score
        # val *= 2

        # this will modiy val outside helper scope
        nonlocal val
        val *= 2

    helper()
    print("L14", arr, val)


nums = [1, 3]
val = 3
double(nums, val)

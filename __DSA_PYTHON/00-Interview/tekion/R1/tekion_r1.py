# unsorted list -- 2nd largest element -- arr should be take user_input
# [2,5,3,7,4,8] -- 7

# max_1 =
# max_2 =

# approach 2
# PQ - size 2 - min heap
# 2,5 -> 2,5, 3 -> 2
# 5,3 -> 3
# 7, 8 -> 7 - 2nd largest element

## logic
import heapq


def find_k_largest_element(arr, k):
    heap = []

    for element in arr:  # O(N)
        heapq.heappush(heap, element)  # O(logK)
        if len(heap) > k:
            heapq.heappop(heap)

    # print(heap)
    result = heapq.heappop(heap)
    print(result)


# input = 2 5 3 7 4 8
"""
2 5 - 5 - 2
5 3 - 5 - X
5  7 - 7
 7 4 - 7
7  8 - 8 - 7
"""

# input_data = input()
# string_arr = input_data.split(" ")
unsorted_arr = []  # O(N)
# for str_element in string_arr:
#     unsorted_arr.append(int(str_element))


# find_k_largest_element(unsorted_arr, 2)

# O(N*logK)

# input = 2 5 3 7 7 4 8 -> o/p - 5
# [256]
# 2nd largest - disinct

# [256] - O(N)
# [0]
# count++ - 1 - 2
# 10^6


# input = 2 5 3 7 7 4 8
CHAR = 256
visited = [0] * CHAR


def find_k_largest_element_2(arr, k):
    heap = []

    for element in arr:  # O(N)
        element_index = ord(f"{element}")
        if visited[element_index] > 1:
            continue

        heapq.heappush(heap, element)  # O(logK)
        if len(heap) > k:
            heapq.heappop(heap)

    # print(heap)
    result = heapq.heappop(heap)
    print(result)


for element in unsorted_arr:
    element_index = ord(f"{element}")
    if visited[element_index] == 0:
        visited[element_index] = 1
    else:
        visited[element_index] += 1

find_k_largest_element_2(unsorted_arr, 2)

# O(N*LogK)

# 0 - 100 -- 89 missing
# unsorted_array = []

# visited [T/F] - available - T -- False
# runs - index - F

# 2 loop - O(N)

# element - -10^6< >10^6
arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 10]

N = len(arr)

# coorect_arr - [0, 1--10]
# elment correct_arr -- element in arr ->

# element in arr -- binary_search - O(LogN)
# hashmap - O(1)
# O(N)

# N = 90
# [11]
# # correct_arr - 0-10
# -5 + 5
# correc_arr = 0 - 10


"{([])}"  # - valid - correct order
# invalid - "{[}]"
# invalid - "{[}"

# stack - open value { ( [

input_data = "{([)}"

stack = []

for bracket in input_data:
    print(bracket)

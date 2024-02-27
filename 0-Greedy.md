# Greedy

1. https://leetcode.com/discuss/general-discussion/1061059/ABCs-of-Greedy


# ChatGPT CODE
Greedy algorithms make locally optimal choices at each stage with the hope of finding a global optimum. Below are examples of greedy algorithms implemented in Python:

1. Activity Selection Problem:
Problem: Given a set of activities with start and finish times, the objective is to select the maximum number of non-overlapping activities.

python
Copy code
def activity_selection(activities):
    activities.sort(key=lambda x: x[1])  # Sort by finish time
    selected_activities = [activities[0]]
    
    for i in range(1, len(activities)):
        if activities[i][0] >= selected_activities[-1][1]:
            selected_activities.append(activities[i])
    
    return selected_activities

# Example usage:
activities = [(1, 2), (3, 4), (0, 6), (5, 7), (8, 9)]
result = activity_selection(activities)
print(result)
2. Fractional Knapsack Problem:
Problem: Given weights and values of items, determine the maximum value that can be obtained by selecting fractions of items.

python
Copy code
def fractional_knapsack(items, capacity):
    items.sort(key=lambda x: x[1] / x[0], reverse=True)  # Sort by value per weight
    total_value = 0
    knapsack = []

    for weight, value in items:
        if capacity == 0:
            break
        amount = min(weight, capacity)
        total_value += amount * (value / weight)
        knapsack.append((amount, value))
        capacity -= amount
    
    return total_value, knapsack

# Example usage:
items = [(10, 60), (20, 100), (30, 120)]
capacity = 50
result = fractional_knapsack(items, capacity)
print(result)
3. Huffman Coding:
Problem: Given a set of characters and their frequencies, construct a binary tree using a greedy algorithm for Huffman coding.

python
Copy code
import heapq
from collections import defaultdict

def huffman_coding(freq):
    heap = [[weight, [char, ""]] for char, weight in freq.items()]
    heapq.heapify(heap)
    
    while len(heap) > 1:
        lo = heapq.heappop(heap)
        hi = heapq.heappop(heap)
        for pair in lo[1:]:
            pair[1] = '0' + pair[1]
        for pair in hi[1:]:
            pair[1] = '1' + pair[1]
        heapq.heappush(heap, [lo[0] + hi[0]] + lo[1:] + hi[1:])
    
    return heap[0][1:]

# Example usage:
frequency = defaultdict(int)
for char in "ABRACADABRA":
    frequency[char] += 1

huffman_code = huffman_coding(frequency)
print(huffman_code)
These are just a few examples of greedy algorithms in Python. Greedy algorithms are often used for optimization problems where making the locally optimal choice at each stage leads to a globally optimal solution.





# ChatGPT QUESTION
Certainly! Here are some classic greedy problems from LeetCode along with their expectations, time complexity, and space complexity:

1. Assign Cookies
Problem: Assume you are an awesome parent and want to give your children some cookies. Each child i has a greed factor g[i], and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.

Expectation: Return the maximum number of content children.
Time Complexity: O(NlogN), where N is the number of children or cookies.
Space Complexity: O(1).
2. Jump Game
Problem: Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position.

Expectation: Determine if you can reach the last index.
Time Complexity: O(N), where N is the length of the array.
Space Complexity: O(1).
3. Best Time to Buy and Sell Stock II
Problem: Say you have an array prices for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit. You may complete as many transactions as you like (buy one and sell one share of the stock multiple times).

Expectation: Return the maximum profit.
Time Complexity: O(N), where N is the length of the array.
Space Complexity: O(1).
4. Greedy Florist
Problem: You and your K friends want to buy N flowers. Each flower i has a price p[i]. You can buy the flowers in any order, but each flower you buy increases the price that you have to pay for each of the previously purchased flowers by (previous_purchases + 1).

Expectation: Return the minimum cost to purchase all the flowers.
Time Complexity: O(NlogN), where N is the number of flowers.
Space Complexity: O(1).
5. Gas Station
Problem: There are N gas stations along a circular route, where the amount of gas at the ith station is gas[i]. You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i+1)th station. You begin the journey with an empty tank at one of the gas stations.

Expectation: Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Time Complexity: O(N), where N is the number of gas stations.
Space Complexity: O(1).
6. Meeting Rooms II
Problem: Given an array of meeting time intervals intervals where intervals[i] = [start_i, end_i], return the minimum number of conference rooms required.

Expectation: Return the minimum number of conference rooms.
Time Complexity: O(NlogN), where N is the number of intervals.
Space Complexity: O(N).
7. Candy
Problem: There are n children standing in a line. Each child must be assigned a rating. You are given an integer array ratings, where ratings[i] is the rating of the ith child. Once you have assigned the ratings, each child must have at least one candy.

Expectation: Return the minimum number of candies you must give.
Time Complexity: O(N), where N is the number of children.
Space Complexity: O(N).
These are just a few examples of greedy problems on LeetCode. Greedy algorithms are often used when a locally optimal solution leads to a globally optimal solution. As always, the actual complexities may vary based on specific implementations.

User
more
ChatGPT
Certainly! Here are a few more greedy problems from LeetCode:

8. Minimum Number of Arrows to Burst Balloons
Problem: There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

Expectation: Return the minimum number of arrows that must be shot to burst all balloons.
Time Complexity: O(NlogN), where N is the number of balloons.
Space Complexity: O(1).
9. Queue Reconstruction by Height
Problem: You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Expectation: Reconstruct and return the queue that is represented by the input array people.
Time Complexity: O(N^2), where N is the number of people.
Space Complexity: O(N).
10. Maximum Ice Cream Bars
Problem: It is a sweltering summer day, and a boy wants to buy some ice cream bars. At the store, there are n ice cream bars. Each bar i has an associated cost, cost[i], and the boy has an initial sum of money coins.

Expectation: Return the maximum number of ice cream bars the boy can buy with coins.
Time Complexity: O(NlogN), where N is the number of ice cream bars.
Space Complexity: O(1).
11. Best Time to Buy and Sell Stock IV
Problem: You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k representing the maximum number of transactions you can make. Find the maximum profit you can achieve.

Expectation: Return the maximum profit.
Time Complexity: O(N * K), where N is the number of days and K is the maximum number of transactions.
Space Complexity: O(K).
12. Jump Game III
Problem: Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at an index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Expectation: Return true if you can reach a 0, false otherwise.
Time Complexity: O(N), where N is the length of the array.
Space Complexity: O(N).
13. Can Place Flowers
Problem: You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Expectation: Return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
Time Complexity: O(N), where N is the length of the flowerbed.
Space Complexity: O(1).
14. Minimum Cost to Move Chips to The Same Position
Problem: We have n chips, where the position of the ith chip is position[i].

Expectation: Find the minimum cost needed to move all the chips to the same position. The cost is the sum of the absolute differences between the position of the ith chip and the position 0.
Time Complexity: O(N), where N is the number of chips.
Space Complexity: O(1).
These additional greedy problems cover a variety of scenarios, from intervals and queues to stock trading and array manipulation. Actual complexities may vary based on specific implementations.

User
more
ChatGPT
Certainly! Here are a few more greedy problems from LeetCode:

15. Meeting Rooms
Problem: Given an array of meeting time intervals intervals where intervals[i] = [start_i, end_i], determine if a person could attend all meetings.

Expectation: Return true if no two meetings overlap, false otherwise.
Time Complexity: O(NlogN), where N is the number of intervals.
Space Complexity: O(1).
16. Non-overlapping Intervals
Problem: Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Expectation: Return the minimum number of intervals to remove.
Time Complexity: O(NlogN), where N is the number of intervals.
Space Complexity: O(1).
17. Partition Labels
Problem: A string s consists of lowercase English letters. A partition is a substring of s in which every letter appears at most once. Find a list of starting indices of partition labels.

Expectation: Return a list of starting indices.
Time Complexity: O(N), where N is the length of the input string.
Space Complexity: O(1).
18. Lemonade Change
Problem: At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you, and each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Expectation: Return true if you can provide change to every customer, false otherwise.
Time Complexity: O(N), where N is the number of customers.
Space Complexity: O(1).
19. Maximize Sum Of Array After K Negations
Problem: Given an array nums of integers, you can perform operations on the array. In each operation, you pick any element in the array and change it to any value.

Expectation: Return the maximum sum of the array after performing at most K operations.
Time Complexity: O(NlogN), where N is the length of the array.
Space Complexity: O(1).
20. Queue Reconstruction by Height
Problem: You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Expectation: Reconstruct and return the queue that is represented by the input array people.
Time Complexity: O(N^2), where N is the number of people.
Space Complexity: O(N).
21. Is Subsequence
Problem: Given two strings s and t, check if s is a subsequence of t.

Expectation: Return true if s is a subsequence of t, false otherwise.
Time Complexity: O(N), where N is the length of t.
Space Complexity: O(1).
These additional greedy problems cover a variety of scenarios, from intervals and arrays to string manipulation and queue reconstruction. Actual complexities may vary based on specific implementations.
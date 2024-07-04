# Google Onsite Question
1. Given the water capacity for each of n unmarked buckets in the form of an array, find all the ways a target quantity of water can be measured. Eg, buckets = [3,5] Target = 4. Output : (+5,+5,-3,-3), (+3,+3,+3-5) etc..
    > Leetcode: [https://leetcode.com/problems/water-and-jug-problem/]

2. a
    > Leetcode: []

3. Given 2 images as a 2d matrix of size MN And KN. Find maximum overlapping part i. maximum bottom rows of first matrix which matches with the top rows of the second matrix
    - Eg. Matrix 1: 
        [1,2,3,4]
        [3,4,2,5]
        [1,2,4,1]

    - Matrix 2:
        [3,4,2,5]
        [1,2,4,1]
        [1,5,7,8]
        [7,5,7,3]

    In above example answer is 2
    > Leetcode: [https://leetcode.com/problems/maximum-length-of-repeated-subarray/]

4. It was similar to merge intervals [https://leetcode.com/problems/merge-intervals/] but with a bit modification.
    - Given Starting intervals we'll get 2 type of queries

        - Add intervals
        - Search for a particular number
    - eg:
        Given initial intervals as : [[1,3],[2,6],[8,10],[15,18]]
    - Q queries
        - [1 4 5] => 1 represent query of type 1 and 4-5 is interval
        - [2 2] => 2 represent query of type 2 search for element 2

5. This was the exactly similar to [https://leetcode.com/problems/shortest-distance-from-all-buildings/] with a slight modification.

6. Behavioural Round
    - I was asked basic questions related to my work and my experience

7. Some cars, road weird question. 
    - You are given starting state of cars. something like R _ _ L. Now, this example has 4 lanes. R means this car has put the indicator on to move R, this car can only move right or stay where it wants to be. and the car blimking L can chose to stay there or move left only. but cars can't collide. You are given a end state and you have to tell if that state is possible. Initially I thought it is a word ladder question but that was not the case. Then I thought may be if I assign a unique Id to a car say 1, 2, 3 and so on. the right car can only move right so the value will get smaller and the left car can only go towards most significant bit so some kind of number comparison. I don't know the right answer though. one more example can _ R can not have R _ as the final state.

    > Leetcode: [https://leetcode.com/problems/count-collisions-on-a-road/description/]
    > Leetcode: [https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/]


8. check if you can insert an interval. Started with Binary search on sorted list end up on a search in a BST traversal because handling of mid conditions in the sorted list was getting way to complex at that time. The interviewer allowed me to assume the input in whatever format(just state the assumptions). Follow up qs : what if the given list of schedule in all in the range of 1 .. 100. No need of any fancy data structure just use an array.. arr[i..j] = 1 will represent some interval k's start to end. to check if you can insert just check if you there is any 1 in arr[incoming.start... incoming.end]
    > Leetcode: [https://leetcode.com/problems/word-ladder/]
9. Basically word ladder problem. With time + space complexity. The interviewer asked why did you chose bfs over dfs. I said because as of now you haven't mentioned any minimum step constraint but If I have to extend the problem to find the end state in minimum step then bfs is a better option in any case.
    > Leetcode: [https://leetcode.com/problems/word-ladder/]
10. Robot clean up problem. Another bfs/dfs traversal problem with time and space complexity discussion.
    > Leetcode: [https://leetcode.com/problems/robot-room-cleaner/]

11. goolyness - Again cook up stories, let's talk kinda interview. 80 percent of the questions were around unethical behaviour that someone was unethical, you were unethical.

12. [https://leetcode.com/problems/race-car/]
13. [https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/]
14. [https://leetcode.com/problems/maximum-number-of-visible-points/]

15. Let us say that there is a home and a saloon that you want to visit. You have a routes built in across. You need to check that if there is a route that exists that lets you visit the saloon.
    - For example: Here you have H which denotes your home and R is your route and S is your saloon.
        - H R R .
        - R . R .
        - . . R .
        - . . S .
    - I applied DFS and was able to solve this question.

    - Now there was a follow up to this question: 
        - Let us consider that at first there was no route between both of them. And slowly a route starts developing. How will you be able to check that out?
        - For example:
            - First:
                - H . . .
                - . . . .
                - . . S.

                - Second:
                    - H . . .
                    - . R . .
                    - . . S .

                - Third:
                    - H . . R
                    - . R . .
                    - . . S .

                - Fourth:
                    - H . . R
                    - R R . .
                    - . . S .
                - and so on.
    - I tried a lot on this with different ways but I was not able to reduce its complexity down and my best complexity solution turned out to be naive one. Not able to optimise this was the reason why I got rejected later :(
    - Any idea how else could this have been solved?
    >  Leetcode: [https://leetcode.com/problems/number-of-islands-ii/]
    >  Leetcode: [https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems]
    > DSU

16. Given an index and an input string find the char at the given index of the string. But here's the catch: if the index exceeds the length of the string, then you transform the string by removing the string's last character and appending it to the front and appending this transformed string to the original string until you have a string length that exceeds the desired index.

    - For example,
    - if we have a string "abcd" and want to find the char at index 3 it would obviously be 'd'. However, if we want to find the char at index 7 of "abcd" we would transform "abcd" to "abcddabc" and the char would be 'c'. If we want to find the char at index 12 of "abcd" we would transform "abcd" to "abcddabc" and then again transform to "abcddabccabcddab" and the char would be 'd.

    - I was only able to code it the brute force way but a O(logn) solution exist

    > Source: [https://leetcode.com/discuss/interview-question/1918329/Google-Onsite-Question]

17. Given a matrix of size n*m, where each position is representing a city. Initially all city are represented by zero. ( means they are not traversible ). On each day one city will randomly become traversible. ( matrix[i][j] = 1 ). Write an algorithm that can detect when there is a path from any city of first column to any city of last column.

    - My Approach -

        - on each day
            - mark that city as traversible.
            - start dfs from all city of first column and check if we can reach last column.
    - Time Compl - O((mn)^2).
    - O(mn) for each DFS and in worst case path will be found when each city is marked as traversible.

    - Is there a better way to solve this problem, tried solving it using union find but could not find more optimal solution. Please help

    > Source: [https://leetcode.com/discuss/interview-question/2117543/Google-Onsite]
    > Leetcode: [https://leetcode.com/problems/number-of-islands-ii/]
    > Video: [https://youtu.be/Rn6B-Q4SNyA?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn]

20. Source: [https://leetcode.com/discuss/interview-question/1481051/Google-Onsite]

21. Given a sorted n-size array, there are k elements have been changed i.e. [1, 3, 5, 6, 4, 2, 12] (it might be changed from [1, 3, 5, 6, 7, 8, 12] with k = 2). Important to know is that k is unknown and k is much smaller than n. The task is to re-sort the entire array.
    - The interviewer wants O(n) solution. I bombed this one. In the end, the interviewer kind of fed the solution to me. What he suggested: a. break the array into two: one sorted array and one unsorted array e.g. [1, 3, 5, 12] and [6, 4, 2]. This takes O(n) b. Sort the unsorted array. This takes O(klogk) c. Merge two sorted arrays. This takes O(n). Because k is very small, so in the end O(n) + O(klogk) ~= O(n).
    - Does this solution make sense to you ? In O(n) how can we split array into sorted and unsorted with unsorted arry being of size k?

    - Source: [https://leetcode.com/discuss/interview-question/1250654/google-onsite]

22. Train Depart Greedy.
    > Source: [https://leetcode.com/discuss/interview-question/1533097/Google-Onsite-L4]

23. Source: [https://leetcode.com/discuss/interview-question/1504849/Google-Onsite]
    > Leetcode: [https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/]

24. Source: [https://leetcode.com/discuss/interview-question/1524937/Google-onsite]
    1. Random music shuffle question. Given a list of songs and a skip order like songs = [A,B,C,D], skipOrder = 2. If a song is played once, it cannot be back in the shuffling list till skipOrder is done. Ex: If A is played first and then A cannot be back in the list until next 2 iterations.
        - Similar source: [https://leetcode.com/discuss/interview-question/2337984/]

    2. Given chat logs, find the user who sent the highest number of words.
    
    3. A matrix question - Given a matrix that consists of two towns and water heights at the specific index, find the index where you can construct a dam which has highest height and the water can flow through two towns. Ex: [[1,2,3,5], [1,5,0,2],[6,0,2,1],[6,7,3,2]] - lets say indices with 0 values are the two towns. Now, we have to find the index(highest value) where we can construct the dam so that the water flows to both towns and the water can flow to the index index when the water level is low in the next index. (More like the pacific atlantic flow question)
        > Leetcode: [https://leetcode.com/problems/pacific-atlantic-water-flow/]

    4. Give an array [1,2,3]
        - Easy - double the numbers in the list and add it back to the list and return a permutation of the list. => [1,2,3,2,4,6]
        - Medium - now given the permutated list, find the original list. [1,2,2,6,4,3] => [1,2,3]
            > Leetcode: [https://leetcode.com/problems/find-original-array-from-doubled-array/]

25. Given an arr, count the number of ordered pairs such that a[i] - a[j] = i - j . ( 0 <= i, j,< n )

    - example : 
        - [ 2 4 6 5 9 9 11 ]   count = 13
        - [ 2 2 2 ]            count = 9


    - Few clarifications :
        - pairs (i,j) and (j,i) are considered different.
        - pairs(i,i) are also considered to be in ans.

    - Explanation for second test case:
        - for 2 at i=0, num of pairs that could be made are 3 ( 1 with itself and 2 with other )
        - for 2 at i=1,2 same happens and count = 3, hence total count = 9

        - Note pair (2,2) at i=0, 1 is not considered same as pair (2,2) at i=1, 0
        
26. Q1) For a given array return an array where corresponding to each index we have number of elements smaller than the value at that index and that have less index than it. Expected time complexity : less than O(n^2)
    > Leetcode: [https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/]

    - Q2) For a given string A and an array of strings B return an array of valid strings from the array. String is valid if it is the subsequence of A. (try for complexity less than n*m where n is size of A and m size of B)
        > Leetcode: [https://leetcode.com/problems/number-of-matching-subsequences/description/]
    > Source - [https://leetcode.com/discuss/interview-question/3849141/Google-Onsite]
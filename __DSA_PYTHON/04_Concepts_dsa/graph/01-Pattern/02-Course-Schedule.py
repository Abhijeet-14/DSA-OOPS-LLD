"""
Q: [https://leetcode.com/problems/course-schedule/description/]

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example: 
    Input: 
        numCourses = 2, 
        prerequisites = [[1,0]]
    Output: true

Example:
    Input: 
        numCourses = 2, 
        prerequisites = [[1,0],[0,1]]
    Output: false

Constraints:
    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.
"""

"""
Solution:
    - for 1 -> 0 needs to be finnished
    - bi-directional graph
    - apply dfs
    - check any val not in visited
Edge Case:
    - ??

WRONG WRONG --
"""

"""
NeetCode:
Ex 1
    - [1, 0] -> to solve 1 -> first solve 0
    - that mean ... 1 --> 0
    - we try 0 first -- there is no pre-requisite of 0 
    - so one can be solved

Ex 2:
    - [1, 0], [0, 1]
    - to solve 1, solve 0 first
    - 1 ---> 0
    - to solve 0, solve 1 first
    - 0 ----> 1
    - so cycle  1---> 0 ---> 1 ---> 0 .....
    - IMPOSSIBLE

Ex 3:    
    - [0, 1], [0, 2], [1,3], [1,4], [3,4]
    - [0, 1]
        - 0 ---> 1
    - [0, 2]
        - 0 ---> 2
    - [1, 3]
        - 1 --> 3
    - [1, 4]
        - 1 ---> 4
    - [3, 4]
        - 3 --> 4
    - So, we can say
        - 0 ---> [1, 2]
        - 1 ---> [3, 4]
        - 2 ---> []
        - 3 ---> [4]
        - 4 ---> []
    - no cycle -- possible

Ex 4:
    - [0, 1], [1, 2], [2, 0]
    - 0 --> 1
    - 1 --> 2
    - 2 --> 1
    - so cycle -- 

So, How to find Cycle??
- visited - set
- we will say a node visited -- if all its depended are solved.
- 

So first create Directed Graph
and then apply DFS in graph 0 - N-1.
and find cycle --> NOT --> True

"""


class CourseSchedule1:
    def can_finish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        """O(V+E)"""
        # prerequisites - Edges
        # numCourses - Node
        list_of_courses = range(numCourses)
        graph = {i: [] for i in list_of_courses}  # O(N)

        for node_1, node_2 in prerequisites:  # O(E)
            graph[node_1].append(node_2)

        visited = set()
        recursion_stack = set()
        for course in list_of_courses:  # O(N)
            # if node visited - no need to call it twice.
            if course not in visited and self.dfs_detect_cycle(
                graph, visited, recursion_stack, course
            ):  # O(N+E)
                return False
        return True

    def dfs_detect_cycle(
        self, graph: dict, visited: set, recursion_stack: set, source: int
    ) -> bool:

        parent = graph.get(source, [])

        visited.add(source)
        recursion_stack.add(source)

        # O(N)
        for child in parent:  # O(E)
            if child not in visited:
                if self.dfs_detect_cycle(graph, visited, recursion_stack, child):
                    return True
            elif child in recursion_stack:
                return True

        recursion_stack.remove(source)
        return False


course_schedule_1 = CourseSchedule1()

num_courses_1 = 2
prerequisites_1 = [[0, 1]]

num_courses_2 = 2
prerequisites_2 = [[0, 1], [1, 0]]

num_courses_3 = 5
prerequisites_3 = [[1, 4], [2, 4], [3, 1], [3, 2]]

result = course_schedule_1.can_finish(num_courses_3, prerequisites_3)
print(result)


"""
# Basically, its a Directed-Cyclic-Graph Problem
"""

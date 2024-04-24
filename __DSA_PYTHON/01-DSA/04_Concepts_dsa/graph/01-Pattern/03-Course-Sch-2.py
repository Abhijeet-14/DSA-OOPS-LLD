class Solution:
    def findOrder(self, numCourses: int, prerequisites: list[list[int]]) -> list[int]:
        """O(V+E)"""
        list_of_courses = range(numCourses)
        graph = {i: [] for i in list_of_courses}

        for node_1, node_2 in prerequisites:
            graph[node_1].append(node_2)

        visited = set()
        recursion_stack = set()
        result = []
        for course in list_of_courses:
            if course not in visited and self.dfs_detect_cycle(
                graph, visited, recursion_stack, result, course
            ):
                return []
        return result

    def dfs_detect_cycle(
        self,
        graph: dict,
        visited: set,
        recursion_stack: set,
        result: list[int],
        source: int,
    ):
        parent = graph.get(source, [])

        visited.add(source)
        recursion_stack.add(source)

        for child in parent:
            if child not in visited:
                if self.dfs_detect_cycle(
                    graph, visited, recursion_stack, result, child
                ):
                    return True
            elif child in recursion_stack:
                return True

        recursion_stack.remove(source)
        result.append(source)
        return False


"""
# its a Directed-Cyclic-Graph Problem & Topological Problem.
"""

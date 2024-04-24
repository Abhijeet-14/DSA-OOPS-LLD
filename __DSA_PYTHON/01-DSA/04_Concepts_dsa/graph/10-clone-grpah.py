"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:
        copied_node = {} # why dict? - bcoz if node already visited, need to return copy of that node.
        copy = None
        def dfs(node):
            if not node:
                return None

            if node in copied_node: # return copied node for already copy node.
                return copied_node[node]

            copy = Node(node.val)

            copied_node[node] = copy

            for child in node.neighbors:
                
                copy.neighbors.append(dfs(child))

            print(copy.val,  [ch.val for ch in copy.neighbors])
            return copy
        
        copy1 = dfs(node)

        print(copy1 == node)
        return copy1

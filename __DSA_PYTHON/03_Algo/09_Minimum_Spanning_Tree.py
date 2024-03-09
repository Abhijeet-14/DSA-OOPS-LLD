"""
Minimum Spanning Tree - a undirected graph, it span all the vertex of graph -- has minimum possible total edge weight.

# HAR QUESTION
"""

GRAPH = {}


class Node:
    def __init__(self, to, wt):
        self.to = to
        self.wt = wt


GRAPH[0] = Node(1, 10)
GRAPH[0] = Node(2, 6)
GRAPH[0] = Node(3, 5)
GRAPH[1] = Node(3, 15)
GRAPH[2] = Node(3, 4)

# def minimum_spaning_tree(GRAPH):


# HAR QUESTION

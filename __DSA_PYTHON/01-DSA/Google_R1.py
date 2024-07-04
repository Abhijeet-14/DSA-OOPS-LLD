# """
# Onsite Question:
# Given a DOM tree structure for html: <span>This <b>is some exple</b> keep note<span>
# - write a function to search word in DOM tree and return matching nodes.
# - matching part should be consecutive
# - if found multiple place, return 1st occurence

# "Ballon" -- []
# "hi" -- node 4
# "his is some"  -- [node 4, node 5]
# "is" - [node4]

# Node is defined below
# """


# class Node:
#     def __init__(self, is_text, text="", children=None, parent=None, name=None):
#         self.is_text_ = is_text
#         self.text = text
#         self.children = children if children is not None else []
#         self.parent = parent
#         self.name = name

#     def get_text(self):
#         return self.text

#     def get_children(self):
#         return self.children

#     def get_parent(self):
#         return self.parent

#     def is_text(self):
#         return self.is_text_

#     def __str__(self):
#         return self.name


# def search_word_in_dom(root, word):
#     result = []

#     def match(w, s):
#         i = 0
#         j = 0
#         n, m = len(w), len(s)
#         while i < n and j < m:
#             if w[i] == s[j]:
#                 i += 1
#                 j += 1
#             else:
#                 i += 1
#         return j

#     def dfs(node: Node, res: list[Node], node_no):
#         nonlocal word, result
#         if node == None:
#             return

#         i = 0
#         if result and result[-1].get_parent() != node.get_parent():
#             return

#         if node.is_text():
#             text = node.get_text()
#             jdx = match(text, word)
#             if jdx != 0:
#                 i = jdx
#                 result += res + [node]
#         word = word[i:]
#         for ch in node.get_children():
#             dfs(ch, res, node_no + 1)

#     dfs(root, [], 0)
#     return result


# node5 = Node(True, "is some exple", name="node5", parent="node3")
# node6 = Node(True, " keep note", name="node6", parent="node3")
# node4 = Node(True, "This ", name="node4", parent="node3")

# node3 = Node(False, children=[node4, node5, node6], name="node3", parent="html_root")

# html_root = Node(False, children=[node3], name="html_root", parent=None)

# # Example usage
# word_to_search = "his is some"
# # word_to_search = "his random"
# search_result = search_word_in_dom(html_root, word_to_search)
# print(f'Search result for "{word_to_search}": {[ r.__str__() for r in search_result]}')


arr = [1, 2, 3, 4, 5, 6]
k = 6
heap = []
import heapq


class Node:
    def __init__(self, val, count):
        self.val = val
        self.count = count

    def __lt__(self, other):
        return self.count < other.count

    def __str__(self):
        return f"{self.val}-{self.count}"


def play():
    if len(heap) == 0:
        for v in arr:
            heapq.heappush(heap, Node(v, 0))

    least = heap[0]
    ans = None
    if least.count != 0:
        for a in heap:
            a.count -= 1
            if a.count < 0:
                a.count = 0
        ans = Node(-1, -1)
    else:
        for a in heap:
            a.count -= 1
            if a.count < 0:
                a.count = 0
        heapq.heappop(heap)
        least.count = k
        heapq.heappush(heap, least)
        ans = least
    return ans


i = 0
while i < 20:
    print([f"{v}" for v in heap], end=" => ")
    res = play()
    print(res.val)
    i += 1


arr = [2, 4, 6, 5, 9, 9, 11]
def run(arr):
    N = len(arr)
    cnt = 0
    for i in range(N): # o(N^2)
        for j in range(N):
            if arr[i] - arr[j] == i-j:
                cnt+=1
    print(cnt)
run(arr)
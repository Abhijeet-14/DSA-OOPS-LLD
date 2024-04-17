# Question:
# A -- importing B, C
# B -- D E F
# C - E F
# F - D

# seq - which package resolve first
# re structure -- if cycle --> 
# base package -- D -> F -> E -> C -> B -> A

# A - B C

# A -- B -- D  -- 
# DFS - store node -- sequence
# another DFS -- find the cycle

# B - E
# C - E
# A - B, C
# E & F

# No cycle

# Sq - D - E  F
# D - F E
# B & C

# DFS -> once child cover ->  store node (Seq)

# [D, E, F, B, C, A]
# dfs(A)
    # dfs(B)
        # D E F
            # D
    # add B
    # dfs(C)
        # E F
        # add C
# add A

# O(V+E)
# O(V)

visited = set()
sequence = []

# A -- importing B, C
# B -- D E F
# C - E F
# F - D

graph = {
    0 : [1, 2],
    1 : [4, 5, 6], # [6,5,4] # [4]
    2 : [5, 6],
    6 : [4],
    4 : [0]
}

# 0 -> 1 -> 4 -> 0 
        # 5 
        # 6
    # 2 -> 5, 6


recurstion_stack = []

def dfs(source):
    visited.add(source)
    child_list = graph.get(source, [])

    recurstion_stack.append(source)    

    for child in child_list:
        if child not in visited:
            dfs(child)

        # elif child in recurstion_stack: # cycle
        #     # find cycle - source, child - remov child from source
        #     graph[source].remove(child) # 4 6 -- 1 - [4,5,6]
            # store it
            # remove it
            # break - stroe


    recurstion_stack.remove(source)    
    sequence.append(source)


dfs(0)
print(sequence)

# BFS - directed - 1 - 5
# 1 - [] - remove 5
# 0 - {1,2}
# 1 - {5}
# 2 - {1}
# 5 - {2}

# depency 2-1 -- 

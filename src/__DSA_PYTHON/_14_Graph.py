# Representing an undirected graph using an adjacency list

graph = {}

def add_edge(node1, node2):
    if node1 in graph:
        graph[node1].append(node2)
    
    else:
         graph[node1] = [node2]

    # bidirectional 
    if node2 in graph:
        graph[node2].append(node1)
     else:
         graph[node2] = [node1]

def print_graph():
     for node in graph:
         print(f"{node}: {', '.join(map(str, graph[node]))}")

 # Example usage
add_edge(1, 2)
     add_edge(1, 3)
   add_edge(2, 3)
      add_edge(3, 4)

  print_graph()

def create_node(data, next_node=None):
        return {'data': data, 'next': next_node}

 def print_linked_list(head):
     current = head
      while current:
              print(current['data'], end=" -> ")
             current = current['next']
               print("None")

                 # Example usage:
  node3 = create_node(3)
  node2 = create_node(2, node3)
node1 = create_node(1, node2)

  print_linked_list(node1)

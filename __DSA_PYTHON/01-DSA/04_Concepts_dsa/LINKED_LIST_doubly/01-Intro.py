# null <- 10 <-> 20 <-> 30 -> null 

class Node:
    def __init__(self, data, prev=None, next=None) -> None:
        self.data =data
        self.next =next
        self.prev =prev

## Example - Browsing History


"""
# Advantage - Single vs Double
    - ex - Browsing history
    - travel both direction
    - if given node pointer
        - can delete in O(1)
        - can insert at O(1)
    - can delete head & tail -- O(1)
# Disadv
    - Extra space
    - complex code
"""
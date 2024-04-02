from typing import Dict, List, Callable

# from models import Node, Request
class Node:
    def __init__(self, id: str, ip_address: str, weight: int = 1):
        self.id = id
        self.weight = weight
        self.ip_address = ip_address

    def get_id(self) -> str:
        return self.id

    def get_weight(self) -> int:
        return self.weight

    def get_ip_address(self) -> str:
        return self.ip_address

    def __eq__(self, other: object) -> bool:
        if not isinstance(other, Node):
            return False
        return self.id == other.id

    def __hash__(self) -> int:
        return hash(self.id)

class Request:
    def __init__(self, id: str, service_id: str, method: str):
        self.id = id
        self.service_id = service_id
        self.method = method

    def get_id(self) -> str:
        return self.id

    def get_service_id(self) -> str:
        return self.service_id

    def get_method(self) -> str:
        return self.method


from collections import defaultdict
from bisect import bisect_right

class ConsistentHashing:
    def __init__(self, hash_function: Callable[[str], int], point_multiplier: int):
        if point_multiplier == 0:
            raise ValueError("pointMultiplier must be greater than 0")
        self.point_multiplier = point_multiplier
        self.hash_function = hash_function
        self.node_positions: Dict[Node, List[int]] = defaultdict(list)
        self.node_mappings: List[Tuple[int, Node]] = []
        
    def add_node(self, node: Node):
        for i in range(self.point_multiplier):
            for j in range(node.get_weight()):
                point = self.hash_function(str(i * self.point_multiplier + j) + node.get_id())
                self.node_positions[node].append(point)
                self.node_mappings.append((point, node))
        self.node_mappings.sort(key=lambda x: x[0])
        
    def remove_node(self, node: Node):
        for point in self.node_positions.pop(node):
            index = bisect_right(self.node_mappings, (point, node))
            self.node_mappings.pop(index)
        
    def get_assigned_node(self, request: Request) -> Node:
        key = self.hash_function(request.get_id())
        index = bisect_right([point[0] for point in self.node_mappings], key)
        if index == len(self.node_mappings):
            return self.node_mappings[0][1]
        return self.node_mappings[index][1]


print("===================")
# Create sample hash function
def sample_hash_function(key: str) -> int:
    # This is a simple hash function for demonstration purposes
    return sum(ord(char) for char in key) % 1000  # Modulo 1000 for simplicity

# Create an instance of ConsistentHashing
consistent_hashing = ConsistentHashing(sample_hash_function, 3)

# Create sample nodes
node1 = Node("node1", "192.168.1.101", 2)
node2 = Node("node2", "192.168.1.102", 1)
node3 = Node("node3", "192.168.1.103", 3)
node4 = Node("node4", "192.168.1.104", 2)
node5 = Node("node5", "192.168.1.105", 1)

# Add nodes to consistent hashing
consistent_hashing.add_node(node1)
consistent_hashing.add_node(node2)
consistent_hashing.add_node(node3)
consistent_hashing.add_node(node4)
consistent_hashing.add_node(node5)

# Create sample requests
request1 = Request("request1", "service1", "GET")
request2 = Request("request2", "service2", "POST")
request3 = Request("request3", "service3", "PUT")
request4 = Request("request4", "service1", "GET")
request5 = Request("request5", "service2", "POST")
request6 = Request("request6", "service3", "PUT")

# Get assigned nodes for sample requests
assigned_node1 = consistent_hashing.get_assigned_node(request1)
assigned_node2 = consistent_hashing.get_assigned_node(request2)
assigned_node3 = consistent_hashing.get_assigned_node(request3)
assigned_node4 = consistent_hashing.get_assigned_node(request4)
assigned_node5 = consistent_hashing.get_assigned_node(request5)
assigned_node6 = consistent_hashing.get_assigned_node(request6)

# Print assigned nodes
print("Assigned Node for Request 1:", assigned_node1.get_id(), assigned_node1.get_ip_address())
print("Assigned Node for Request 2:", assigned_node2.get_id(), assigned_node2.get_ip_address())
print("Assigned Node for Request 3:", assigned_node3.get_id(), assigned_node3.get_ip_address())
print("Assigned Node for Request 4:", assigned_node4.get_id(), assigned_node4.get_ip_address())
print("Assigned Node for Request 5:", assigned_node5.get_id(), assigned_node5.get_ip_address())
print("Assigned Node for Request 6:", assigned_node6.get_id(), assigned_node6.get_ip_address())

import uuid
from enum import Enum, auto


class RequestUnit(Enum):
    QPS = auto()


class RequestPerSeconds(Enum):
    INFINTE_QPS = 10**12
    ZERO_QPS = 10**3
    ONE_K_QPS = 10**3
    TEN_K_QPS = 10**4
    ONE_L_QPS = 10**5
    TEN_L_QPS = 10**6
    ONE_Cr_QPS = 10**7
    TEN_Cr_QPS = 10**8
    ONE_Bn_QPS = 10**9
    TEN_Bn_QPS = 10**10

    @staticmethod
    def get_available_rps():
        return [
            RequestPerSeconds.ZERO_QPS,
            RequestPerSeconds.ONE_K_QPS,
            RequestPerSeconds.TEN_K_QPS,
            RequestPerSeconds.ONE_L_QPS,
            RequestPerSeconds.TEN_L_QPS,
            RequestPerSeconds.ONE_Cr_QPS,
            RequestPerSeconds.TEN_Cr_QPS,
            RequestPerSeconds.ONE_Bn_QPS,
            RequestPerSeconds.TEN_Bn_QPS,
        ]


ENTITY_DICT = {
    "client": ("Client", RequestPerSeconds.INFINTE_QPS),
    "dns": ("DNS", RequestPerSeconds.INFINTE_QPS),
    "server_0": ("Server_0", RequestPerSeconds.ONE_K_QPS),
    "server_1": ("Server_1", RequestPerSeconds.TEN_K_QPS),
    "server_2": ("Server_2", RequestPerSeconds.ONE_L_QPS),
    "server_3": ("Server_3", RequestPerSeconds.TEN_L_QPS),
    "server_4": ("Server_4", RequestPerSeconds.ONE_Cr_QPS),
    "server_5": ("Server_5", RequestPerSeconds.TEN_Cr_QPS),
    "server_6": ("Server_6", RequestPerSeconds.ONE_Bn_QPS),
    "server_7": ("Server_7", RequestPerSeconds.TEN_Bn_QPS),
    "load_balancer": ("Load-Balance", RequestPerSeconds.INFINTE_QPS),
    "db": ("DB", RequestPerSeconds.ONE_L_QPS),
    "db_master": ("DB-Master", RequestPerSeconds.ONE_L_QPS),
    "db_slave": ("DB-Slave", RequestPerSeconds.ONE_L_QPS),
    "multi_server": ("Multi Server", RequestPerSeconds.ZERO_QPS),
    "cache": ("Cache", RequestPerSeconds.ONE_K_QPS),
    "cdn": ("CDN", RequestPerSeconds.ONE_K_QPS),
    "Stateless_Auth": ("Shared-DB-Stateless-Auth", RequestPerSeconds.ONE_K_QPS),
    "data_ceneter": ("Data-Center-Geo-Routed", RequestPerSeconds.ONE_K_QPS),
    "message_queue": ("Message-Queue", RequestPerSeconds.ONE_K_QPS),
    "logging_meterics_automation": (
        "Logging-Meterics-Automation",
        RequestPerSeconds.ONE_K_QPS,
    ),
    "db_sharding": ("DB-Sharding", RequestPerSeconds.ONE_L_QPS),
}


class Entity:
    def __init__(self, name: str, max_capacity: RequestPerSeconds):
        self.id = uuid.uuid4()
        self.name = name
        self.max_capacity = max_capacity.value
        self.child_entities: list["Entity"] = []

    def add_entity(self, entity: "Entity"):
        self.child_entities.append(entity)

        new_max_capacity = 0

        for child in self.child_entities:
            new_max_capacity += child.max_capacity

        self.max_capacity = max(new_max_capacity, self.max_capacity)

    def __str__(self):
        return f"{self.name}"


class Node:
    def __init__(self, value: Entity, next: "Node" = None):
        self.value = value
        self.next = next


class System:
    _avaialble_tools: list[Node] = None
    _current_system: Node = None

    @staticmethod
    def create_system():
        if not System._avaialble_tools:
            System._avaialble_tools = []
            System._current_system = None

    def get_available_tools(self):
        return [
            f"{entity.name}({idx})" for idx, entity in enumerate(self._avaialble_tools)
        ]

    def add_entity_to_system(self, tool_index: int):
        new_node = Node(System._avaialble_tools[tool_index])
        if not System._current_system:
            System._current_system = new_node
        else:
            current: Node = System._current_system
            while current.next:
                current.next

            current.next = new_node

    def print_current_system(self):
        current: Node = self._current_system
        while current:
            print(current.value, end=" -> ")
            current = current.next
        print()

    def test_system(self):
        qps_list = RequestPerSeconds.get_available_rps()
        for qps in qps_list:
            current = System._current_system
            while current:
                if current.value.max_capacity < qps.value:
                    print(
                        f"\nSystem breaks at '{current.value.name}'. on load {qps} {RequestUnit.QPS}"
                    )
                    return False, current.value
                current = current.next
            print(f"\nSystem works fine on load {qps} {RequestUnit.QPS}")

        return True, None

    def replace_node(self, entity_1, entity_2):
        pass


class SystemController:
    def __init__(self):
        self.system = System()
        self.system.create_system()

        self.initiate_system()

    def initiate_system(self):
        for entity_details in ENTITY_DICT.values():
            entity = Entity(entity_details[0], entity_details[1])
            self.system._avaialble_tools.append(entity)

    def build_system(self):
        print(self.system.get_available_tools())
        pass


system_controller = SystemController()
system_controller.build_system()

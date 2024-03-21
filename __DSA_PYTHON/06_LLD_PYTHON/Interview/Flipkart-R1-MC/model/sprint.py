from enum import Enum
from .task import Task

class SprintStatus(Enum):
    OPEN = "OPEN"
    CLOSED = "CLOSED"

class Sprint:
    def __init__(self, name) -> None:
        self.name = name
        self.status = SprintStatus.OPEN
        self.tasks: dict[str, Task] = {}

    def find_task(self, title):
        return self.tasks.get(title, None)
    def add_task(self, task: Task): 
        if task.title in self.tasks:
            raise Exception("Task already present in sprint")
        self.tasks[task.title] = task
from abc import ABC, abstractmethod
from datetime import datetime

from enum import Enum


# Will be creating separte file for ENUM
class TaskStatus(Enum):
    OPEN = "OPEN"
    INPROGRESS = "INPROGRESS"


class FeatureTaskStatus(Enum):
    OPEN = "OPEN"
    INPROGRESS = "INPROGRESS"
    TESTING = "TESTING"
    DEPLOYED = "DEPLOYED"


class BugTaskStatus(Enum):
    OPEN = "OPEN"
    INPROGRESS = "INPROGRESS"
    FIXED = "FIXED"


class StoryTaskStatus(Enum):
    OPEN = "OPEN"
    INPROGRESS = "INPROGRESS"
    COMPLETED = "COMPLETED"


class SubTaskStatus(Enum):
    OPEN = "OPEN"
    INPROGRESS = "INPROGRESS"
    COMPLETED = "COMPLETED"


# Will be creating separte file for Each Entity

class Task(ABC):
    def __init__(
        self,
        title,
        creator,
        status,
        type,
        due_date,
        attributes={},
        assignee=None,
    ):
        self.title = title
        self.creator = creator
        self.assignee = assignee
        self.status = status
        self.type = type
        self.sprint = None
        self.due_date = datetime.strptime(due_date, "%Y-%m-%d")

    def assign_task(self, user: str): self.assignee = user





class SubTask:
    def __init__(self, title):
        self.title = title
        self.status = SubTaskStatus.OPEN


class FeatureTask(Task):
    def __init__(
        self, title, creator, status, type, due_date, attributes, assignee=None
    ):
        self.summary = attributes["summary"]
        self.impact = attributes["impact"]
        super().__init__(title, creator, status, type, due_date, assignee)


class BugTask(Task):
    def __init__(
        self, title, creator, status, type, due_date, attributes, assignee=None
    ):
        self.severity = attributes["severity"]

        super().__init__(title, creator, status, type, due_date, assignee)


class StoryTask(Task):
    def __init__(
        self, title, creator, status, type, due_date, attributes, assignee=None
    ):
        self.summary = attributes["summary"]
        self.subtask: list[SubTask] = []
        super().__init__(title, creator, status, type, due_date, assignee)

    def add_subtask(self, sub_task: SubTask):
        self.subtask.append(sub_task)

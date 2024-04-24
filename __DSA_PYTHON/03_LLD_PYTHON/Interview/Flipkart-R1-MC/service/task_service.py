from datetime import datetime
from model.task import (
    FeatureTask,
    BugTask,
    StoryTask,
    Task,
    FeatureTaskStatus,
    BugTaskStatus,
    StoryTaskStatus,
    SubTask,
    SubTaskStatus,
)
from model.sprint import Sprint
from .task_factory import TaskFactory
from .db import DB

from .exception import handle_exception


class TaskService:
    def __init__(self):
        self.assinged_users = DB.assinged_users
        self.tasks = DB.tasks
        self.sprints = DB.sprints

    def get_sprint_by_name(self, name):
        if name not in self.sprints:
            raise Exception("Sprint does not exist")
        return self.sprints[name]

    def get_task_by_name(self, name):
        if name not in self.tasks:
            raise Exception("task does not exist")
        return self.tasks[name]

    @handle_exception
    def create_sprint(self, name):
        if name in self.sprints:
            raise Exception("Sprint already exist with same name")
        sprint = Sprint(name)
        self.sprints[name] = sprint
        print(f"Successfully create sprint: {sprint.name}")

    @handle_exception
    def create_task(self, title, creator, due_date, type, attributes):
        if title in self.tasks:
            raise Exception("Task with this title already exist")
        task = TaskFactory(title, creator, due_date, type, attributes)
        task = task.instance

        self.tasks[task.title] = task
        print(f"Successfully create task: {task.type}")

    @handle_exception
    def add_task_to_sprint(self, title, sprint):
        sprint: Sprint = self.get_sprint_by_name(sprint)
        task: Task = self.get_task_by_name(title)
        task.sprint=  sprint
        sprint.add_task(task)

    @handle_exception
    def assign_task_to_user(self, title, user):
        task: Task = self.get_task_by_name(title)
        task.assign_task(user)
        if user not in self.assinged_users:
            self.assinged_users[user] = []
        self.assinged_users[user].append(task)

    @handle_exception
    def update_task_status(self, title, status):
        task: Task = self.get_task_by_name(title)
        if isinstance(task, FeatureTask) and status not in FeatureTaskStatus:
            raise Exception("Invalid status for task: ", task.type ) 
        elif isinstance(task, BugTask) and status not in BugTaskStatus:
            raise Exception("Invalid status for task: ", task.type ) 
        elif isinstance(task, StoryTask) and status not in StoryTaskStatus:
            raise Exception("Invalid status for task: ", task.type ) 
        
        task.status = status

   

    @handle_exception
    def view_assigned_task(self, user):

        assigned_task: list[Task] = [
            task
            for title, task in self.tasks.items()
            if task.assignee and task.assignee.lower() == user.lower()
        ]

        print(f"User => {user}")
        if not assigned_task:
            print("\tNo task assigned") 
            return
        for task in assigned_task:
            print("\tTask Type: ", task.type)
            print("\t\tTitle: ", task.title)
            print("\t\tSprint: ", task.sprint.name if task.sprint else None)
            print()

    @handle_exception
    def display_status(self, name):
        sprint: Sprint = self.get_sprint_by_name(name)
        on_track_task = []
        delayed_task = []
        for task_title, task in sprint.tasks.items():
            if task.due_date >= datetime.now():
                on_track_task.append(task)
            else:
                delayed_task.append(task)

        print("On Track Task")
        for task in on_track_task:
            print("\t", task.title)
        print("Delayed Task")
        for task in delayed_task:
            print("\t", task.title)

    @handle_exception
    def create_subtask(self, parent_task, title):
        task: Task = self.get_task_by_name(parent_task)
        if not isinstance(task, StoryTask):
            raise Exception("Can only add subtask to Task Type Story")
        if task.status != FeatureTaskStatus.INPROGRESS.value:
            raise Exception("Task is not in progress state")
        subtask = SubTask(title)
        task.add_subtask(subtask)
        print("successffully create subtask")

    @handle_exception
    def delete_sprint(self, sprint):
        sprint = self.get_sprint_by_name(sprint)
        del self.sprints[sprint.name]

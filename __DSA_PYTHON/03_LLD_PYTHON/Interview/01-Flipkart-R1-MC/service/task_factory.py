from model.task import FeatureTask, BugTask, StoryTask, Task, TaskStatus


class TaskFactory:
    def __init__(
        self, title, creator,  due_date, type, attributes, assignee=None
    ) -> Task:
        self.instance = None
        self.status = TaskStatus.OPEN
        if type.upper() == "FEATURE":
            self.instance = FeatureTask(
                title, creator, self.status, type, due_date, attributes, assignee
            )
        elif type.upper() == "BUG":
            self.instance = BugTask(
                title, creator, self.status, type, due_date, attributes, assignee
            )
        elif type.upper() == "STORY":
            self.instance = StoryTask(
                title, creator, self.status, type, due_date, attributes, assignee
            )
        elif type.upper() == "NEW_TASK_TYPE":
            self.instance = StoryTask(
                title, creator, self.status, type, due_date, attributes, assignee
            )
        else:
            print("Invalid task type")


    
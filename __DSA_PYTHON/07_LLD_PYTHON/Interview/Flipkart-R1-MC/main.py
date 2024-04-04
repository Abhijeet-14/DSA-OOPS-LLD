# CreateSprint(name=“Sprint1”)
# CreateTask(title=“Create Dashboard”, creator=“Ryan”, dueDate=”2024-04-12”,
# type=”Feature”,attributes={summary: “Create console for debugging”,
# impact:“Low”})
# CreateTask(title=“Fix mysql issue”,
# creator=“Ryan”, dueDate=”2024-04-14”,
# type=”Bug”, attributes={“severity:“P0”})
# AddTaskToSprint(title=”Fix mysql issue”, sprint=”Sprint1”)
# AssignTaskToUser(title=”Fix mysql issue”, user=”Ryan”)
# UpdateTaskStatus(title=”Fix mysql issue”, status=”In Progress” )

# CreateSubtask(parentTask=”Create a microservice”, title=”development”)

# viewAssignedTask(Ryan)
# displayStatus(Sprint-1)

from service.task_service import (
    TaskService,
    FeatureTaskStatus,
    StoryTaskStatus,
    BugTaskStatus,
)
from service.db import DB

task_api = TaskService()


task_api.create_sprint("Sprint2")
task_api.create_sprint("Sprint1")
task_api.create_task(
    "Create Dashboard",
    "Ryan",
    "2024-04-12",
    "Feature",
    attributes={"summary": "Create console for debugging", "impact": "Low"},
)
task_api.create_task(
    "Fix mysql issue",
    "Ryan",
    "2024-04-14",
    "Bug",
    attributes={"severity": "P0"},
)

task_api.create_task(
    "Story Task 1",
    "Ryan",
    "2024-03-14",
    "Story",
    attributes={"summary": "Dummy Story Task"},
)

task_api.add_task_to_sprint("Fix mysql issue", "Sprint1")
task_api.add_task_to_sprint("Fix mysql issue", "Sprint2")

task_api.assign_task_to_user("Fix mysql issue", "Ryan")
task_api.assign_task_to_user("Fix mysql issue", "ABC")
task_api.assign_task_to_user("Story Task 1", "Ryan")
task_api.update_task_status("Fix mysql issue", StoryTaskStatus.COMPLETED.value)

task_api.add_task_to_sprint("Story Task 1", "Sprint2")
# task_api.create_subtask(parent_task="Create a microservice", title="development")
task_api.create_subtask(parent_task="Story Task 1", title="development")
# task_api.update_task_status("Story Task 1", StoryTaskStatus.INPROGRESS.value)
# task_api.create_subtask(parent_task="Story Task 1", title="development")
# task_api.add_task_to_sprint("Story Task 1", "Sprint1")

task_api.view_assigned_task("Ryan")
task_api.view_assigned_task("ABC")
task_api.display_status("Sprint1")

print('======')
task_api.display_status("Sprint2")

# print("\n\n======")
# print(DB.sprints, DB.tasks)

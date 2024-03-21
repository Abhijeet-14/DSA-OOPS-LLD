# Task
A task has the following details :
    1. Title
    2. Creator
    3. Assignee (Optional)
    4. Status
    5. Type
    6. Due date

Task - Feature | Bug | Story ... can add in future
Featur - summary, impact(LOW, MEDIUM, High)
bug - seveerity (PO, P1 or P2)
Story - (summary, [subtask])
    - subtask - title, status

The status can change from a state to any state.

# Status field takes one of the following states depending on the task type :
Feature => Open, In progress, Testing, Deployed
Bug => Open, In progress, Fixed
Story => Open, In Progress, Completed
Subtask status field takes one of these values
Open, In Progress, Completed

- Story can only be marked as Completed, if all of its Subtasks are Completed.

A sprint is defined as a collection of tasks used to track progress. You can add or remove a task
from sprints.
A task can be part of only one sprint at a time.


# Functionality
Task
a. Create a task of any type
b. Create Subtask
c. Change the status of the task/Subtask
d. Change assignee of the task
e. Display tasks assigned to a user categorised by task type

Sprint
a. Create/Delete a Sprint
b. Add/remove task to/from sprint
c. Display sprint snapshot. This should display the tasks that are part of the sprint
and also display if they are delayed or on track


# Testcase
## Examples:
- CreateSprint(name=“Sprint1”)
- CreateTask(title=“Create Dashboard”, creator=“Ryan”, dueDate=”2024-04-12”, type=”Feature”,attributes={summary: “Create console for debugging”, impact:“Low”})
- CreateTask(title=“Fix mysql issue”, creator=“Ryan”, dueDate=”2024-04-14”, type=”Bug”, attributes={“severity:“P0”})
- AddTaskToSprint(title=”Fix mysql issue”, sprint=”Sprint1”)
- AssignTaskToUser(title=”Fix mysql issue”, user=”Ryan”)
- UpdateTaskStatus(title=”Fix mysql issue”, status=”In Progress” )

## Example:
CreateSubtask(parentTask=”Create a microservice”, title=”development”)


## Example
- viewAssignedTask(Ryan)
- displayStatus(Sprint-1)

Note: Task will come under “delayed task” if the task (with non-completed status) has crossed
the due date


# List Objects
- interface - task
- Feat .. Bug ..
- TASK_STATUS
- BUG_SEVERITY
- FEAT_IMPACT
- SUBTASK - STATUS

# CHeck
- 1 story -> 1 sprint
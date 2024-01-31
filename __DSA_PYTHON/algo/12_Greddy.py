"""
Greedy ALgo - is an approach for solving problem by SELECTING NEXT BEST OPTION available at the moment starting from 0.

- even it went wrong -- it won't reverse.
"""


def greedy_activity_selection(activities):
    activities.sort(key=lambda x: x[1])  # O(NlogN)

    selected_activites = [activities[0]]
    last_activity_end_time = activities[0][1]

    for activitie in activities[1:]:  # O(N)
        if activitie[0] >= last_activity_end_time:
            selected_activites.append(activitie)
            last_activity_end_time = activitie[1]

    return selected_activites


activities = [
    (1, 4),
    (3, 5),
    (0, 6),
    (5, 7),
    (3, 8),
    (5, 9),
    (6, 10),
    (8, 11),
    (8, 12),
    (2, 13),
    (12, 14),
]

print("Activities:")
for activity in activities:
    print(activity)

selected_activities = greedy_activity_selection(activities)

print("\nSelected Activities:")
for activity in selected_activities:
    print(activity)

print("TC - O(NlogN), AS - O(N)")

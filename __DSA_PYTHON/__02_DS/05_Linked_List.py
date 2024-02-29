def curr_node(data, next=None):
    return {"data": data, "next": next}


node_1 = curr_node(1)
node_2 = curr_node(2, node_1)
node_3 = curr_node(3, node_2)
node_4 = curr_node(4, node_3)
node_5 = curr_node(5, node_4)


def print_linked_list(head):
    current = head
    while current:
        print(current["data"], end=" -> ")
        current = current["next"]
    print("None")


print_linked_list(node_5)


########### Question 1 ###########
def reverse_ll(head):
    print("\nReversing LinkedList")
    current = head
    prev = None
    while current:
        temp = current
        current = current["next"]
        temp["next"] = prev
        prev = temp


reverse_ll(node_5)
print_linked_list(node_1)


########### Question 2 ###########
def find_middle(head):
    print("\nFind Middle of LinkedList", end=" -> ")
    first = head  # 2 jump
    sec = head  # 1 jump

    while first and sec:
        if first["next"]:
            first = first["next"]["next"]
            sec = sec["next"]
        else:
            first = None

    print(sec["data"])
    return sec["data"]


find_middle(node_1)


########### Question 3 ###########
def find_nth_node_from_end(head, nth):
    print(f"\nFind nth({nth}) Node from end of LinkedList", end=" -> ")

    current = head
    nth_from_end = head

    if nth <= 0:
        nth_from_end = None

    while nth > 0 and nth_from_end:
        nth_from_end = nth_from_end["next"]
        nth -= 1

    if not nth_from_end:
        return None

    while nth_from_end and current:
        nth_from_end = nth_from_end["next"]
        current = current["next"]

    print(current["data"])
    return current["data"]


find_nth_node_from_end(node_1, 7)


########### Question 4 ###########
def remove_nth_node_from_end(head, nth):
    print(f"\n\nRemove nth({nth}) Node from end of LinkedList", end=" -> ")

    current = head
    nth_from_end = head

    if nth <= 0:
        nth_from_end = None

    while nth > 0 and nth_from_end:
        nth_from_end = nth_from_end["next"]
        nth -= 1

    prev = None
    while nth_from_end and current:
        nth_from_end = nth_from_end["next"]
        prev = current
        current = current["next"]

    if prev:
        prev["next"] = current["next"]

    print_linked_list(head)


remove_nth_node_from_end(node_1, 0)

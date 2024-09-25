"""
Problem: 
    LiftManager class handles both lift management (e.g., orchestrating requests) 
    and some lift-specific logic (e.g., deciding the next direction). 
    This violates SRP.
Solution:
    1. Refactor the 'LiftManager' to focus on managing the elevator's lifecycle and orchestrating operations only.
    2. Create a new 'RequestProcessor' class that handles how requests are processed, including deciding which request to handle next and updating the lift's direction.
"""

from collections import deque
import heapq


class Request:
    def __init__(self, floor, direction):
        self.floor = floor
        self.direction = direction

    def __lt__(self, other):
        if self.direction >= 0:
            return self.floor < other.floor
        else:
            return self.floor > other.floor

    def __str__(self):
        return (self.floor, self.direction)


class Lift:
    def __init__(self):
        self.curr_floor = 0
        self.direction = 0
        self.curr_request = []
        self.pending_up_req = []
        self.pending_down_req = []

    def live_status(self):
        return f"{self.curr_floor} {self.direction} {[r.__str__() for r in self.curr_request]} {[r.__str__() for r in self.pending_up_req]} {[r.__str__() for r in self.pending_down_req]}"

    def is_idle(self):
        return not (
            self.curr_request
            or self.pending_up_req
            or self.pending_down_req
        )
    def add_curr_request(self, req):
        heapq.heappush(self.curr_request, req)

    def pop_curr_request(self):
        return heapq.heappop(self.curr_request)


############# Solution ##############
class RequestQueueManager:
    """Handles the queuing of new requests and manages the queues."""

    def __init__(self, lift: Lift):
        self.lift = lift

    def add_new_request(self, floor, direction):
        request = Request(floor, direction)
        if self.lift.direction in [0, direction]:
            self.lift.add_curr_request(request)

        elif direction >= 0:
            self.lift.pending_up_req += [request]
        else:
            self.lift.pending_down_req += [request]

    def rearrange_next_requests(self):
        if self.lift.curr_request:
            return

        if self.lift.direction >= 0:
            self.lift.curr_request = self.lift.pending_down_req
            self.lift.pending_down_req = []
        else:
            self.lift.curr_request = self.lift.pending_up_req
            self.lift.pending_up_req = []

        self.lift.direction *= (
            -1
        )  # Reverse direction after finishing the current set of requests


class RequestProcessor:
    def __init__(self, lift: Lift, request_queue_manager: RequestQueueManager):
        self.lift = lift
        self.request_queue_manager = request_queue_manager

    def process_next_request(self):
        if self.lift.is_idle():
            print(
                f"\nLift is standing IDLE at {self.lift.curr_floor}, no request to process"
            )
            return

        self.request_queue_manager.rearrange_next_requests()

        request: Request = self.lift.pop_curr_request()

        # Move list to new request
        self.lift.curr_floor = request.floor
        self.lift.direction = request.direction


class LiftManager:
    def __init__(self):
        self.lift = Lift()
        self.request_queue_manager = RequestQueueManager(self.lift)
        self.request_processor = RequestProcessor(self.lift, self.request_queue_manager)

    def start(self):
        print(self.lift.live_status(), end=" -> ")
        self.request_processor.process_next_request()
        print(self.lift.live_status())

    def internal_request(self, floor_no):
        direction = -1 if self.lift.curr_floor - floor_no > 0 else 1
        self.request_queue_manager.add_new_request(floor_no, direction)

    def external_request(self, floor_no, direction):
        self.request_queue_manager.add_new_request(floor_no, direction)


class Floor:
    def __init__(self, floor_no):
        self.floor_no = floor_no

    def __str__(self):
        return f"{self.floor_no}"


floors: list[Floor] = []
for i in range(9):
    floors.append(Floor(i))


def run():
    lift_manager = LiftManager()
    actions = "1. Run Lift \n2. Take Floor Request\n3. Take Inside Lift request\n"
    while True:
        try:
            choice = int(input(f"{actions}"))
        except:
            continue
        if choice == 1:
            lift_manager.start()
        elif choice == 2:
            for idx, fl in enumerate(floors):
                print(f"{idx}. Floor-{fl}")
            floor_no = int(input("Enter your Floor No: [0-9] "))

            direction_input = input("Make request: [Up/Down] ")
            direction = 1 if direction_input.upper() == "UP" else -1

            lift_manager.external_request(floor_no, direction)
        elif choice == 3:
            floor_no = 0
            while 0 <= floor_no <= 9:
                floor_no = int(input("Enter your Floor No: [0-9] "))
                if floor_no >= 0:
                    lift_manager.internal_request(floor_no)


run()

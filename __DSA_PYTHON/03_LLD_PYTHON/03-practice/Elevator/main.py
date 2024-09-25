from collections import deque
import heapq


class Request:
    def __init__(self, floor, dir):
        self.floor = floor
        self.dir = dir

    def __lt__(self, other):
        if self.dir >= 0:
            return self.floor < other.floor
        else:
            return self.floor > other.floor

    def __str__(self):
        return (self.floor, self.dir)


class Lift:
    def __init__(self):
        self.curr_floor = 0
        self.direction = 0
        self.curr_request = []
        self.pending_up_req = []
        self.pending_down_req = []

    def live_status(self):
        return f"{self.curr_floor} {self.direction} {[r.__str__() for r in self.curr_request]} {[r.__str__() for r in self.pending_up_req]} {[r.__str__() for r in self.pending_down_req]}"

    def add_curr_request(self, req):
        heapq.heappush(self.curr_request, req)

    def pop_curr_request(self):
        return heapq.heappop(self.curr_request)


class LiftManager:
    def __init__(self):
        self.lift = Lift()

    def start(self):
        if not self.lift.curr_request:
            print(
                f"Lift is standing IDLE at {self.lift.curr_floor}, no request to process"
            )
            return

        print(self.lift.live_status(), end=" -> ")

        request: Request = self.lift.pop_curr_request()

        floor, dir = request.floor, request.dir
        self.lift.curr_floor = floor
        self.lift.direction = dir

        if not self.lift.curr_request:
            if dir >= 0:
                self.lift.curr_request = self.lift.pending_down_req
                self.lift.pending_down_req = []
            else:
                self.lift.curr_request = self.lift.pending_up_req
                self.lift.pending_up_req = []

            self.lift.direction = -1 * dir
        print(self.lift.live_status())

    def process_request(self, floor_no, direction):
        if self.lift.curr_floor == floor_no:
            print(f"Invalid Input, lift already at floor: {self.lift.curr_floor}")
            return
        req = Request(floor_no, direction)
        if self.lift.direction >= 0 and direction > 0:
            if self.lift.curr_floor < req.floor:
                self.lift.add_curr_request(req)
            else:
                self.lift.pending_up_req += [req]

        if self.lift.direction < 0 and direction < 0:   
            if self.lift.curr_floor > req.floor:
                self.lift.add_curr_request(req)
            else:
                self.lift.pending_down_req += [req]

    def internal_request(self, floor_no):

        direction = -1 if self.lift.curr_floor - floor_no > 0 else 1
        self.process_request(floor_no, direction)


class Floor:
    def __init__(self, floor_no):
        self.floor_no = floor_no

    def request_up(self, lift_manager: LiftManager):
        direction = +1
        lift_manager.process_request(self.floor_no, direction)

    def request_down(self, lift_manager):
        direction = -1
        lift_manager.process_request(self.floor_no, direction)

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
            pass
        elif choice == 2:
            for idx, fl in enumerate(floors):
                print(f"{idx}. Floor-{fl}")
            your_floor_idx = int(input("Enter your Floor No: [0-9] "))
            try:
                your_floor = floors[your_floor_idx]
            except:
                continue
            request = input("Make request: [Up/Down] ")
            if request.upper() == "UP":
                your_floor.request_up(lift_manager)
            else:
                your_floor.request_down(lift_manager)
        elif choice == 3:
            floor_no = 0
            while 0 <= floor_no <= 9:
                floor_no = int(input("Enter your Floor No: [0-9] "))
                if floor_no >= 0:
                    lift_manager.internal_request(floor_no)

        lift_manager.start()


run()

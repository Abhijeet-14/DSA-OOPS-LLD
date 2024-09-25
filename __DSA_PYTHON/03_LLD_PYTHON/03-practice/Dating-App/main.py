"""
Flow:
user -> register -> see profiles(opp gender) -> swipe R/L -> match noti -> chat noti
-> see profile by custom filter

Requirement: Scalable
1. user register
2. user see profiles
3. see profiles by custom filter
4. swipe R/L
5. match noti & chat noti
"""

DB = {"users": {"M": {}, "F": {}}}


class User:
    def __init__(self, name, gender, age, phone):
        self.name = name
        self.gender = gender
        self.age = age
        self.phone = phone
        self.pending_users = set()
        self.matched_users = set()
        self.rejected_user = set()
        self.messages = {}

    def match_notification(self, matched_by_user):
        print(f"Hey {self}, you have matched with {matched_by_user}")

    def chat_notification(self, chat_by_user):
        print(f"Hey {self}, New Chat message from {chat_by_user}")

    def send_message(self, chat_with_user: "User", message):
        message_package = {
            "from": f"{self}",
            "to": f"{chat_with_user}",
            "message": message,
        }

        if not chat_with_user.messages.get(self):
            chat_with_user.messages[self] = []
        chat_with_user.messages[self] += [message_package]

        if not self.messages.get(chat_with_user):
            self.messages[chat_with_user] = []
        self.messages[chat_with_user] += [message_package]

        chat_with_user.chat_notification(self)

    def get_details(self):
        return f"{self.name}, {self.age}, {self.gender}, {self.phone}"
    
    def __str__(self) -> str:
        return self.name



class UserFactory:
    def create_user(self, user: User):
        if user.gender not in ["M", "F"]:
            print("Invalid User's Gender, only [M, F] supported")

        DB["users"][user.gender][user.name] = user
        print("User created successfully!!")

class DashBoard:
    def __init__(self):
        self.curr_user: User = None

    def custom_filter(self): 
        #Builder pattern
        pass
    def login(self, user_name):
        if self.curr_user:
            print("Already logged in, please logout first")
            return

        if user_name in DB["users"]["M"]:
            self.curr_user = DB["users"]["M"][user_name]
        elif user_name in DB["users"]["F"]:
            self.curr_user = DB["users"]["F"][user_name]
        else:
            print("Invalid Login attempt")
            return
        print(f"Login successfully: {self.curr_user.get_details()}")

    def logout(self):
        self.curr_user = None
        print("Log out successfully")

    def get_free_userset(self):
        gender = self.curr_user.gender
        if gender == "M":
            users = DB["users"]["F"]
        else:
            users = DB["users"]["M"]

        visited_users = self.curr_user.pending_users.union(self.curr_user.matched_users)
        visited_users.union(self.curr_user.rejected_user)

        return [u for u in users.values() if u not in visited_users]

    def see_profiles(self):
        from collections import deque

        users = deque(self.get_free_userset())

        ## Swipe
        is_match = False
        while users and not is_match:
            us: User = users.pop()
            print(f"User: {us.get_details()}")
            print("Please swipe R/L")
            action = str(input()).upper()
            if action not in ["R", "L"]:
                print("Invalid Input, exiting the app")
                break
            is_match = self.take_action(self.curr_user, us, action)
            print()
        return

    def take_action(self, user: User, action_on_user: User, action_type):
        if action_type == "R":
            if user in action_on_user.pending_users:
                user.matched_users.add(action_on_user)
                user.match_notification(action_on_user)

                action_on_user.pending_users.remove(user)
                action_on_user.matched_users.add(user)
                action_on_user.match_notification(user)
                return True
            elif user in action_on_user.matched_users:
                print(f"You are already a match with: {action_on_user}")
                return True
            else:
                user.pending_users.add(action_on_user)
        else:
            user.rejected_user.add(action_on_user)
        return False

    def chat_match_user(self):
        matched_users = list(self.curr_user.matched_users)

        print("Matched users:")
        i = 1
        for us in matched_users:
            print(f"{i}. {us}")

        print("\nStart your chat with: (Number)")
        user_index = int(input()) - 1
        try:
            user = matched_users[user_index]

            print("Type your message:")
            message = str(input())
            self.curr_user.send_message(user, message)

        except:
            pass

    def see_messages(self):
        import pprint

        pprint.pprint(self.curr_user.messages)


class Run:
    def __init__(self):
        self.uf = UserFactory()
        self.d = DashBoard()

    def main(self):

        onboard_user = [
            User("Rohit", "M", 28, 7352),
            User("Sanya", "F", 24, 6521),
            User("Priya", "F", 30, 7421),
            User("Ankit", "M", 26, 6984),
            User("Divya", "F", 27, 7203),
            User("Vikram", "M", 32, 7139),
            User("Riya", "F", 22, 6635),
            User("Aditya", "M", 29, 7412),
            User("Megha", "F", 25, 6920),
            User("Rajesh", "M", 33, 7289),
            User("Pooja", "F", 28, 7073),
            User("Amit", "M", 31, 6791),
            User("Neha", "F", 23, 6718),
            User("Kunal", "M", 27, 7465),
            User("Sneha", "F", 26, 7086),
        ]

        for us in onboard_user:
            self.uf.create_user(us)

        while True:
            if not self.d.curr_user:
                print("Start New session, login as", end=" ")
                name = str(input())
                if not isinstance(name, str):
                    break
                self.d.login(name)

            print(
                "Select Action: \n\
                  1. See profiles\n\
                  2. Chat with matched users\n\
                  3. See Messages\n\
                  4. logout\n\
                  "
            )
            choice = int(input())
            if choice == 1:
                self.d.see_profiles()
            elif choice == 2:
                self.d.chat_match_user()
            elif choice == 3:
                self.d.see_messages()
            elif choice == 4:
                self.d.logout()
                print("Session End")
            print()
        print("Closing App")


r = Run()
r.main()

""" SCORE:
SOLID - 6/10
    1. S - Dashboard is handling mulitple responsibilities -- like login, viewing profiles, and handling chats, which violates SRP
    2. O - The current design doesn’t easily allow extension without modification, particularly in handling different actions like swiping or filtering
    3. L - Ok
    4. I - not implemented -- can be considered
    5. D - not implemented -- but can be used in Dashboard

Design Principles - 5/10
    1. Factory - 
    2. Builder - Implement it -- needed for Scalablity
    3. Observer and Command Pattern - implement it -- needed for Scalablity

OOPS - 7/10
    1. Encapsulation - Ok
    2. Abstraction - Ok, but improve
    3. Inheritence & Polymorphism - need it
    4. Modularity -- ok -- but improve
"""
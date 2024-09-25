"""
"""
from abc import ABC, abstractmethod
from collections import deque


# Database
DB = {"users": {"M": {}, "F": {}}}


# Interfaces for Notifications
class Notification(ABC):
    @abstractmethod
    def notify(self, message: str):
        pass


# Concrete Notification Classes
class MatchNotification(Notification):
    def notify(self, message: str):
        print(f"Match Notification: {message}")


class ChatNotification(Notification):
    def notify(self, message: str):
        print(f"Chat Notification: {message}")


# User Class with Encapsulation and Abstraction
class User:
    def __init__(self, name, gender, age, phone, city=None):
        self.name = name
        self.gender = gender
        self.age = age
        self.phone = phone
        self.city = city
        self.pending_users = set()
        self.matched_users = set()
        self.rejected_users = set()
        self.messages = {}
        self.match_notifiers = []
        self.chat_notifiers = []

    def add_match_notifier(self, notifier: Notification):
        self.match_notifiers.append(notifier)

    def add_chat_notifier(self, notifier: Notification):
        self.chat_notifiers.append(notifier)

    def match_notification(self, matched_by_user: "User"):
        message = f"Hey {self.name}, you have matched with {matched_by_user.name}!"
        for notifier in self.match_notifiers:
            notifier.notify(message)

    def chat_notification(self, chat_by_user: "User"):
        message = f"Hey {self.name}, New Chat message from {chat_by_user.name}!"
        for notifier in self.chat_notifiers:
            notifier.notify(message)

    def get_chat_history(self, with_user: "User"):
        if with_user in self.messages:
            return self.messages[with_user]
        return []
    def __str__(self):
        return self.name


# Factory Pattern for Creating Users
class UserFactory:
    @staticmethod
    def create_user(name, gender, age, phone, city=None):
        if gender not in ["M", "F"]:
            raise ValueError("Invalid User's Gender, only 'M' or 'F' supported")
        user = User(name, gender, age, phone, city)
        DB["users"][gender][name] = user
        return user


# Command Pattern for User Actions
class Command(ABC):
    @abstractmethod
    def execute(self, user: User, target_user: User, action: str = None, message: str = None):
        pass


class SwipeCommand(Command):
    def execute(self, user: User, target_user: User, action: str):
        if action == "R":
            if user in target_user.pending_users:
                user.matched_users.add(target_user)
                target_user.matched_users.add(user)
                user.match_notification(target_user)
                target_user.match_notification(user)
            else:
                user.pending_users.add(target_user)
        else:
            user.rejected_users.add(target_user)


class MessageCommand(Command):
    def execute(self, user: User, target_user: User, message: str):
        import datetime
        message_package = {"from": user.name, "to": target_user.name, "message": message, "timestamp": datetime.datetime.now()}
        user.messages.setdefault(target_user, []).append(message_package)
        target_user.messages.setdefault(user, []).append(message_package)
        target_user.chat_notification(user)

# Builder Pattern for Custom Filters
class UserFilterBuilder:
    def __init__(self):
        self.age_min = None
        self.age_max = None
        self.city = None

    def set_age_range(self, min_age, max_age):
        self.age_min = min_age
        self.age_max = max_age
        return self

    def set_city(self, city):
        self.city = city
        return self

    def build(self):
        return UserFilter(self.age_min, self.age_max, self.city)


class UserFilter:
    def __init__(self, age_min, age_max, city):
        self.age_min = age_min
        self.age_max = age_max
        self.city = city

    def filter(self, users):
        filtered_users = users
        if self.age_min is not None and self.age_max is not None:
            filtered_users = [u for u in filtered_users if self.age_min <= u.age <= self.age_max]
        if self.city:
            filtered_users = [u for u in filtered_users if u.city == self.city]
        return filtered_users


# User Login & Dashboard
class Dashboard:
    def __init__(self):
        self.current_user: User = None
        self.swipe_command = SwipeCommand()
        self.message_command = MessageCommand()

    def login(self, user_name):
        if user_name in DB["users"]["M"]:
            self.current_user = DB["users"]["M"][user_name]
        elif user_name in DB["users"]["F"]:
            self.current_user = DB["users"]["F"][user_name]
        else:
            print("Invalid Login attempt")
            return False
        print(f"Login successful: {self.current_user}")
        return True

    def logout(self):
        self.current_user = None
        print("Logout successful")

    def get_profiles(self):
        opposite_gender = "F" if self.current_user.gender == "M" else "M"
        users = DB["users"][opposite_gender].values()
        visited_profiles = self.current_user.pending_users.union(self.current_user.matched_users)
        visited_profiles = visited_profiles.union(self.current_user.rejected_users)
        return [u for u in users if u not in visited_profiles]

    def view_profiles(self, filter: UserFilter = None):
        profiles = deque(self.get_profiles())
        if filter:
            profiles = deque(filter.filter(profiles))

        while profiles:
            target_user = profiles.pop()
            print(f"Profile: {target_user}")
            action = input("Swipe R/L: ").upper()
            if action not in ["R", "L"]:
                print("Invalid Input")
                break
            self.swipe_command.execute(self.current_user, target_user, action)

    # Live Chat:
    def view_messages(self, chat_with_user: User):
        history = self.current_user.get_chat_history(chat_with_user)
        for msg in history:
            print(f"[{msg['timestamp']}] {msg['from']} -> {msg['to']}: {msg['message']}")

    def chat_with_user(self):
        matched_users = list(self.current_user.matched_users)
        print("Matched users:")
        for idx, matched_user in enumerate(matched_users, 1):
            print(f"{idx}. {matched_user}")

        print("\nSelect a user to chat with (number):")
        user_idx = int(input()) - 1
        if 0 <= user_idx < len(matched_users):
            chat_user = matched_users[user_idx]
            print(f"Chat with {chat_user}:")

            while True:
                print("1. Send message\n2. View chat history\n3. Request Reply \n4. Exit chat")
                choice = int(input())
                if choice in [1, 3]:
                    sender = self.current_user if choice == 1 else chat_user
                    receiver = self.current_user if choice == 3 else chat_user
                    message = input(f"Enter message [{sender}]: ")
                    self.message_command.execute(sender, receiver, message)
                elif choice == 2:
                    self.view_messages(chat_user)
                elif choice == 4:
                    break
                else:
                    print("Invalid option")

# Main Application
class Run:
    def __init__(self):
        self.uf = UserFactory()
        self.dash = Dashboard()

    def onboard_users(self):
        onboard_user_data = [
            ("Rohit", "M", 28, 7352, "Delhi"),
            ("Sanya", "F", 24, 6521, "Mumbai"),
            ("Priya", "F", 30, 7421, "Delhi"),
            ("Ankit", "M", 26, 6984, "Kolkata"),
            ("Divya", "F", 27, 7203, "Bangalore"),
            ("Vikram", "M", 32, 7139, "Delhi"),
            ("Riya", "F", 22, 6635, "Mumbai"),
            ("Aditya", "M", 29, 7412, "Chennai"),
            ("Megha", "F", 25, 6920, "Delhi"),
            ("Rajesh", "M", 33, 7289, "Kolkata"),
            ("Pooja", "F", 28, 7073, "Bangalore"),
            ("Amit", "M", 31, 6791, "Mumbai"),
            ("Neha", "F", 23, 6718, "Chennai"),
            ("Kunal", "M", 27, 7465, "Delhi"),
            ("Sneha", "F", 26, 7086, "Bangalore"),
        ]
        for data in onboard_user_data:
            user = self.uf.create_user(*data)
            # Adding notifications
            if data[1] == "M":
                user.add_match_notifier(MatchNotification())
                user.add_chat_notifier(ChatNotification())
            else:
                user.add_match_notifier(MatchNotification())
                user.add_chat_notifier(ChatNotification())

    def main(self):
        self.onboard_users()
        user_filter: UserFilter = None
        while True:
            if not self.dash.current_user:
                user_name = input("Login as: ")
                if not self.dash.login(user_name):
                    continue

            print("\nChoose 1 action: \n\
                  1. See profiles\n\
                  2. Add Custom Profile Filter\n\
                  3. Logout\n\
                  4. STOP\n\
                  5. Live Chat")
            try:
                choice = int(input())
            except:
                print("Invalid command")
                continue
            if choice == 4:
                break
            elif choice == 5:
                self.dash.chat_with_user()
            elif choice == 1:
                self.dash.view_profiles(user_filter)
            elif choice == 2:
                # Applying filters
                print("Enter minimum age:")
                min_age = int(input())

                print("Enter maximum age:")
                max_age = int(input())
                
                print("Enter city (or press Enter to skip):")
                city = input().strip()
                city = city if city else None

                filter_builder = UserFilterBuilder()
                user_filter = filter_builder.set_age_range(min_age, max_age).set_city(city).build()

            elif choice == 3:
                self.dash.logout()

        print("Closing App")


r = Run()
r.main()

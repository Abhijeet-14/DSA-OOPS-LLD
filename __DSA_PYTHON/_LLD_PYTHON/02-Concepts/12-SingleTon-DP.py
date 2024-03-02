# Creational Desing Pattern

############################
# Singleton Design Pattern
############################
"""
- it is a CREATIONAL design pattern -- helps in Creation of an Object.

- SingleTon - make sure ONLT 1 object gets create
"""


class Singleton:
    _instance = None

    @staticmethod
    def get_instance():
        if not Singleton._instance:
            # LAZY initialize - when get_instance called -> created
            Singleton._instance = Singleton()

        return Singleton._instance


s1 = Singleton.get_instance()
print(s1)
s2 = Singleton.get_instance()
print(s2)
print(s1 == s2)


## Problem
""" Problem
- let 2 request come at same time.. R1 & R2
- at same time, both see _instance is None.
- so they create -> 2 _instance get created.

Solution:
    - Multi-Threading - with double check
"""
import threading


class SingleMultiThreading:
    _instance = None
    _lock = threading.Lock()

    @staticmethod
    def get_instance():
        """We check 2 time with threads"""

        # Request_1 & Request_2 - come here
        if not SingleMultiThreading._instance:
            # Request_1 locks 1st # Request_2 locks
            with SingleMultiThreading._lock:
                # Request_1 check 1st -> True # Request_2 check -> False
                if not SingleMultiThreading._instance:
                    # Request_1 create it.
                    SingleMultiThreading._instance = SingleMultiThreading()
        return SingleMultiThreading._instance


def create_singleton_multi_threading_instance():
    singleton_multi_threading_instance = SingleMultiThreading.get_instance()
    print(f"Singleton MT instance: {singleton_multi_threading_instance}")


threads = []
for _ in range(5):
    thread = threading.Thread(target=create_singleton_multi_threading_instance)
    threads.append(thread)

    thread.start()

for thread in threads:
    thread.join()

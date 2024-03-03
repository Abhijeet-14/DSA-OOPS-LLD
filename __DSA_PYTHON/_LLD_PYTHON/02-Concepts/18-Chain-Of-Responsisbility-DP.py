###############################
# Chain Of Responsibiltiy Design Pattern -- VVI
###############################

"""
- Usage:
    - Design ATM
    - Design Vending Machine
    - Design Logger

- Defination:
    - sender --> Request -. System [ Receiver1 -> Receiver 2 -> Receiver 3 -> .... ]
    - so sender make request -- but didn't say which Receiver to Use
    - so we Process each Receiver 1 by 1.. 
    - Receiver 1 -> Fails --> goto next
    - Receiver 2 -> Fails ---> goto next
    - Receiver 3 -> Fails --> goto next
    - ....
    - Receiver 7 -> Success -> RETURN
    
- Example:
    - ATM System (notes: [2000 Rs, 1000 Rs, 500 Rs, 100 Rs]
    - sender -> withraw 1650 rs

    - check 1650 > 2000 -> Fails -> next
    - check 1650 > 1000 -> 1650/1000 -> 1 * 1000 Rs -> Next
    - check 650 > 500 -> 1*500 Rs -> Next
    - check 150 > 100 -> 1*100 -> next
    - check 50 -> no note of 50 rs -> Fails -> Next
    - no other note -> Throw exception("Invalid input, please enter in multiple of 2000, 1000, 500, 100")

    - sender withdraw - 300 rs
    - check 300 > 2000 -> Fails -> Next
    - check 300 > 1000 -> Fails -> Next
    - check 300 > 500 -> Fails -> Next
    - check 300 > 100 -> 3*100 rs -> RETURN 100's 3 note.

    
- Solution - UML
    - client -- "HAS_A" -- Handler
    - interface Handler
    - concrete Handle 1 -- 'Is_A' -- Handler
    - concrete Handle 3 -- 'Is_A' -- Handler

    - concrete Handler -- 'Has_A' -- Handler -- next handler to call
"""


"""
- Example 1: Logger
    - logger.log("INFO", "--Message--")
    - logger.log("DEBUG", "--Message--")
    - logger.log("ERROR", "--Message--")
"""
from abc import ABC, abstractmethod


class LogHandler(ABC):
    _INFO_PRIORITY = 1
    _DEBUG_PRIORITY = 2
    _ERROR_PRIORITY = 3

    def __init__(self, logger_handler):
        self.next_handler = logger_handler

    def log(self, log_level, message):
        if self.next_handler != None:
            self.next_handler.log(log_level, message)
        else:
            print("Invalid Log Level provided")


# create 3 concrete class
class InfoHandler(LogHandler):
    def __init__(self, next_logger: LogHandler):
        super().__init__(next_logger)

    def log(self, log_level, message):
        if log_level == LogHandler._INFO_PRIORITY:
            print("INFO: ", message)
        else:
            super().log(log_level, message)


class DebugHandler(LogHandler):
    def __init__(self, next_logger: LogHandler):
        super().__init__(next_logger)

    def log(self, log_level, message):
        if log_level == LogHandler._DEBUG_PRIORITY:
            print("DEBUG: ", message)
        else:
            super().log(log_level, message)


class ErrorHandler(LogHandler):
    def __init__(self, next_logger: LogHandler):
        super().__init__(next_logger)

    def log(self, log_level, message):
        if log_level == LogHandler._ERROR_PRIORITY:
            print("ERROR: ", message)
        else:
            super().log(log_level, message)


ad


def client():
    logger: LogHandler = InfoHandler(DebugHandler(ErrorHandler(None)))

    # INFO - X -> Debug - X -> Error - Y -> RETURN
    logger.log(LogHandler._ERROR_PRIORITY, "my error message")

    # INFO - X -> Debug - Y -> RETURN
    logger.log(LogHandler._DEBUG_PRIORITY, "my debug message")

    # INFO - Y -> RETURN
    logger.log(LogHandler._INFO_PRIORITY, "my info message")

    # INFO - X -> DEBUG - X -> Error - X -> No Print
    logger.log("ABC", "my info message")


client()

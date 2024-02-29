"""
Production Level Coding
    1. Type Hinting
    2. Doc-String
    3. Enumerate
    4. List-Comprehension
"""


#### 1. Type Hinting ####
def some_cal(x: int, y: int | float) -> int | float:
    return x * y


print(some_cal(2, 3))  # correct
print(some_cal(2, 2.5))  # float also supported
# print(some_cal("ABC", 2.5))  # string not supported, typeerror


#### 2. DocString ####
class Shape:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Rectange(Shape):
    """Rectangle Shape"""

    _class_variable = 0
    _static_variable = 0

    def __init__(self):
        super().__init__(10, 20)
        pass

    @classmethod
    def class_method(cls, val):
        cls._class_variable += val
        pass

    @staticmethod
    def static_method(val):
        Rectange._static_variable += val
        pass

    def area(self, x: int, y: int | float):
        """Calculate Area

        Args:
            x (int): one side of object
            y (int|float): another side of object

        Returns:
            int | float: multiple of x & y

        Raises:
            TypeError: if x & y not int or float, runtime error
        """
        print(self.x, self.y)
        return x * y


rec = Rectange()
rec.area(3, 2)


#### 3. Enumerate ####
numbers = list(range(1, 4))
for idx, val in enumerate(numbers):
    print(idx, val)

numbers = [num**2 for idx, num in enumerate(numbers) if idx == 2]
print(numbers)


#### 4. List Comprehension ####
numbers = list(range(10))
square = []

# this is not recommended.
for val in numbers:
    square.append(val**2)

## use list comprehension
square_list_comprehension = [num**2 for num in numbers if num % 2 == 0]

## lambda
square.sort(key=lambda x: -x)

# map
numbers_map = list(map(lambda x: x * 10, numbers[:5]))
print("Map return List: ", numbers_map)

## filter
numbers_filter = list(filter(lambda x: x % 2 == 0 and x % 3 == 0, numbers))
print("Filter return List: ", numbers_filter)

# reduce
from functools import reduce

product = reduce(lambda x, y: x + y, numbers)
print("Reduce return int:", product)

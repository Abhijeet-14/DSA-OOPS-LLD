"""
# List vs Tuple:
    - mutable --- immutable
    - memory high -- memory less
    - lookup time high -- less
"""
import sys

a_list = [1,2,3,4,5]
a_tuple = (1,2,3,4,5)

print(sys.getsizeof(a_list), "bytes for the list object") 
print(sys.getsizeof(a_tuple), "bytes for the tuple object")
# Output:
    # 104 bytes for the list object
    # 80 bytes for the tuple object
"""Why?
For Identical List and Tuple memory required is different. 
Because list allocate EXTRA memory block for future extend of size after create.
but Tuple being immutable, keep fixed size.
"""

import time
a_list = list(range(100000))
a_tuple = tuple(range(100000))
s = time.time()
for _ in a_list:
    a = 10
e = time.time()
print("Lookup time for LIST: ", e-s)

s = time.time()
for _ in a_tuple:
    a = 10
e = time.time()
print("Lookup time for Tuple: ", e-s)

"""Lookup is slightly fast for tuple."""
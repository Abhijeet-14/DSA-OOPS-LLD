########################################
# Composite Design Pattern
########################################
"""
- Structural DP

- create Object INSIDE Object

- consider Tree.. node creates inside top node -> ..

- exmaple:
    - Employee
    - Employee -> CEO
    - CEO -> VP1 & VP2
    - VP1 -> Manager1 & Manager2
    - VP2 -> HR1
    -> Manager1 -> Dev1 & Dev2 & Dev3
    -> HR1 -> TA1 & TA2

    - so all are employee only -- but getting created inside employee only.

    - And, Dev1 & TA - are Employee Leaf Node.
    - VP, CEO, Manager, Hr - are Employee Internal Node


Problem:
    - Design FileSystem (File & Directory)
    - Director - can contain Fail and Directory
    - How implement common feature

    - when implement common feature -> Duplicate Code
"""


# Normal Approach
# Filesystem will have File & Directory
class File:
    def __init__(self, name):
        self.name = name

    def ls(self):
        print("File name: ", self.name)


class Directory:
    def __init__(self, name):
        self.name = name
        self.list_of_objects = []

    def add_objects(self, object):
        self.list_of_objects.append(object)

    def ls(self):
        print("Directory name: ", self.name)

        for object in self.list_of_objects:
            if isinstance(object, File):
                File(object).ls()
            if isinstance(object, Directory):
                Directory(object).ls()


dir1 = Directory("D1")

file1 = File("F1")
file2 = File("F2")
dir2 = Directory("D2")

dir1.add_objects(file2)
dir1.add_objects(file1)
dir1.add_objects(dir2)

file3 = File("F3")
dir3 = Directory("D3")

dir2.add_objects(file3)
dir2.add_objects(dir3)

dir1.ls()

from abc import ABC, abstractmethod

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
    _count = 0

    def __init__(self, name):
        self.name = name
        self.list_of_objects = []

    def add_objects(self, object):
        self.list_of_objects.append(object)

    def ls(self):
        print("Directory name: ", self.name)
        for object in self.list_of_objects:
            print("\t" * Directory._count, end=" ")

            ###### Increase Complexity ######
            if isinstance(object, File):
                (object).ls()
            if isinstance(object, Directory):
                Directory._count += 1
                (object).ls()
        Directory._count -= 1


dir1 = Directory("D1")

file1 = File("F1")
dir2 = Directory("D2")
dir21 = Directory("D2.1")


dir1.add_objects(file1)
dir1.add_objects(dir2)
dir1.add_objects(dir21)

file3 = File("F3")
dir3 = Directory("D3")
dir4 = Directory("D4")

dir2.add_objects(file3)
dir2.add_objects(dir3)
dir2.add_objects(dir4)

file4 = File("F4")
file5 = File("F5")

dir3.add_objects(file4)
dir3.add_objects(file5)

dir1.ls()


"""
Problem: 
    - Here Object is generic, dangerous
    - if else to call ls()

Solution:
    - Composite DP
    - create interface
    - keep all COMMON method in interface
    - create respective concreateclass

    - interfface FileSystem
    - File - "IS_A" - FileSystem
    - Directory - "IS_A" - FileSystem
    - Directory - "HAS_A" - many FileSystem
"""


class FileSystem(ABC):
    @abstractmethod
    def ls(self):
        pass


class File1(FileSystem):
    def __init__(self, name):
        self.name = name

    def ls(self):
        print("File: ", self.name)


class Directory1(FileSystem):

    _count = 0

    def __init__(self, name):
        self.name = name
        self.file_systems: list[FileSystem] = []

    def add_file_system(self, file_system: FileSystem):
        self.file_systems.append(file_system)

    def ls(self):
        print("Directory: ", self.name)

        Directory1._count += 1
        for file_system in self.file_systems:
            print("\t" * Directory1._count, end=" ")

            file_system.ls()

        Directory1._count -= 1


print("\n######### With Composite DP #########")
dir1 = Directory1("D1")

file2 = File1("F2")
file21 = File1("F2.1")
dir2 = Directory1("D2")
dir21 = Directory1("D2.1")


dir1.add_file_system(file2)
dir1.add_file_system(dir2)
dir1.add_file_system(dir21)
dir1.add_file_system(file21)

file3 = File1("F3")
dir3 = Directory1("D3")
dir4 = Directory1("D4")

dir2.add_file_system(file3)
dir2.add_file_system(dir3)
dir2.add_file_system(dir4)

file4 = File1("F4")
file5 = File1("F5")

dir3.add_file_system(file4)
dir3.add_file_system(file5)

dir1.ls()

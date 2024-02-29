"""
Given these two dictionaries, write the code to merge them with respect to keys. 
The values should be in sorted order

input1 = {'a':1,'b':2,'c':4}
input2 = {'c':3,'d':5,'e':6, 'f':7 }
# out={a:1,b:2,c:[3,4],d:5,e:6,f:7}

# keys - new dict - a - [1] , c - [3]
"""

# class merge dict -- init() -- merge_2d(dict_1, dict) -- get_new_dict()


class MergeTwoDict:
    def __init__(self):
        self.new_dict = {}

    def merge_two_dict(self, dict_1: dict, dict_2: dict):

        for key, value in dict_1.items():
            if self.new_dict.get(key):
                if isinstance(self.new_dict[key], list):

                    if isinstance(value, list):
                        self.new_dict[key].extend(value)
                    else:
                        self.new_dict[key].append(value)

                else:
                    self.new_dict[key] = [self.new_dict[key]]
                    self.new_dict[key].append(value)
                print(self.new_dict)
                self.new_dict[key].sort()
            else:
                self.new_dict[key] = value

        for key, value in dict_2.items():
            if self.new_dict.get(key):
                if isinstance(self.new_dict[key], list):
                    if isinstance(value, list):
                        self.new_dict[key].extend(value)
                    else:
                        self.new_dict[key].append(value)

                else:
                    self.new_dict[key] = [self.new_dict[key]]
                    self.new_dict[key].append(value)
                self.new_dict[key].sort()
            else:
                self.new_dict[key] = value

    def get_merged_two_dict(self):
        return self.new_dict


merge_two_dict = MergeTwoDict()
input_dict_1 = {"a": 1, "b": 2, "c": [4, 3], "d": 5, "e": 6, "f": 7}
input_dict_2 = {"c": 3, "d": 5, "e": 6, "f": 7}
# {"a": 1, "b": 2, "c": 4}

merge_two_dict.merge_two_dict(input_dict_1, input_dict_2)

print(merge_two_dict.get_merged_two_dict())

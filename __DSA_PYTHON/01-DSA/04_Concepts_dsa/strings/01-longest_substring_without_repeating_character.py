"""
Problem Statement:
    -  Given a string, find the length of the longest substring without repeating characters.

Correct Input:
    Input: "abcabcbb" => Output: 3
    Input: "bbbbb" => Output: 1

Edge Cse Input:
    Input: "a" => Output: 1

Error Case Input
    Input: ""  => Output: 0
    
"""


def find_longest_substring_without_repeating_character(string):
    """
    TC - O(N) && SC - O(N)
    """
    char_set = {}
    start = 0
    max_length = 0

    for end, char in enumerate(string):
        # char in char_set
        #       -- check char already visited
        # char_set[char] >= start
        #       -- check if last occurence of char is within current substring
        #       -- Yes, jump start to after last_occurence
        if char in char_set and char_set[char] >= start:
            start = char_set[char] + 1

        char_set[char] = end
        current_length = end - start + 1
        max_length = max(max_length, current_length)

    return max_length


##### Dry Run
"""
Func(string) ==> Func(abcabcbb)
char_set  ==> {}
start ==> 0
max_length ==> 0

enumerate(string) ==> [(0,a),(1,b),(2,c),(3,a),(4,b),(5,c),(6,b),(7,b)]
end, char => (0,a) ==> (1,b) => (2,c) => (3,a) => (4,b) => 5,c => 6,b => 7,b
char in char_set  ==> F => F => F => T => T => T => T => T
and char_set[char] >= start ==>   =>   => 0>=0  => 1>=1 => 2>=2 => 4>=3 => 6>=5
    start = char_set[char] + 1 ==>  =>  => 0+1=1 =>1+1=2 => 2+1=3 => 4+1=5 => 7

char_set[char] = end => {a-0} ==> {a-0,b-1} => {a-0,b-1,c-2} =>{a-3,b-1,c-2} =>{a-3,b-4,c-2}=>{a-3,b-4,c-5} => {a-3,b-6,c-5} => {a-3,b-7,c-5}
current_length = end - start + 1 ==> 0-0+1 => 1-0+1 => 2-1+1 => 3-1+1 => 4-2+1 => 5-3+1 => 6-5+1 => 7-7+1
max(max_length, current_length) ==> (0,1) => (1, 2) => (2,3) => (3,3) => (3,3) => (3,3) => (3,2) => (3,1)
max_length ==> 1 => 2 => 3 => 3 => 3 => 3 => 3 => 3
return max_length ==> 3
"""

correct_input = "abcabcbb"
edge_case_input = "a"
error_case_input = ""

result = find_longest_substring_without_repeating_character(correct_input)

print("\nO/P: ", result)

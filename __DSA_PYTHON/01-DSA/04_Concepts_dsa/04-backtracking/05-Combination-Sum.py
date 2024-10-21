""" LC - [https://leetcode.com/problems/combination-sum/] """

result = []
def combination_sum(n, arr, target, res):
    """
    TC - O()
    SC - O()
    Approch:
        - 2 possibilites -- one select number -- or ignore no
        - select --> i => i only & target => target - arr[i] 
        - ignore --> i => i+1 & target => target
        - Base Case: target == 0 --> result
        - Edge Case: target < 0 or i < 0 --> invalid move
    """

    if 0 == target:
        result.append([v for v in res])
        return

    if n < 0 or target < 0:
        return

    # Take -- i=i
    res.append(arr[n])
    combination_sum(n, arr, target - arr[n], res)

    # not take -- i++
    res.remove(arr[n])
    combination_sum(n - 1, arr, target, res)


arr = [2, 3, 6, 7]
target = 7

combination_sum(len(arr)-1, arr, target, [])
print(result)


"""
Dry Run:
target = 7, res = [], arr=[2,3,6,7],

[n=0]
    -> 1.) Select --> n=0 & target = 7-arr[0] => 7-2 => 5 || res[2]
        -> 1.) SELECT --> n = 0 & target = 5 - arr[0] => 5-2 => 3 || res[2,2]
            -> 1.) SELECT --> n = 0 & target = 3-arr[0] => 3-2 => 1 || res[2,2,2]
                -> 1.) SELECT --> n =0 & target = 1-arr[0] => 1-2 => -1 == FAIL
            -> 2.) IGNORE --> n = 1 & target = 3    || res[2,2]
                -> 1.) SELECT --> n = 1 & target = 3-arr[1] = 3-3 = 0 --> SUCESS || res[2,2,3]
        
        -> 2.) IGNORE --> n = 0+1 & target = 5 || res[2]
            -> 2.) SELECT --> n = 1 & target = 5-arr[1] => 5-3 => 2 ||
    -> 2.) Ignore --> n=0+1 & taregt = 7
        -> 1.) SELECT --> n = 1 & target = 7-3 = 4
        -> 2.) IGNORE --> n = 2 & target = 7
            -> 1.) SELECT
"""
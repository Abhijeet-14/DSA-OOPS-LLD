"""
Question 1. Plus Mult Array

A is an array of integers described as (A[0], A[1], A[2], A[3],..., A[n- 17. Perform the following calculations on the elements of A

(Reven=(((((A[0]×A[2]) +A[4]) x A[6]) + A[8]) x...) % 2)
(Rodd=(((((A[1]A[3])+A(5)) xA[7]) +A[9]) x...) % 2)
Notice that zero-indexing is used to calculate Reven and Rodd and they are always modulo 2.
You can then use Reven and Rodd to determine if A is odd, even, or neutral using the criterion below:
• If Rodd Reven, then A is ODD.
• If Reven Rodd, then A is EVEN.
If Rodd Reven then A is NEUTRAL

For example, given the array A = [12,3,5,7,13,12], calculations are:
Reven(A[0] *A[2]+A[4]) % 2 = (12*5+13) %2=73%2=1
Rodd (A[1] A[3] + A[5]) % 2 = (3*7+12) % 2 = 33% 2 = 1
1
2
Since both are 1, the answer is NEUTRAL.
Function Description
Complete the function plusMult in the editor below. The function must return a string that denotes the relation: ODD, EVEN or NEUTRAL
plusMult has the following parameter(s):
"""

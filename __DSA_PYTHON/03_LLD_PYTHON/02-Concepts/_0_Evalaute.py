"""
Major Priority of LLD -- is it SCALABLE? rest all not imp

But, How to approach LLD question?
-> Design BookMyShow

##################################
# 4 Step to solve LLD
#################################
1. Clarify & ANALYZE the requirments
    -> find the flow -
        ex -> user -> come to portal -> movies by city -> ...
        -> whatever in the mind of Interviewer - by this try take it out 
        -> interviewer is your CLIENT.
        -> Ask him -> What now? -

    -> Define the Scope
        -> application can have 1000 features, but we don't want all
        -> it mean, define 'features' you are going to support. -> search(), book(). notification()
        -> after this, ask -> is it okay in requirement extraction?

2. List Down Objects
    -> go by flow, and write Objects.
        -> user, portal, movie, theater, seats, screen
    -> clarify with Interviewer -> is it okay? I have covered everything?

3. define Relationship bw Objects
    -> 'is_a' & 'has_a'
    -> define relationship bw objects, created at step 2.
    -> this is 'BruteForce'
    -> Confirm with Interviewer? anything left?

4. SOLID pri + Design Pattern
    -> Optimize Approach of step 3
    -> check for each object -> Scalble?
    -> ask interviewer? - is theater scaleable?
    -> Theater -> NonAcTheater & Theater

Then coding...


#### Cheatcode ####
1. Requirement (interviewer = Client)
    - Find flow
    - define scope - confirm?
2. List of objects
    - missing? - confirm?
3. Relationship
    - Brute-Force
    - confirm?
4. DP & SOLID
    - Optmized of 3
    - scalablity is prioirty.
    - confirm?? each object Scalable?
"""


def fun():
    try:
        a = 1/0
    except Exception as e:
        print(1/0)
    finally:
        print(e)

fun()               
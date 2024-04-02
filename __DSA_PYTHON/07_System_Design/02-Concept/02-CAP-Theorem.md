# CAP
- Desirable property -- for Distributed System -- with REPLICATE data

- C: Consistency || A - Availability || P - Patriation Tolerance (PT)

- Example System:
    - A(app) ---> B(DB)
    - A ---> C (DB)
    - B <---> C

## C
- if B change --> b also change C .. so everywhere data is same

## A
- if System is UP --> then both B & C be UP ... same data not needed.. but UP

## PT
- if conn. bw B <--X--> C, even then --- my WHOLE system should be UP
    - able to TOLERATE the partition


# combo of CAP - not Possible
- bcoz in PT ---> C break


## if C drop
- AP -- B <--> C

## if A drop
- CP -- if PT happend B <--X--> C, and C is needed ---> then drop DB(C).
- so A is dropped

## if PT drop
- CA -- if no PT -- and all node A and C is also followed. --> so system need to be DOWN --> PT recovered


# In real world -- PT is must
- if any node is DOWN -- System should not be down -- System must UP

 
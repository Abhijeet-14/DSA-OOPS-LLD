
# Strangler Pattern (VI)
- use to REFACTOR mono to MS
- Strangler (Gala Ghotna)

- we can't directly Transfer -- 100 % mono trafic to MicroService
- we add controller in between
    -  Mono <--- Controller ---> MicroService
        - Controller -
            - first give 10% traffice to MS
            - then 20%
            - if FAIL -- give all to MONO
    - Once 100% transfer is DONE -- Kill Mono


# Data Management
- What DB should we Use
1. Shared DB (Common DB for all Service)
2. DB per Service

## 1. Shared DB
    s2 --> DB
    s2 --> DB
    s3 --> DB

- Easy to ACID
- Easy to JOINs
- but - Point 1
    - if load on S2 increase -- then DB scale -- so new Replica of DB
    - but S3 & S1 table is still very less -- in replica also it will less
    - so bcoz of just S2 -- Whole DB replica happen -- Costly
- but - Point 2
    - so modification in S3 -- delete Column2
    - but Column2 -- might needed in S1 & S2
    - so Very Hard to Modification

## 2. DB per Service
    s2 --> DB_1
    s2 --> DB_2
    s3 --> DB_3

- Easy to Scale
- Easy to Modify
- But
    - Not Possible to ACID
    - Not Possible to JOINs

- Solution is:
    - ACID --> SAGA
    - JOINs --> CQRS

# SAGA (VVI)
- Sequence of Local Transaction

- we maintain "Success Event" & "Failure Event" --
    - and if any Fail Txn -- all Success Event -- ROLLBACK

S1[DB1]                     S2[DB2]                         S3[DB4]             S4[DB4]
    --> Succ Event (T1) -->          --> Succ Event(T1) -->       (T1 Fail at S3)
    <-- Fail Event (T1) <--          <-- Fail Event(T1) <--       <----

- so on success it keep Txn -- and when Fail -- they now which Txn Fail --> ROLLBACK that Txn

- 2 ways
    - Cheoregraphy
    - Orchestration

## 1. Cheoregraphy SAGA
- Create 2 Event Queue (Success Q, Fail Q)
    - all Service Listen to these 2 Q
    - if any Fail --> ROLLBACK all Success Txn

            <-----> S1
    Sucess Q
            <-----> S3
    Fail Q    
            <-----> S2
    
    - if success Txn -- update Success Q -- and Fail --> Fail Q
    - and when Fail Q -- Roll Back all Txn

- Drawback:
    - Circular Dependency
        (s1-->s2-->s3-->s1)
        
## 1. Orchestration SAGA
- to break Circular Dependecy
- We add Event Controller
- and this Controller call Each Service 
    - if Success -- store
    - if Fail -- Rollback ALL

            -------> S1
    Controller (S1-ok, S2-ok, S2-Fail)
            -------> S2
            -------> S2 -- Fail
    
    hence ROLLBACK all S1-ok and S2-ok

- Example: A ---Pay(10rs)---> B
    - For A
            -----> Balance [100] --(-10)--> [90]
        CTRL (B-Ok, P-Fail)
            -----> Payment [Pay_B] -- FAIL

    - So ROLLBACK --> Balance become [100]


# CQRS
- Commnad (Create|Update|Delete)  | Query (Select)  | Request   | Segregation

    s1 --> DB1[Table1]
    s2 --> DB2[Table2]
- join bw Table1 & Table2 -- Not Possible
- Solution -
    - do all WRITE Operation(create, update, delete) in Respective Service DB
    - But, do all READ op -- in 1 Common DB -- View DB
    - View DB has both table -- hence JOIN

    s1 ---Write---> DB1[Table1]  
            ---Read---> View_DB (Read-Only)
    s2 ---Write---> DB2[Table2] 

- BUT, how to update View_DB on change in any Table (T1, T2):
    - we add Event Handler -- which LISTEN t1 & t2 on any new write
    s1 ---Write---> DB1[Table1]  
            ------Read------> 
                --- [Event_Handler(DB1,DB2)] ---Write---> View_DB (Read-Only)
            ------Read------> 
    s2 ---Write---> DB2[Table2] 
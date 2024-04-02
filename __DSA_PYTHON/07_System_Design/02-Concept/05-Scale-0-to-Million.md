# Scale from ZERO to MILLION users
1. Single Server
2. Application & DB Separation
3. Load Balancer + Multi App Server
4. DB Replication
5. Cache
6. CDN
7. Data Centre
8. Messaging Queue
9. DB Scaling


## 9. DB Scaling
- DB 
    1. Vertical
    2. Horizontal

    - Vertical --> Increare RAM, CPU
    - Horizontal --> DB, DB, DB, DB...

- Horizontal --> implementaiton "Sharding"
    1. Vertical Sharding - Divide Multi-Table by Column
        - Table(Col_1, ...., Col_10)
            - T_1(Col_1, ..., Col_5)
            - T_2(Col_6, ..., Col_10)

    2. Horizontal Sharding - Divide Multiple Table by Row
        - Table(Row_1, ....,Row_1000)
            - T_1(Row_1, ....,Row_500)  
                    --> say, All name from A-P --> go in T_1
            - T_2(Row_501, ....,Row_1000)
                    --> say, All name from Q-Z --> go in T_2

        - Now Drawback:
            - is say user with name 'A' -- is 700 -- then??

            - again Divide T_1
            - T_1(R_1, ...., R_500)
                - T_1_1(R_1, ...., R_400)
                - T_1_2(R_401_, ...., R_800)
            - Now T_1_1 - is very High
            - then Again divide T_1_1
            - this CONTINUE -- infinite

        - Solution: Consisten Hashing   

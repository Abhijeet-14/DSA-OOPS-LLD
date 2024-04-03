# Back of Envelop Estimation
- Need: it DRIVE our Design CHOICE
- Consideration:
    - do ROUGH estimation
    - don't SPEND much time (5-10min)
        - it doesn't matter to Interviewer -- they want High Scalalility -- that's it.
    - keep Assumption SIMPLE -- multiple of 10


## Cheat Seat 1
            Traffic  | Storage
3 zeros  |  Thousand | KB    
6 zeros  |  Million  | MB    
9 zeros  |  Billion  | GB    
12 zeros |  Tera     | TB    
15 zeros |  Qauli    | PB    

## Cheat Seat 2
char - 2 B (byte)
long/double - 8 B
Image - 1 MB


## Target to Find
- RAM 
    - it tell cahce size -- no of cache machine
- Storage
    - it DB Size
    - sometime, CDN Size
- sys load - QPS
- No of servers 

## How to Calculate
- X Mn User * Y MB -> X*Y * Mn*MB -> X*Y * (10^6*10^6) -> X*Y 10^12 B -> XY TB
- 5 Mn user * 2 KB -> 10 * Mn*KB -> 10 GB


# Example: Estimate Facebook
1. Traffic Estimation:
    - total Users - 1 Bn
    - DSU  - 300 Mn
    - Daily QPS - ??

    - Say per user/day -- Read is 5 & Write is 2
        - so 7 Query/day 
        - 7 * Query/(86400) sec
        - 7/100000 QPS

    - So, 
        1 user - 7/10^5 QPS
        250 Mn user - 250 * 7/10^5 * Mn - 250*7*10 - 3*7*1000 - 21 K QPS

2. Storage
    - Every user make 2 post - (1 post - 250 char)
    - 10% of Useer make 1 Image - (1 Image - 1MB)

    - 1 Post - 250 char - 250*2 - 500 B
    - 2 post - 2*500 B - 1 KB
    so,
    - 300 Mn user * 1 KB = 300 * Mn*KB = 300 GB / day

    - 30 Mn user(10%) * 1 Img = 30 Mn * 1 MB = 30 TB

    - FOr 5 Year
        - 5 yr - 365 * 5 day - 2000 day
        - post - 2000 * 300 GB  - 600 TB
        - Image - 2000 * 30 GB - 60 TB

    - DB - 600 TB
    - S3 - 60 TB

3. RAM
    - say RAM cache last 5 post / user
    - 1 post - 500 B --> 5 post - 2500 B - 3 KB
    - 300 Mn user * 3 KB - 900 GB
    so,
    - if 1 machine cap is 90 GB ram
    - then 10 machine -- for 900 GB

4. No of Server
    - total load 21 K QPS
    - 1 server - 100 QPS
    so,
    - 210 Server - 21 K QPS

## Final Estimation
    - RAM - 900 GB - 10 Machine (90 GB each)
    - Storage - DB - 600 TB
            - S3 - 60 TB
    - No of server - 210 (for 21 K QPS)


3. Ram
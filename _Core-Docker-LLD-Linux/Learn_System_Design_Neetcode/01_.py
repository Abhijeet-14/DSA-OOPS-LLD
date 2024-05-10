"""
Vertical Scaling -- add more resource to a server(ram or Cpu) -
                    - it is easy -
                    - but it limited -
                    - and if it fail -
                    - everything is down 
                    - SINGLE POINT OF FAILURE

Horizontal Scaling -- add replica of servers
                    - scale infinte
                    - don't need good machine
                    - if 1 down -- others take charge

Load Balancer -- How to insure no replica of server it ideal
                - use Load Balancer(Reverse Proxy), it just a server
                - it directs incoming request to -- to less load server
                - algo -- like round-robin -- in this we cycle thro server -- add to less load server

Content Delivery Network -- if multiple server is located at multiple corner of word -
                            - we can use load balancer to transfer to nearest location
                            - this is -- Content Delivery Network
                            - if you are just using Static FIle(HTML, CSS, JS) -- keep them in CDN
                            - CDN take file from your server - and copy to their own multiple server
                            - don't run business logic

Caching -- just like CDN -- network request is expensive -- so browser keep a Copy of request
        - if same request made again -- it return from Cache -- for Faster

Internet ProtoCol -- Every computer is assign an IP address -- uniquely identify computer on a network
                    - TCP/IP -- internet protocol suite -- IP, TCP, UDP
                    - RULE -
                        - when send a file -- broke down to small pocket -- 
                                            - when arrived they are rearrange on packet number
                                            - if some packet missing -- TCP request again
                    - lile HTTP & websocket are build on TCP

DNS - domain name system -
    - it work is to transfer human-name-website to Ip address
    - when we type a website -- it get ip address from DNS -- and cache to Browser, Wifi, etc.

HTTP - hyper test transfer protocol
        - this appilication level protocol -- simplified version of TCP for Human
        - client - server model
        - request -- header + body
        - header -- like in your delivery packet -- shipping level -- the address of customer
        - body -- actual product which customer ordered

REST - it is STANDARDization of HTTP api
    - it is stateless -- that all the required content is availble on request

GRAPHQL - make single request -- and fetch as per need.
        - no over or under fetching

WebSocket - for ex Chat App -
            - if use HTTP -- we need polling -
                            - make request to server periodicaly -- to check any new message has come.
            - but webshocket support - BiDirectional-Communication 
            - it immediatily pushed to target user.

SQL - to store data -- 
    - but why not store data in file 
            - by DB we can store efficiently -- using DS like B-Tree
            - Fast & Powerfull Read of Data using SQL query
            - in SQL - data in syncronized and store in rows

ACID - Relational DB is ACID complient
        - D - durability -- data is stored in disk -- even if machine re-start -- data will be there
        - I - Isolation -- different transaction request at same time -- won't confict which each other
        - C - Consistency -- FK, Unique etc - will always be enforced. --  
        - A - Atomicity -- every transaction is ALL changes or Nothing.

NOSQL - Consistency makes harder for scale -- so nosql drop this constraint
        - key-value store - MongoDB
    
Sharding -- if no-relation -- that mean we can break the data into chunck -
                            - and scale it horizontal with diff machine
            - this is sharding
            - we have shard-key -- on that we put on respective shard-machine
            
Replication - sharding is complex -- simple approach is replication
            - make a Read only DB & other Write DB
            - every Read call will goto RO-DB
            - only write call will goto W-DB
            - if we have replica of Write-DB & Write-Db -- this will lead to inconsistent

CAP Theorem - Consitency -- 
            - Availabilty -- 
            - Partition -- 
            - only 2 can be paired

Message Queues -- request to server is made on Queues -- use FIFO




"""

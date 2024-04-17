# ARP:
- finds Physical Address(MAC) of IP
    - sender send REQUEST to all Network
    - each receive --> target respond
    - target send ARP back to Sender

# API Gateway
- single ENTRY/EXIT point for all API

# SSL/TLS
- SSL - Secure Security layer
- TLS - Transport Layer security

# Proxy & Reverse Proxy
- Proxy: middleman bw Client & Server. Send request to Server on behalf of client
- Reverse Proxy: sit infront of server -- forward client request to server. -- give Security

# Virtual IP
- it purpose to provide IP, which can used in network communication

# Caching
- temporary Storage of data

# Containerzation vs Virtualization
- both create Virtual Package
    1. VM 
        - copy of hardware of physical computer with complete OS
        - like running "mulitple Computer" with multi OS
    2. Container:
        - shares Kernel of Host OS with container
        - shared OS is Read Only
        - light weight

# Latency vs ThroughPUT
- Latency - time taken for packet travel
- throughPut - quanity of data send/receive in UNIT time.


# VPC
- public cloud - offers as - private cloud for limited IP
- e.x, ip range - 10.2.0.0/16 --> means --> 10.2.0.0 - 10.2.255.255
- subnet? - range of IP 


# CN:
- Packet: small small unit of data.
- Packet Header: it holds info/content/origin/destination etc of packet.
- Jitter: delay in sending/receiving data.
- frame: small unit of packet


# Network Layer:
1. Physical: 
    - lowest level, reposible to transmit data from "Physical sender device" to "Physical Receiver Device"
2. Data Link: 
    - respo for encode/decode of data, most complex
3. Network:
    - respo for sending form Origin to Destination
    - decide which route to take - 'Routing'
    - IPv4 vs IPv6
        - v4: 1st version, 32 bit, carry 94% traffic
        - v6: 128bit (2^128)
4. Transport:
    - data called "Segment"
    - respo - End-2-End delivery of complete msg, ACK for success and in error re-transmits
    - TCP - every call need to establish connection in order to communicate
    - 3-Way Handsake: 
        1. SYN - client send segment with SYN (Sync Seq No.)
        2. SYN+ACK - server respond to client with SYN + ACK
        3. ACK - client receive ACK, hence connection Success
    - UDP - user datagram protocol
5. Session
    - respo for connection establishment(Authentication)
6. Presentation
    - respo for 'data extraction' and used as per need
7. Application
    - user interact


# DNS
1. Working:
    - check browser -> local machine -> router -> ISP -> DNS Server
2. DNS use UDP, not TCP?
    - TCP is time expensive, 3-handsake
    - dns don't need connection, hence UDP

# How Packet Travel:
- A ---> Switch_1 ---> Router ---> Switch_2
    1. A send data(SRC: A, DEST: D) to Switch_1
    2. Switch_1 find MAC add of 'D'
    3. Switch_1 send to Router
    4. Router send to Switch_2
    6. Switch_2 receive data by 'A'
    7. send data to 'D'
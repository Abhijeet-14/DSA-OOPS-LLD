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
        1. client send segment with SYN (Sync Seq No.)
        2. server respond to client with SYN + ACK
        3. client receive ACK, hence connection Success
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
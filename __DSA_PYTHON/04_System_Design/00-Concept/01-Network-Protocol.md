# Network Protocol:
- define rules, so 2 device can talk.

# 7 Layer
1. Application
2. Presentattion
3. Session
4. Transport
5. Network
6. Data-Link
7. Physical

## Application
1. Client Server
    - HTTP
    - WebSocket
    - FTP
    - SMTP - send mail & IMAP-receive mail

2. Peer-2-Peer
    - WebRTC

## Client Server
- client -> make request -> server response
    - Client ---> Server
    - server NEVER request, client <---Not Allowed--- Server

## WebSocket
- its Bi-Direction
- client request -> server response
- server request -> client response
- Client <--> Server

    - its not P2P
    - bcox ... C1 <--> Server <--> C2
    - but C1 -- NEVER talk directly -- C2

    - Use, C2 -> send for C1 
    - server tell C1 -- you have new thing, check --> C1 call Server


## SMTP-IMAP
- User1 --> MTA Client --> MTA Server --> User2 



# Peer-2-Peer
- C1 <--> Server <---> C2 
- C1 <--> C2
- anyone can talk to anyone



# Transport Layer
1. TCP/IP
    - in this, data send in Packet with seq
    - D1, D2... Dn --> |---connection---|
    - when receive other END, send ACK back
    - order of data is maintain
    - if D3 miss.. it re-send

2. UDP/IC
    - it Fast
    - no ordering maintain
    - no connection - ConnectionLESS
    - no ACK
    - if lost, no re-try
    - sender send data [with DEST address]
    - router send data furthe, no checking
    - reciever receive --> no handsake -> direct execution

    - Use - Live Streaming
    
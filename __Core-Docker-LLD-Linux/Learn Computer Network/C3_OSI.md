# What is OSI?

    - Open Systems Interconnected Model
    - It is a conceptual model
    - It describes "7 LAYERS" that computer system 'use' to communicate over a network.

# 7 Layers: PDNTSPA

    - Physical
    - Data Link
    - Network
    - Transport
    - Session
    - Presentation
    - Application

# PHYSICAL - LAYER 1

    - Lowest level of OSI.
    - responsible to transmit data from "Physical layer of sender device" to "Physical Layer of Receiver device".
    - e.g., hubs, modem, cables etc.

# DATA LINK - LAYER 2

    - responsible for node-to-node delivery of data
    - role is to ensure error-free data transmission
    - responsible for encode, decode & organize outgoing & incoming data.
    - most complex layer
    - 2 sublayer:
    - LLC (Logical Link Control): responsible for error msg & acknowledgement msg.
    - MAC (Media Access Control): manage device interaction, responsible for  addressing frames & also controls Physical Media Access.

    - DDL receives data in form of "Packets" from Network Layer & it "divides" Packet into "frames" & send those frame "bit-by-bit" to next layer - physical layer.

- ## What is Ethernet?

  - q
- ## Extranet vs Intranet vs Internet
- ## Virtual ckt vs Datagram Network
- ## Switch & its types
- ## What is virtual LAN?
- ## Basics of Wifi

# NETWORK - LAYER 3:

    - funtionality: transfer network data packets from SOURCE to DESTINATION w/o chaning and using it.
    - if packets too large, divide into smaller packets.
    - it decide which route to take by packet to travel from SRC to DEST among Multiple Routes. Called 'Routing'.
    - it encapsulate in datagram and send to Data Link Layer.
    - it decapsulate the datagram and send to Transport layer.

- ## IP Addressing?

  - an unique address that identifies a device on the internet or local network. Internet Protocol.
- ## IPv4 vs IPv6?

  - IPv4: first version of IP.
  - has 32-bit address space (2^32)
  - carries 94% of internet traffic.
  - use numeric address method
  - offer 12 header field.

  - IPv6: this version is to fulfill the need for more Internet address.
  - 128-bit address space(2^128).
  - use alphanumeric address method
  - offer 8 header fields
- ## Supernet?

  - When multiple networks are combined to form a bigger network, it is termed super-netting
- ## Types of routing(Static, Default, Dynamic)
- ## Network Adress Translation, NAT
- ## WPA vs WPS

  - WPS: Wifi protected Setup
  - WPA: Wireless Protected Access.
- ## LiFi vs WiFi

  - both are used to send & receive data wirelessly.
  - Lifi - Light fiedilty: transmit data using light by help of LED bulbs
  - Wifi - Wireless fiedilty: transmit data using radio waves & wifi router
- ## What is ACL(Access-list)?
- ## AAA in networking [Important]
- ## SONET

# TRANSPORT - LAYER 4

    - data in TL is called "Segment".
    - responsible for End-2-End delivery of complete msg.
    - it provides ACK(Acknowledgement) for success.
    - and re-transmits data if error found.

- ## TCP Connection setup

  - TCP: Transmission Control Protocol
  - every call needs to establish a connection in order communicate.
  -
- ## 3-way Handshake

  - client sends segment with SYN(Synchronize Sequence Number), which server need to start communication
  - server respoint to client with [SYN + ACK]
  - client [ACK]acknowledges the response from server & hence establish a reliable connection.
- ## UDP

  - User Datagram Protocol
- ## Peer2Peer Sharing

  -
- ## Congestion in Computer Networks
- ## Error Control

# SESSION - LAYER 5

    - This layer is responsible for the establishment of connection, maintenance of sessions, authentication, and also ensures security b/w sender & receiver.

# PRESENTATION - LAYER 6

    -  The data from the application layer is extracted here and manipulated as per the required format to transmit over the network

# APPLICATION - LAYER 7

    - through AL user interact, it provide service to USER.
    -

- ## Protocols in Application Layer

  - TELNET - TELetype NETwork
  - FTP - File Transfer Protocol
  - TFTP -
  - NFS
  - SMTP
  - DNS - Domain Name System
  - DHCP - Dynamic Host Configuration Protocol.
- ## DNS

  - DNS is host name for IP Address.
  - DNS is distributed DB implemented in heirarchy of name servers.
- ## Why does DNS use UDP and not TCP?

  - TCP is relieable, but UDP is not. But why DNS use UDP?
  - UDP is much faster, bcoz TCP requires 3-way handshake.
  - Load on DNS server is important factor. Hence, DNS don't keep connections. But TCP will keep the connections.
- ## Address Resoultion in DNS

  - Mapping a domain name to an IP Address is known as Name-Address Resolution
  - it check browser -> local machine -> router -> ISP -> if all fails call DNS server.
- ## DNS Spoofing or DNS cachr poisoning
- ## Types of DNS Attacks
- ## Diff b/w http & https
- ## How DHCP server dynamically assigns IP address to a host?

# HOW PACKETS TRAVELS? [V.V.V.Important]

    - Example: A sends data to D
        A ---                               ----- C
            SWITCH_1 ---- ROUTER ---- SWITCH_2
    B ---                               ----- D

    - A will get IP of D with help of ARP(Address Resolution Protocols).
    - A will send data to SWITCH_1, with SRC:A_IP & DEST: D_IP.
    - SWITCH_1 try to find MAC_Add of D, if available call internally - no need to call router and Internet.
    - if not available, send to ROUTER
    - Router try to find host with DEST:D_IP -> once got.
    - send to SWITCH_2 -> it finds MAC of D
    - And send Packet to D.

    - Now, Response will travel back to A in same manner.



# TCP/IP
  - Transmission Control Protocol/Internet Protocol
  - TCP/IP model is CONCISE version of OSI model
  - Contains 4 layer
    - Application Layer
    - Transport Layer
    - Internet Layer
    - Network Access Layer

    1. Network Access Layer:
      - Data Link Layer + Physical Layer

    2. Internet Layer
      - Network Layer

    3. Transport Layer

    4. Application Layer:
        - Session + Presentation + Application
        - Protocol of Application Layer:
          - HTTP
          - SSH - secure shell
              - maintain encrypted connection
          - NTP - Network Time Protocol
          

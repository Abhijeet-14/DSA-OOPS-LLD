# Common Networking Commands

    - PING: e.g., ping googl.com
    
    - NetStat: The netstat provides the statistics and information in the use of the current TCP-IP Connection network about the protocol
        > netstat

    - Tracert:

    - Ip-Config:The command IP config will display basic details about the device’s IP address configuration.
        > IpConfig

    - Ns-Lookup: name server lookup command, 
            - It provides name server information for the DNS
            > Nslookup google.com

    - Route:
        - In IP networks, routing tables are used to direct packets from one subnet to another
        > route print

    - Pathping:

    - netDiag:

    - hostname: To communicate with each and other, the computer needs a unique addres, this unique address has given name - hostname
        > hostname 

    - Arp:
        -  Address Resolution Protocol
        - the actual communication happens over the physical address (MAC address)
        - ARP,  finds physical addresses(MAC) of a host IP Adress.


# Diff b/w http & https?
    - S: HTTPS is more secure.
    - both use to exchange data b/w webserver & webbrowser
    - HTTP - used in Applicaiton Layer
            - bcoz, it exchange data in plain-text, not secure -> not usefully in Other layer.
    - HTTPS: used in Transport Layer
    - speed http > https : bcoz http call internally only.

# What is API Gateway?
    - It provides a single ENTRY/EXIT point for all API calls that come into applicaiton. then directed to applicaiton.

# SSL/TLS
    - SSL: secure security layer
    - TLS: Transport layer security, 
    - TLS is successor of SSL
    - SSL/TLS is a Protocol for establish authentication & encrytption link b/w networked computers

    = SSL CERTIFICATE:
        - it is a digital certificate that bind the identity of website into cryptographic key consist Public & Private Key.

# Reverse Proxy
    - Proxy - b/w cleint request & web server - proxy is middleman. and send request to server on behalf of client.
            - proxy sit in front of client
    - Reverse proxy: it is server that sits in front of Web Server & forward client request to web server.
        - it increase security, performance & reliability.
        - reverse proxy sit in front of web server.

# Load Balancer
    - efficient technique to distributed incoming network traffic accross group of Backend Server

# ARP
    - ARP,  finds physical addresses(MAC) of a host IP Adress.
    - 2 step process - request & response
    - sender sends ARP request & broadcast to all network.
    - each will receive & check whether they are target or not. if not discard it.
    - target sends ARP response(with MAC Adress) back to sender.

# Horizontal vs Vertical Scalling
    - VS: attempt to increase the capacity of Single machine.
    - HS: adding extra hardware with same configuration.

# Caching & How does a website is cached
    - Cache is any "temporary storage" location for copies of files or data.
    - How website is cached?
        - when user loads the webpage for first time, it download lots of data.
        - so browser store it in cache
        - in future call, it try to retrive most of them from cache for faster loading

# What is VIP in Computer Network
    - VIP - Virtual IP
        - its purpose to provide IP, which can use to communi in network. 

# REST Api vs HTTP API
    - HTTP is a protocol used for communication
    - REST is 1 way of HTTP call.
    - REST is stateless - all value required for server are contained in request. no need to depend in any other state.
    - 
# What is container in CN?

# Containerization vs Virtualization
    - Container & VM both are software technology to create self-contained Virtual Packages.
    - VM
        - VM, is copy of hardware of physical computer with "complete OPERATING System".
        - VM, it is like "running multiple computer" with "multiple different" OS on the hardware of single physical computer/server. 
    - Container
        - it shares the kernel of host OS with other containers.
        - and shared part of OS is read-only.
        - container are light weight
        - can deploy multiple server in 1 single server.
        - only OS needs to maintain.

# Performance vs Scalability
    - Performace - capability of system to provide a certain response time.
    - Scalability - by adding extra resource to system in order to increase performace of system.

# Latency vs Throughput
    = Latency – The time taken for a packet to be transferred across a network. 

    = Throughput – The quantity of data being sent and received within a unit of time.

# 2G vs 3G vs 4G vs 5G
    - 2G: bandwidth 64kbps
    - 3G: 144kbps - 2Mbps
    - 4G: 100Mbps - 1Gbps
    - 5G: >1Gbps

# How VPN works?

# Gateway vs Router?

# NIC and MAC Address

# Public vs Private IP address
    - Private IP: Private IP address of a system is the IP address that is used to communicate within the same network
    - Public IP: public IP address of a system is the IP address that is used to communicate outside the network

# What is Multiplexing?
    - Multiplexing is a technique used to combine and send the multiple data streams over a single medium. 
    - The process of combining the data streams is known as multiplexing 
    - and hardware used for multiplexing is known as a multiplexer.

# Modem vs Router

# How Bluetooth works

# How Hotspot works

# How Email works

# How file transfer works

# How ATM works

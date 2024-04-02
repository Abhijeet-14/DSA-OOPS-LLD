# Q: Migrate from Monolith to Microservice?

## Step 1: Assess current Mono & its Pain-Point
- get all its components
- its dependency
- its functionalities

- Pain-Point
    - in scalbility
    - slow deplyment cycle
    - diff in maintain codebase

- goal of MicroService
    - improve Scalibility
    - better fault tolerent
    - faster deplyment cycle

## Step 2: Decomposition
- identify how component should be break into smaller Service
- by business capability 
- by Sub-Domain

## Step 3: Design MicroService
- design each service to be INDEPENDENT
- have its own indepenent DB and its type (SQL/NoSQL)
- its own APIs (Sync[HTTP] or Async[Messaging_Queue])
- ensure Fault-Tolerance by Retry mechanism and removing SPF(Single Point Of Failure)

## Step 4: Data Management
- give one Common ACID -- by SAGA
- give easy JOIN over multi-DB -- by CQRS

## Step 5: Ci & Cd
- use K8 or Docker for CI & CD

## Step 6: Testing

## Step 7: Monitoring
- logging of each service

## Step 8: Incremental Traffic Migration (Strangler)
- slow transfer traffic -- like Strangler way
- also transfer 1 service complete -- then other
- finally, Delete Monolith 



# Monolith to Microserver

## DisAdvantage of Monolith
- Overload IDE
- slow code deployment
- Scalbility hard
- Tight Coupled
- hard to fix bug
- if S1 is in Bn traffic, and rest S2, S3 is in K's only
    - then unwantedly - just to scale S1 -- we end up scaling WHOLE service
- 1 line code -- force re-deploy of 10 Gb code


# MicroService

## Advantage of MicroService
- all disadvantage of Monolith -- is Advantage of MicroService
    - managing Component is EASY
    - Scale EASY and Independently
    - Loose Coupled
    - Easy to Debug & Deploy

## DisAdvantage of MS
- Hard to break down into component -
    - so all are independent(Loosly coupled)
- Latency -
    - if not loosly coupled -- cross communication is there -- hence LATENCY
- hard to modification -
    - if S1 depend on S3 -- but S3 has new change -- this new change can Cause BREAK in S1 
- Transaction Management HARD
    - all service has Own DB -- they have Local ACID
    - but NO common ACID
    - if a Txn hit multiple DB -- then ROLLBACK -- Not Possible
- Hard to JOIN
    - as Each Table is in OWN DB. -- cross join bw DB not possible.


## Solution
- Decomposition Pattern
    - by Business Capability
    - by Sub-Domain
- Strangler Pattern
- Data Management in MS
    - DB per Service
        - SAGA
        - CQRS
    - Shared DB

# Decomposition
- 2 way to break down from Mono to Smaller Services

## 1. By Business Capability
- Example - E-commerce
    - it has Order, Inventory, Payment, Billing
    - so by break by this
        - Order Service
        - Inventory S
        - Payment S
        - Billing S

- Challenge -- be Clear with ALL business functionality

## 2. By Sub-Domain
- Order has Tracking, Allocation, Delivery
- Payment has Forward, Refund
- So break by Sub-Domain
    - Order
        --> Tracking Service
        --> Allocation S
        --> Delivery S
    - Payment
        --> Forward Payment Service
        --> Refund S



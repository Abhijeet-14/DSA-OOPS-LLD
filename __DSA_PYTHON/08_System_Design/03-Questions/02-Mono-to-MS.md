# Q: Mono to MS by JPMC?
Question: There is a exsiting system so we have to improve the exsiting monolith architecture so that it can handle
50x traffic and second was we have a prediction model and a prediction service we have to integrate these two feature in our exsiting system.

PS: It was a 45min round, where the interview clearly mentioned that first 20 mins is to prepare the block diagram and the next 25 mins will be discussing the approach.


## Step 1: Assess current Mono & its Pain-Point
- get Component, Dependency, functioanlity
- get Pain-Point (in Scalbility)

## Step 2: Scale to 50x Traffic
- break into small Service -- its own DB
- add Load-Balancer, Caching and CDN to each required service
- scale service & DB by replca to remove SPF
- fast query with indexing of DB

## Step 3: Integrate Prediction Model & Service
- get How prediciton model & service -- currently structured -- how they interact
- identify Integration Point where Prediction is Needed
- implement API to get Prediction
- if service is Resource-Heavy -
    - create separate service and call by REST or Messaging Queue
- if light-weight 
    - integrate in service
- ensure Fault Tolerance

## Step 4: Incremental Traffic Migration (Strangler)
- slowly migrate to MS -- by stragnler pattern
- if success -- ok
- else rollback to Mono for particular service

## Step 7: Monitoring
- add logging
- add alerts
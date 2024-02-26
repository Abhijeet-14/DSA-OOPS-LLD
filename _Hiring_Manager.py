"""
CV - Project wise
SQL
Team player
Why join
Why Change?
why hire
what value you will bring?
Do you've any question for me?
"""

"""
    Why Join?
        =>

    Why Change?
        => entered the software industry with intern and Fulltime
        => here I learnt from scratch to a intermediate level.
        => but most of the projects are of same fashion
        => hence I am thinking of expanding my domain and career growth
        => and product based company like tekion 
        => it will be the perfect place for me to acheieve these things.

    NOTE: "Why Join" == "Why Change" -- Same question
    ----------------------------------------------------------------

    Why hire you?
        => 

    What values you will bring?
        => self and quick learner
        => problem solving skills 
        => with technical experience in python and cloud services
        => also I standby team in all odd situation with adaptibilty and innovation, and 
        => I can be effective team contributer for the team.
        => not just code, I also try to understand business POV.
        => sticking with problem longer and try to subdivide such that it will become acheivable

    NOTE: "Why hire you?" == "What values you will bring?" --- SAME QUESTION
"""

"""
CV - Project wise

1. Marketplace:
    Gaurav Defin:
        1. Deloitte has a good reach to customers and creation of this kind of platform will help AWS to get more business.
        2. Companies like Deloitte have multiple Account(talking about seller account), managing product onboarding in these accounts is not possible from one place user has to log into diff account to get the details, here we are solving this problem.
        3. Public URL Problem with AWS Geofencing(Dis-allowing users across location to use public offer in AWS), 
        4. Generation customer registration form
        5. product being showcased from Deloitte in AWS Reinvent last year.

    ReInvent PPT:
        
    Q1) Can you share more about your role in integrating with AWS Marketplace APIs at HASHEDIN?
        Answer => BE - developing solution by which any non-tech person also can list their products on AWS MP.
                => b2b interactions with Marketplace api, other aws services.
                => PR reviews, continous mergeing

    Q2)  What challenges did you face, and how did you address them?
        Answer => 1 challenge was that when send the required payload to AWS, 
                    the error response is NOT very understandable 
                    and also product creation take roughly 2-5 min.
                    so to handle this error, as per their doc, we make json-schema 
                    with whom we match the payload and make sure before hitting AWS api we will get the error.
        Answer => creation flow has many steps -- first under-review > Failed 
                            > preparing > Applying > Succeded
                    this take roughly 2-5 min
                    so we store the request_id and call check status from user front
    
    Q3)  Can you provide an example of a challenging situation you encountered 
        while guiding your team and how you effectively addressed it?
        Answer => Yes, as they all are fresher -- not well aware of error handling
                        -- clearing their doubts on requirements
                        -- code review 
                        -- merge flow
                        -- but I knew guide them properly as my senior did to me
                        -- later their are able to cover this cases on their own.

    
    Q3) Can you elaborate on the design considerations you undertook while creating 
        end-to-end APIs for AWS Marketplace functionalities?
        Answer => REST, API Contract with FE based on requiements, Payload, Method, API flow, headers 

    Q4) How did you ensure the APIs were efficient, scalable, and user-friendly?
        ANSWER => documentaiton, SWAGGER(docmentation tool - gives UI)

    Q5) How did you address authentication challenges in the context of AWS Marketplace APIs? 
        ANSWER => get aws account role_arn, --> assume role --> create respective client --> call

    Q6) What testing strategies or frameworks did you employ to validate the functionality, and how did you handle potential issues or regressions?
        ANSEWR => pytest
            ```
            from unittest import TestCase

            class TryTesting(TestCase):
                def test_always_passes(self):
                    self.assertTrue(True)

                def test_always_fails(self):
                    self.assertTrue(False)
            ```

    Q7) Can you share your approach to code reviews, particularly in the context of addressing vulnerabilities during development? 
        Answer => PR review 2 round - feature testing in other system, then I do it
                => then pass to my senior > every thursday merge call

    Q8) How did you manage products, private offers, and CPPO effectively? 
        Answer => CRUD for all entity, and make it public limited, status checking 
                => upload file to S3 

    Q9) How did you approach user management within the context of AWS Marketplace?
        Answer => cognito

2. Hire Tool
    Q1)  Could you elaborate on the specific challenges you faced in this project and how you ensured customization while maintaining scalability?
        Answer => restructure the model flow -- tenant -- tenant configuation -- DRY

    Q2) Can you discuss the security measures you implemented in both server and client environments and how you ensure the robustness of your applications against potential threats?
        Answer => Sonarlint -- resolve all issue of sonar -- SAST(Static application security testing)

    Q3) How did you approach the development of a versatile multi-tenant structure at Hire-Tool?
        Answer => 

    Q4) What considerations did you take into account to empower clients with customizable modules and fields?

    Q5) In creating a reusable Python function and React component, how did these components enhance application-wide efficiency and scalability?

    Q6) Can you share insights into the deployment process at Hire-Tool, particularly regarding resolving critical SAST vulnerabilities in both server and client environments?

    Q7) How did you fortify the overall security posture during the deployment of Hire-Tool, and what strategies did you employ to handle security vulnerabilities?

    Q8) How did you balance the need for customization with maintaining a standardized and scalable codebase?

    Q9) Can you share specific instances where you identified and addressed vulnerabilities, and how did this contribute to the overall security resilience of Hire-Tool?
    


3. Care Conductor
    Q1) Can you share the key factors you considered during the migration process and the benefits realized afterward?
        Answer => 
    
    Q2) In Care Conductor, how did you address challenges related to scalability and performance? 
        Answer => 

    Q3) can you elaborate on how you aligned with FHIR (HL7) standards for robust data management?
        Answer => - AWS Healthlake prodvide for storing and struing healthcare data in secure and compliant manner.
                  - FHIR - Fast Healthcare Interoperability Resources
                  - HL7 - set of standards for exchange of electronic health information

    Q4) what principles or best practices do you follow when designing APIs? 
        Answer =>

    Q5) What factors influenced the decision to migrate, and how did the migration enhance scalability and cost efficiency at Care Conductor?
    Q6) Can you elaborate on the strategy used and the benefits gained from isolating these interactions? 
    Q7) How did it contribute to seamless expansion across cloud services?
    Q8) In terms of HL7, How did the implementation contribute to robust data management at Care Conductor?
    Q9) Were there specific challenges or considerations in aligning with industry standards?
    Q10) 

4. Hire Inno
    Q1) How did these tools enhance the hiring process, and what technologies did you leverage, particularly in the API server development using Django, SQL, and AWS S3?
        Answer => 
    
    Q2) How do you ensure effective communication and collaboration, especially in a remote working environment?
        Answer => 

"""

from django.test import TestCase
from myapp.models import Animal


class AnimalTestCase(TestCase):
    def setUp(self):
        Animal.objects.create(name="lion", sound="roar")
        Animal.objects.create(name="cat", sound="meow")

    def test_animals_can_speak(self):
        """Animals that can speak are correctly identified"""
        lion = Animal.objects.get(name="lion")
        cat = Animal.objects.get(name="cat")
        self.assertEqual(lion.speak(), 'The lion says "roar"')
        self.assertEqual(cat.speak(), 'The cat says "meow"')


# ./manage.py test


# mocking -- patch

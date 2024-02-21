"""
Top 4 Design Pattern which are widely used in Industry.
    1. SingleTon 
            => Purpose: Ensure class has ONLY 1 Instance & provide global access to it
            => UseCase: logging, DB connection, User session
            => Pros: Global point of access, Single Instance, Lazy initialization
            => Cons: Global state, difficulty in testing

    2. Factory
            => Purpose: Defines an Interface for creating an object, 
                        but lets subclass change the type of objects 
                        that will be created
            => UseCase: Product Creation
            => Pros: Encapsulation of Object creation, flexibity in object creation
            => Cons: Increased no of class
    3. Observer
            => Purpose: 1-to-Many dependency b/w objects -
                        - so that when 1 object changes state, 
                        - all its dependents are notified & updated automatically.
            => UseCase: Notification
            => Pros: Loose coupling, easy extension, easy maintian
            => Cons: not-interested user also receive notification
    4. Strategy
            => Purpose: family of Algorithm, ecapsulate each one & make them interchangeable
                        - let client choose in run-time.
            => UseCase:Payment Strategy (UPI, Card)
            => Pros: Flexibility, reusable
            => Cons: Increased classes, potential complexity
"""


#### Singleton ####
class Singleton:
    pass

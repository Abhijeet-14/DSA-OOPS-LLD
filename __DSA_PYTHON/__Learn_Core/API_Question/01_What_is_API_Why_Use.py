"""
1. What do you mean by API? why do we use it. 
    => 

2. What are HTTP methods? (Supported by Rest Framework)?
    => GET, POST, PUT, PATCH, DELETE

3. Differnce b/w GET and POST method?
    => GET - use to RETRIEVE data from serveer for a resources
    => POST - use to SUBMIT data into server for a resources

4. Differnce b/w PUT and PATCH method?
    => PUT - use to UPDATE or REPLACE existing entire resources 
    => PATCH - use to PARTIALLY update a resources
    
5. Differnce b/w PUT and POST method?
    => PUT - use to UPDATE or REPLACE entire existing resources 
    => POST - use to CREATE data into server for a resources
    
6. What is SOAP API? why use it?
    => Simple Object Access Protocol (SOAP) -- PROTOCOL to exchange structured information 
        in web services, used for communication b/w application.
        
7. What is REST API?
    => REpresentational State Transfer (REST) -- ARCHITECHURE Style for desining networked applications,
        providing a scalable & stateless communication 

8. Difference b/w SOPA and REST API?
    => SOPA - is PROTOCOL --VS-- REST is Architechure style
    => SOPA - uses XML message format --VS-- REST uses JSON message format

9. What is GraphQL?
    => GraphQL is Query Langauge for APIs -- allows client to request ONLY the data they need.

10. Difference b/w GraphQL and REST API?
    => REST - server FIX response data structure for Client.
    => GraphQL - client can DEFINE response data structure as per Need.
    => REST - Multiple endpoint
    => GraphQL - Single endpoint -- client request EXACT data they need

11. Example GraphQL:
    ---- QUERY (Like GET) ---
    query {
        user(id: "123") {
            id
            name
            email
            posts {
            title
            content
            }
        }
    }
    ---- MUTATION (Like POST PUT) ---
    mutation {
        createPost(userId: "123", title: "New Post", content: "This is the content of the new post.") {
            id
            title
            content
        }
    } 

12. What are HTTP status codes?
    => they are 3-digit number -- indicating Success|Failure|Other state of request.
    => 100-199 - Information response
    => 200-299 - Successful response 
    => 300-399 - Redirection response
    => 400-499 - Client ERROR response
    => 500-599 - Server ERROR response
    => Most Used - 200-OK, 201-Created, 400-BadRequest, 401-Unauthorized, 403-Forbidden, 
            404-NotFound, 405-MethodNotAllowed, 413-PayloadTooLarge, 429-TooManyRequest, 
            500-InternalServerError, 502-BadGateway

13. What are the main components of HTTP request?
    => URL -- Headers -- Method -- Request Body -- Query Parameter

14. What are the main components of HTTP response?
    => Status Code -- Header -- Response Body

15. Can we use a GET / POST method instead of PUT method 
to create resource? 
    => Yes, But as per REST --> POST is for CREATE && PUT is for UPDATE
"""

"""
1. What is RESTFul web service? What are it's Features?
    => Rest is Architechure STYLE for designing networked application
        - how data is transferred 
        - how resources are identified
        - how actions are performed
    => use HTTP method for communication. 
    => Based on pricinples of Simplicity, Scalability and Statelessness

2. What are disadvantages of RESTFul web service?
    =>

3. What are PAYLOADs in terms of RESTFUL web service?
    =>

4. is it possible to send the Payload in GET/Delete method?
    =>

5. what is maximum payload size for POST method?
    =>

6. Which Markup Langaue is Used in RESTFul web API?
    =>

7. what is XML vs JSON?
    =>

8. What is Resource in REST? What is the way to represnt it?
    =>

9. What is advantages of using REST in web API?
    =>

10. What is the Concept of State-less-ness in REST?
    => when Client make request --  request MUST contain all information Needed to fulfill request.

11. What is URI
    => Uniform Resource Identifier -- it includes URL

12. What is CORS  in web api?
    => CORS(Cross-Origin-Resource-Sharing) is a SECURITY feature implemented by web browser 
        -- which prevent interaction bw 2 web application, unless allowed.

13. what do you mean by POSTMAN? why use it?
    => popular tool to test APIs.
"""
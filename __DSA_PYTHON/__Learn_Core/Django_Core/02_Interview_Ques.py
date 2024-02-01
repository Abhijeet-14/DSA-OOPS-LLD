""" QUERYSET Question
1. What is command to install Django? Version
    => pip install django
    => python -m django --version
    => pip freeze
    => pip install -r requirements.txt

2. WHat is "python -m .."?
    => "-m" - flag -- use to RUN module as SCRIPT.

3. Command to Create a Project & Create app in Django.
    => django-admin startproject NEWPRO
    => python manage.py startapp newapp

4. run the server
    => python manage.py runserver
    => python manage.py runserver 9000

5. Command for MIGRATIONS.
    => python manage.py makemigrations

    => To REFLECT changes in DB permanently
        - python manage.py migrate

    => To see raw SQL query executing behind applied migraiton
        - python manage.py sqlmigrate app_name migration_name
        - python manage.py sqlmigrate new_app 0002

    => Show migraitons    
        - python manage.py showmigration 
        - python manage.py showmigration new_app 

6. command to Create Superuser
    => python manage.py createsuperuser 

7. command to VIEW a DB schema of an existing DB?
    => python manage.py inspectdb

8. QUERY items of a Model?
    => ALL - Users.objects.all()
    => FILTER - Users.objects.filter(role=admin)
    => GET - Users.objects.get(id=23)
    => DELETE - Users.objects.get(id=23).delete()
    => CREATE - Users.objects.create(
                    name="abj"
                    role="admin"
                )
    => UPDATE - user = Users.pbjects.get(id=2)
                user.city=pune
                user.save()

9. Combine Queryset of Same Model
    query_set_1 = User.objects.filte(id__gte=15)
    query_set_3 = User.objects.filte(id__lte=5)

    combine_qs = query_set_1 | query_set_2
"""


""" MOST ASKED Question
1. Explain Django ARCHITECHURE? Explain Model, Template and Views?
    => Django follows MVC pattern -- but its refered as MVT(Model-View-Template) because it handle its own template
    => Model - responsible for DB operation
    => Views - responsible for Business logic -- interacting with Model
    => Template - responsible for Generate PRESENTATION layer of application -- HTML

    ARCHITECHURE?
        1. request Make by URL hits in web --> 
        2. request Come to Django-Server -> 
        3. goto urls.py --> MAPS requested URL with Views -->
        4. in views --> process request -- business logic -- interact with model
        5. model handles DB operation
        6. template receives data from view -- generate HTML or Other ouput
        7. return response to Web.

2. Explain How a Request is process in Django?
    => Request >> manage.py >> settings.py(db, middleware..) >> urls.py >> views.py >> template
    => no url match >> error-handling views

3. What is Difference b/w a PROJECT & APP in django?
    => PROJECT - is entire Django Application -- collection of apps
        - django-admin startproject my_project
    => APP - is module inside project that handle specific task
        - python manage.py startapp my_project

    => File Structure - PROJECT:
        my_project
            - manage.py
            - my_project
                - __init__.py
                - settings.py
                - urls.py
                - wsgi.py

        __init__.py = Empty file tells that current directory should be considered 
                as Python Package
        settings.py = contain configuration of current project
        urls.py = URLs of projects
        wsgi.py = Web-Server-Gateway-Interface -- Entry point for 
                your application -- which used by web server and Django to interact

        

    => File Structure - APP:

4. Why Djnago is Loosely Coupled Langaue?
    - FE & BE can work independetly
    - 

5. Explain Migratioins?
    - migration is use to store new changes of model -- and then later reflect on DB.

6. ORM?
    - it replace SQL query
    - interact with DB in more pythonic way

7. setup DB in django
    - in settings.py >> DATABASES = {
        'default': {'ENGINE': "", "NAME":"", "PORT", "USERNAME":"", "PASSWORD":""}
    }

8. CSRF token?
    - cross-site request Forgery
    - to prevent from attact
    - included in HTTP
    - if not availble -- don't allow

9. QUERYSET?
    - in gernal, it is collection of SQL query.
    - in Django, it is collections of Object.

10. select_related in Django?
    - select_related -- it gets own data + FK-model-data
    - get() -- will make 2 call -- 1 for own-data & other for FK-model-data

11. all(), filter(), get() ?
    - 

12. static file? and its configuration?
    - to store additional HTML, JS, CSS
    - settings.py >> INSTALLED_APPS = ["", "django.contrib.staticfiles", ""]
    - settings.py >> STATIC_URL = "/"
    - {%load static%} -- in templates file at top

13. Flask vs Django?
    - Flask -- microframework -- small application -- external libraries
    - Django -- detailed-Framework -- Large application -- project structure -- DB managment & ORM -- internal libraries

14. DJnago admin?
    - command line prompt -- to do administrative task
    - now with admin interface we can handle better
    
15. Advantage or Disadvantage of Django?
    - Advantage
        - easy to learn
        - DRY
        - ORM
        - Rapid Development
        - highly scalable
        - venv
    - Disadvantage
        - monolithic
        - modules are bulky
        - completely ORM based

16. shortcut to easily render an HTML response?
    - render_to_response

17. Authenticaiton or Authorization
    - Authenticaiton - who are you?
    - Authorization - what all permission you have

18. to return respone?
    - render(request, status)

19. Q object in ORM?
    - to add multiple filter -- on OR - AND fashion
    - Model.objects.get(Q(question__startswith="When") | Q(answer_startswith='AI))
    - Model.objects.get(Q(question__startswith="When") & Q(answer_startswith='AI))

20. manage.py?
    - first point -- here it find which settings.py need to hit

21. include function in urls.py
    - urlpatterns = [path("myapp/", include("myapp.urls"))]

22. Django Rest Framework?
    - powerfull library to build Web APIs
    - quicly create REST API

23. Middleware?
    - before each request goto its views.py -- a middleware process the request - then pass futher
    - execute b/w request & response
    - settings.py >> MIDDLEWARE =[".."]

24. Session?
    - store credentials with tab in server-side

25. Django exception?
    - unsudden error
    - try: except Exception as e:

26. .get() exception?
    - DoesNotExtst
    - MultipleObjectsReturned

27. regex for URLS?
    - easy to handle and reduce code

28. diff bw OneToOneField vs FK?
    - OneToOneField is similar to FK -- but its "REVERSE" side is also handle -- not in FK

29. Serializetion?
    - model into json() or XML format
    - ModelSerializer  -- serialization - when send data from Django to Client

30. Serializer?
    - Serializer  -- Deserialization - when send data from Client to Djnago
    - helps in validation
"""

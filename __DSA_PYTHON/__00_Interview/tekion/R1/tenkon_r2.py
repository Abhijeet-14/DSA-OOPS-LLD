input_data = "{([)}]"
input_data = "[()()]"

stack = []

open_bracket_list = ["{", "(", "["]
for bracket in input_data:
    if bracket in open_bracket_list:
        stack.append(bracket)
    else:
        peek = stack[-1]
        if peek == "{" and bracket == "}":
            stack.pop(-1)
            print(stack)
        elif peek == "[" and bracket == "]":
            stack.pop(-1)
        elif peek == "(" and bracket == ")":
            stack.pop(-1)


if len(stack) > 0:
    print("INvalid string")
else:
    print("Valid string")

    # SQL:
    # update a record's colum based on condition

    # ALTER age FROM EMPLOYEE where name = "ABHIJEET"

    # employee = Employee(id=2, name="ABHIJEET")

    # employee.age = 10
    # employee.save()

    # API
    """
    id, F_N, L_N(null), age
    """
    """
    age > 25
    available - {..}
    not-avialable - NA, if L_N - null 
    """
API - /employee/


CORE/urls.py
urlpatterns = [
    path("/admin", admin),
    path("/", includes('employee.urls'))
]

employee/urls.py
urlpatterns = [
    path("employee",Employee.as_view)]

Class Employee(APIView):
    def get(self, request): # GET
        employees = Employee.objects.filter(age__gt=25)
        
        result = []
        for employee in employees:
            employe_data = employee.__dict__
            if not employee["last_name"]:
                employe_data["last_name"]=  "NA"
            
            result.append(employe_data)
        
        return Response({"data": result}, status : 200)


response = fetch("URL" + "/employee")
response_data = response.json()
employe_data = response_data['data']

console.log(employe_data)
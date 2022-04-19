# for loop 
for i in range(3):
    print(i)

print()
# While loop
a = 3
i=0
while(i<a):
    print(i)
    i+=1


print()
# do-While loop
while True:
    print(i)
    i +=1

    if(i == 7):
        break


# DATA TYPES
print("\nData Types")
a=10  
b="Hi Python"  
c = 10.5  
print(type(a))  # int
print(type(b))  # str
print(type(c))  # float 

# List
print("\nLIST")
list1  = [1, "hi", "Python", 2]    
#Checking type of given list  
print(type(list1))  
  
#Printing the list1  
print (list1)  
  
# List slicing  
print (list1[3:])  
  
# List slicing  
print (list1[0:2])   
  
# List Concatenation using + operator  
print (list1 + list1)  
  
# List repetation using * operator  
print (list1 * 3)  


# tuple
print("\nTUPLE")
tup  = ("hi", "Python", 2)    
# Checking type of tup  
print (type(tup))    
  
#Printing the tuple  
print (tup)  
  
# Tuple slicing  
print (tup[1:])    
print (tup[0:1])    
  
# Tuple concatenation using + operator  
print (tup + tup)    
  
# Tuple repatation using * operator  
print (tup * 3)     
  
# Adding value to tup. It will throw an error.  
# t[2] = "hi" # NOT SUPPORTED


# Float value & divide value
print('\n\nInt: ', 7/2)
print('\float: ', 7//2)



# Logical Operator
# and, or, not

# Bitwise Operator
# &, |, ^, ~, <<, >>

# Membership Operator
# in, not in

# Identity Operator
# is, is not


# If-else
# if cond1 and cond2:
    # statement
# elif cond3:
    # statement
# else:
    # statement


# loop statement
# continue  
#the code to be skipped     

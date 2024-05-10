"Everything in JS happens INSIDE an EXECUTION Context"
"MEMORY || CODE"

"Memory: key:value (e.g., a: 10)"

"JavaScript is SYNCHRONOUS single-threaded langauage"

"What happens when JS file is run??"

"1. Create Execution Context"
"2. Store variable as [undefiend/null] in MEMORY component" // res: undefined
"3. Store Function as, whole code of it." // function() { return a=10}
"4. Once step 2 & 3 is done for whole file."

"5. Now, Again we will go thro the code"
"6. Declares the variable real Value" // res = 4
"7. when function INVOKE => create new SUB-Execution Context"
"8. set 2 & 3 will run for SUB-Execution & later 5, 6 & 7."

"9. When even declaring and all done"
"10. Now return the value from CHILD Execution-Context to Parent Execution-context"
"11. delete the CHILD Execu-Context & so on."
"11. Hence, run the JS file"
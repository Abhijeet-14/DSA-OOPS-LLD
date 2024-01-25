"Block Scope & Shadowing"

"what is block?"

"It is a combine multiple JS statement in a group."
"it is used at places where JS wants 1 STATEMENT"

if(true) console.log("This is not a block")

if(true) {
    let str = "This is BLOCK"
    console.log(str)
}

"WHAT IS BLOCK-SCOPE?"

"all the variables & functions that can be accessed inside a block -> defines the block-scope"



"WHAT IS SHADOWING?"

var a =10;
console.log("Before shadow ", a) // 10

{
    var a = 12
    var b=100
    console.log("WHILE SHADOW ",a) // 12
}

console.log("After shadow ", a) // 12 .... that means-> a is shadows to 12 & modified to 12.

"here inside BLOCK -> a is shadow of varible a(line 23) & so we can write line 26 as a = 12"


"ARROW FUNCTION & NORMAL FUNCTION has same block-scope"
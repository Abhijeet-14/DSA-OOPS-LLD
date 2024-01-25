".. let-const hoisting"

"Temporal Dead Zone: it the TIME bw [undefiend] to [initialize value] of let variable"
            // in CASE 2, line 16.. a is in Temporal Dead Zone.

//.. CASE 1

console.log(b)  // b is hoisted in Global Object

let a=10;
var b=100


//.. CASE 2

console.log(a)  // ERROR: can't acces BFORE Initialize, BCOZ
            // a is NOT hoisted in Global Object, it is in DIFF object OUTSIDE global
            // and in this OBJECT, we can't access let or const BEFORE initialize 
            // BUT it has a=undefiend... just we CAN'T ACCESS it.

let a=10;
var b=100



//.. CASE 3
let a=10;

console.log(a) // this work ?.. bcoz accessing after INITIALIZE

var b=100



//.. CASE 3: CONST
console.log(a) // SAME as CASE 2

const a=10;

var b=100

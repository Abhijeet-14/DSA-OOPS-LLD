"... LEXICAL SCOPE ..."

"SCOPE CHAIN: it is call from child to parent & parent to grand parent "


//.. CASE 1
// function abc() {    // but then it will check it's parent(Global Scope)    
//     console.log(b) // b doesn't exist in this Local[a()] scope
// }

// var b = 10
// abc()



//.. CASE 2
// function a() {    // but then it will check it's parent(global scope)    
//     c()
//     function c() { // but then it will check it's parent(a())
//     console.log(b)
//     } // b doesn't exist in this c() scope
// }

// var b = 10
// a()



"We can access Global VARIABLE or FUNCTION inside LOACAL SCOPE"


"Can we acces Local Scope Variable OUTSIDE LOCAL SCOPE "


//.. CASE 3
function a() {    //
    var b = 10
    c()
    function c() {
    console.log(b) //
    }
}

a()
    

"THEREFORE: lexical_env: local_memory_func + lexical_env_of_PARENT"
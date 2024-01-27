// function x() {
//     var a = 8
//     function y() {
//         console.log(a)
//     }
//     y()
// }

// x()

"DEFINE: Closure is a functions BUNDLES together WITH its LEXICAL ENVIRONMENT [surronding state] "


// function x() {
//     var a = 8
//     console.log("W/O before closure", a)
//     return function y(b) {
//         console.log("with closure, ", a+b)
//     }
// }

// var ca = x()
// console.log(ca)
// ca(3)

// x()(10) // instead of line 22-24, use this line


function x() {
    var a = 8
    console.log("W/O before closure", a)
    function y(b) {
        console.log("with closure, ", a+b)
    }
    a=100
    return y
}

x()(47)




"USES OF CLOSURES"
"   - Module design patern"
"   - Curring"
"   - Functions like once"
"   - memoize"
"   - maintaining state in async world"
"   - setTimeouts"
"   - Iterators"
"   - and many more"
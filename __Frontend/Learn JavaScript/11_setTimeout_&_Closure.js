// function x() {
//     var i=1;

//     setTimeout(() => {
//         console.log(i)
//     }, 3000)
//     console.log("JS INTERVIEW\n")
// }

// x() 
// by running this.. setTimeout WON'T stop the function other stuffs
    // setTimeout will take the reference of 'i'[line-2] and wait for 3sec asyncly
    // then line 7 runs
    // after 3 sec setTimeout callback runs

// JS INTERVIEW
// 1



// to print 1 2 3 4 5 6 after 1s 2s 3s 4s 5s 6s respectively


// function a() {
//     console.log("VAR : cause issue")
//     for(var i=1; i<=5; i++)
//     {
//         setTimeout(() => console.log(i), i*1000)
//     }

//     console.log("Js Interview")
// }

// a()
// it will print 6 six-times... why?
// because each function points to same reference of 'i'
// and i value has been updated to 6, once loop ends
// and when the TIME ends... it take the update i value => which is i=6
// So... 6 six-times



// function b() {
//     console.log("LET : solves the problem")
//     for(let i=1; i<=6; i++)
//     {
//         setTimeout(() => console.log(i), i*1000)
//     }

//     console.log("Js Interview")
// }

// b()

// bcoz let variable is block scope..
// so, each setTimeout take the refernce of different 'i' 
// 1st setTimeout -> i=1
// 2nd setTimeout -> i=2
// 3rd setTimeout -> i=3
// 4th setTimeout -> i=4
// 5th setTimeout -> i=5
// 6th setTimeout -> i=6



// CAN'T use LET
function c() {
    console.log("LET : solves the problem")
    for(var i=1; i<=6; i++)
    {
        function closure(i ){

            setTimeout(() => console.log(i), i*1000)
        }
        closure(i)
    }

    console.log("Js Interview")
}

c()
// here what we did,
// passed the value of i as parameter.. so its different for each setTimeout
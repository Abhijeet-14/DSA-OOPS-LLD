"... HOISTING ... ";

"hosting is process by which access variable & function BEFORE initialization";

///// CASE 1 /////
// var x = 9;

// function run() {
//   console.log("JS JS");
// }

// run();   // JS JS

// console.log(x);  // x=9

///// Case 2: MEMORY PHASE of GEC /////
// run(); // this run... ?, bcoz we can access before initialization
// console.log(run); // function run() { console.log("JS JS")}

// console.log(x); // x=undifined...? bcoz initialization at MEMORY PHASE

// var x = 9;

// function run() {
//   console.log("JS JS");
// }

////// CASE 3: Error /////
// console.log(x); // ERROR: x is NOT-DEFINED...? bcoz x is not initialize & not avaiable

// function run() {
//   console.log("JS JS");
// }

///// CASE 3: Arrow Function /////
// console.log(run); // run = undefiend

// run(); // ERROR: run is NOT FUNCTION... ?, in memory phase run is VARIABLE

// const run = () => {
//   console.log("JS JS");
// };

///// CASE 4: LET for function /////
console.log(run); // ERROR: can't access run BEFORE initialize 
    // var works here
run(); 

// let: ERROR [can't access run BEFORE initialize]
// cont: ERROR [can't access run BEFORE initialize]
// var: ERROR [run is not a function]
let run = function () {
  console.log("JS JS");
};

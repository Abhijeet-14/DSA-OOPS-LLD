var x = 1;
a();
b();

console.log(x); // this gloabl scope/function(say)

function a() {
  var x = 10;   // this only scope to function a
  console.log(x);
}

function b() {
  var x = 10;   // scope to b()
  console.log(x);
}

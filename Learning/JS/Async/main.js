function first() {
  return new Promise((resolve) => {
    console.log(2);
    resolve(3);
    console.log(4);
  });
}

async function f() {
  console.log(1);
  var r = await first();
  console.log(r)
}

console.log("a");
f();
console.log("b");

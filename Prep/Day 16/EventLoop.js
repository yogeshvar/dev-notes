function logOne() {
  console.log("1");
}

function slowFunction() {
  for (let i = 0; i < 100000000; i++) {
    // nothing
  }
}

function main() {
  setTimeout(logOne, 0);
  Promise.resolve(1)
    .then((val) => val + 1)
    .then(console.log);
  slowFunction();
  console.log("3");
}

/**
 * Class Stack
 * Web APIs
 * Task Queue
 * Microtask Queue
 * Console Output
 * 
 * - Dequeue 1 task 
 * - Execute until class stack is empty
 * - Execute all Microtasks until empty
 * - Render DOM Changes
 * - Repeat 
 */
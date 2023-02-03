function sum(a, b, c) {
  return a + b + c;
}

function warn(msg) {
  console.warn(msg);
}

function log(msg) {
  console.log(msg);
}

function error(msg) {
  console.error(msg);
}

function logging(func) {
  return (msg) => func(msg);
}

function curry(func) {
  return (a) => (b) => (c) => func(a, b, c);
}

const sumCurry = curry(sum);
console.log(sumCurry(2)(3)(4));

const logLog = logging(log);
const warnLog = logging(warn);
const errorLog = logging(error);

logLog("message");
warnLog("warn");
errorLog("error");

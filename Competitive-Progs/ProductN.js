var num = [1, 2, 5];
var den = [2, 1, 6];
var N = 3;

var new_num = prod(num);
var new_den = prod(den);
console.log(new_num, new_den);
var gcd = EuclidGcd(10, 12);
new_num /= gcd;
new_den /= gcd;

console.log(new_num + "/" + new_den);

function prod(arr) {
  var prod = 1;
  for (let i = 0; i < arr.length; i++) {
    prod *= arr[i];
  }
  return prod;
}

function EuclidGcd(a, b) {
  if (a == 0) {
    return b;
  }
  return EuclidGcd(b % a, a);
}

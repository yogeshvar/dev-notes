/* 
    If we subtract a smaller number from a larger (we reduce a larger number), 
    GCD doesn’t change. So if we keep subtracting repeatedly the larger of two, 
    we end up with GCD. 
*/

var ans = gcd(98, 56);
var optAns = EuclidGcd(98, 56);
console.log(ans);
console.log(ans);

function gcd(a, b) {
  console.log(a, b);
  if (a == 0) return b;
  if (b == 0) return a;

  // base case
  if (a == b) return a;

  // a is greater
  if (a > b) {
    console.log(a - b, a, b);
    return gcd(a - b, b);
  }
  console.log(a, b, b - a);
  return gcd(a, b - a);
}

// Euclidean algorithms
function EuclidGcd(a, b) {
  if (a == 0) {
    return b;
  }
  return EuclidGcd(b % a, a);
}

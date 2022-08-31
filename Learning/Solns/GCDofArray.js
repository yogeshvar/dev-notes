var a = [2, 4, 6, 8, 16];

var ans = findGCD(a);
console.log(ans);

function findGCD(a) {
  var result = 0;
  for (var i = 0; i < a.length; i++) {
    result = EuclidGcd(result, a[i]);

    if (result == 1) {
      return 1;
    }
  }
  return result;
}

function EuclidGcd(a, b) {
  if (a == 0) {
    return b;
  }
  return EuclidGcd(b % a, a);
}

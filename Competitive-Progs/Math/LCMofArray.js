var a = [2, 7, 3, 9, 4];
let ans = 1;

for (let i = 0; i < a.length; i++) {
  ans = lcm(ans, a[i]);
}

console.log(ans);

function lcm(a, b) {
  return (a * b) / EuclidGcd(a, b);
}

function EuclidGcd(a, b) {
  if (a == 0) {
    return b;
  }
  return EuclidGcd(b % a, a);
}

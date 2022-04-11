var ans = lcm(15, 20);
console.log(ans);

// a x b = LCM (a, b) * GCD (a, b)
// LCM (a, b) = a * b / GCD (a, b)

function lcm(a, b) {
  return (a * b) / EuclidGcd(a, b);
}

function EuclidGcd(a, b) {
  if (a == 0) {
    return b;
  }
  return EuclidGcd(b % a, a);
}

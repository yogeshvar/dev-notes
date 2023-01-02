var a = [10, 10, 10, 10, 10, 10, 10, 10, 10, 9];
var sum,
  ans = 0;

function calcAverage(a) {
  var result = 0;
  for (var i = 0; i < a.length; i++) {
    result += a[i];
  }
  return result / a.length;
}

function need(a) {
  var average = calcAverage(a); // O(n)
  if (average >= 9.5) {
    return ans;
  } else {
    a.push(10);
    ans++;
    need(a);
  }
}

var ans = need(a);

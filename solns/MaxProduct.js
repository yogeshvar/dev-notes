var x = [10, 20, 30, 40, 50];

var prod = 0;
var result = "";

for (var i = 0; i < x.length; i++) {
  for (var j = 1; j < x.length; j++) {
    if (x[i] * x[j] > prod) {
      prod = x[i] * x[j];
      result = `${i}, ${j}`;
    }
  }
}

console.log(result);

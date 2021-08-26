var d = ["tFc", "tF", "Ftc"];
var p = [3, 4, 1, 5];
var c = [2, 8, 5, 1];
var f = [5, 2, 4, 4];
var result = [];
for (var i = 0; i < d.length; i++) {
  for (var j = 0; j < p.length; j++) {
    if (selectMeals(d[i], p, c, f, i, j)) {
      result[i] = j;
    }
  }
}
console.log(result);

function selectMeals(d, p, c, f, i, j) {
  for (var a = 0; a < d.length; a++) {
    if (d[i] == "C" || d[i] == "c") {
      if (c[i] == c[j]) {
        continue;
      }
      if (d[i] == "C") {
        return c[i] > c[j];
      } else {
        return c[i] < c[j];
      }
    } else if (d[i] == "P" || d[i] == "p") {
      if (d[i] == d[j]) {
        continue;
      }
      if (d[i] == "P") {
        return p[i] > p[j];
      } else {
        return p[i] < p[j];
      }
    } else if (d[i] == "F" || d[i] == "f") {
      if (f[i] == f[j]) {
        continue;
      }
      if (d[i] == "F") {
        return f[i] > f[j];
      } else {
        return f[i] < f[j];
      }
    } else {
      var cal1 = p[i] * 5 + c[i] * 5 + f[i] * 9;
      var cal2 = p[j] * 5 + c[j] * 5 + f[j] * 9;
      if (cal1 == cal2) {
        continue;
      }
      if (d[i] == "T") {
        return cal1 > cal2;
      } else {
        return cal2 < cal1;
      }
    }
  }
  return false;
}

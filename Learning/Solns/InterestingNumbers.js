var digitList = [];

for (var i = 2; i < 10; i++) if (interesting(i, 10)) digitList.push(i);

function interesting(d, b) {
  console.log(d, b);
  return b % d == 1;
}

console.log(digitList);

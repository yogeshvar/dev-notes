arr = [-5, -3, 1, 10];
target = 7;

console.log(arr, target);

var left = 0,
  right = arr.length - 1,
  sum = 0;

console.log(left, right, sum);

while (sum !== target) {
  sum = arr[left] + arr[right];
  console.log(sum, arr[left], arr[right]);
  if (sum < target) {
    left = left + 1;
  } else {
    right = right - 1;
  }
}

console.log(arr[left], arr[right + 1]);

// O(n)

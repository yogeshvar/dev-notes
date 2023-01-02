arr = [-3, -2, -1, 1, 1, 3, 4];
target = -4;

console.log(arr, target);

for (var i = 0; i < arr.length; i++) {
  for (var j = i + 1; j < arr.length; j++) {
    var sum = arr[i] + arr[j];
    if (sum == target) {
      console.log(arr[i], arr[j]);
      break;
    }
  }
}

// O(n^2)
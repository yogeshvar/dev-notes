var x = [-2, -3, 4, -1, -2, 1, 5, -3];
// Kadane’s Algorithm:
var max_so_far = x[0],
  max_ending_here = 0;
for (let i = 0; i < x.length; i++) {
  max_ending_here = max_ending_here + x[i];
  if (max_ending_here < 0) {
    max_ending_here = 0;
  } else if (max_so_far < max_ending_here) {
    max_so_far = max_ending_here;
  }
}
console.log(max_so_far);

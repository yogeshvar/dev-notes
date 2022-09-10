### AlgoExpert 6: Array

- Init => `O(N)`
- Traverse => `O(N)`
- Get => `O(1)`
- Set => `O(1)`
- Copy => `O(N)`
- Insert => `O(N)` (Why? Cause we copy the array and insert n + 1 element)
  - Insert End in Dynamic => `O(1)`
  - When Size is full, the next insert is `O(n)`

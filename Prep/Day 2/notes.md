### AlgoExpert: 5 Big O Notation

```python
from typing import List

a = [1,2,3]

def func_one(x: List) -> int:
    return 1 + x[0]

def func_two(x: List) -> int:
    return sum(x)

def func_three(x: List) -> List:
    pairs = []
    for i in x:
        for j in x:
            pairs.append([i,j])
    return pairs

print(func_one(a))
print(func_two(a))
print(func_three(a))
```

### AlgoExpert 6: Log N

To put it simple, $ log_b(x) = y \implies b^y = x $, but in CS we use base 2 so $ log (N) = y \implies 2^y = N $.

Imagine doubling the size of `N` is still only increasing $ 2^{y+1} $ that is why it is better than `O(n)`

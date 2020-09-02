import math
class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        values = [int(d) for d in str(n)]
        product = math.prod(values)
        addition = sum(values)
        return product - addition
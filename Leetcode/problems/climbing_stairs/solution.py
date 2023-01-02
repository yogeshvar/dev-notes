from functools import lru_cache

class Solution:
    @lru_cache(None)
    def climbStairs(self, n: int) -> int:
        dic = {1:1,2:2}
        if n not in dic:
            dic[n] = self.climbStairs(n-1) + self.climbStairs(n-2)
        return dic[n]
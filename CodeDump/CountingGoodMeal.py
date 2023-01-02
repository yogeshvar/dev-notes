from itertools import combinations
from typing import List


class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        ways = 0
        for (x, y) in combinations(deliciousness, 2):
            val = x + y
            if (val & (val - 1) == 0) and val != 0:
                ways += 1
        return ways % ((10**9) + 7)

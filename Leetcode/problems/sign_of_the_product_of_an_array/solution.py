class Solution:
    def arraySign(self, nums: List[int]) -> int:
        x = reduce(lambda x, y: x * y, nums)
        return 0 if x == 0 else (1 if x > 0 else -1)

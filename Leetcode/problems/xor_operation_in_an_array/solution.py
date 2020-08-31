class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        nums = [None] * n
        value = 0
        for i in range(0,n):
            value = value ^ start + 2 * i
        return value
            
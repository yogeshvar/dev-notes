class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        sum = 0
        for col in zip(*strs):
            sum += 1 if (sorted(col) != list(col)) else 0
        return sum
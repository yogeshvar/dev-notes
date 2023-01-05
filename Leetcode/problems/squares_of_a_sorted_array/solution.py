class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        A = ([i ** 2 for i in nums])
        A.sort()
        return A
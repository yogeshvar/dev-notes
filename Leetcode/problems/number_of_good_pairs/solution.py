class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        count = 0
        for idx_i, i in enumerate(nums):
            for idx_j, j in enumerate(nums):
                if i == j and idx_i < idx_j:
                    count += 1
        return count
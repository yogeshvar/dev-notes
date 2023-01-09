class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx_i, i in enumerate(nums):
            for idx_j, j in enumerate(nums):
                if idx_i == idx_j:
                    continue
                elif i + j == target:
                    return [idx_i, idx_j]
        return []
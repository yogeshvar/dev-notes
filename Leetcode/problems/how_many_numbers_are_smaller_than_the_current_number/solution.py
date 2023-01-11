class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        res = []

        for idx_i, i in enumerate(nums):
            count = 0
            for idx_j, j in enumerate(nums):
                if idx_j != idx_i and j < i:
                    count += 1
            res.append(count)
        return res
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        res = []
        for idx, i in enumerate(nums):
            res.append(i + sum(nums[:idx]))
        return res
class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        RSum = sum(nums)
        LSum = 0
        for idx, i in enumerate(nums):
            if LSum == (RSum - LSum - i):
                return idx
            LSum += i
        return -1
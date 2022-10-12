class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for idx, i in enumerate(nums): 
            if idx == 0: 
                nums[idx] = i
            else: 
                nums[idx] = nums[idx - 1] + nums[idx]
        return nums
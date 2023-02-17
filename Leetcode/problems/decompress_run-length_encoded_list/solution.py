class Solution(object):
    def decompressRLElist(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        for i in range(0,len(nums),2):
            result += nums[i]*[nums[i+1]]
        return result

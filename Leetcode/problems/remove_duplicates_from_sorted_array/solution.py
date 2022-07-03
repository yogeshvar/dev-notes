class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        k = sorted(set(nums))
        for idx,i in enumerate(k): 
            nums[idx] = i
        return len(k)
        
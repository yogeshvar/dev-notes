class Solution(object):
    def countKDifference(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count = 0
        for i in range(0, len(nums)):
            for j in range(0, len(nums)):
                if i == j:
                    continue
                if nums[i] - nums[j] == k:
                    count += 1
        return count
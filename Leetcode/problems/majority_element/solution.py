class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        freq = {}
        for i in range(0,len(nums)):
            if nums[i] in freq:
                freq[nums[i]] += 1
            else:
                freq[nums[i]] = 1
            for key in freq:
                if freq[key] > len(nums) / 2:
                    return key
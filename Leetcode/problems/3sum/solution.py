class Solution(object):
    def threeSum(self, nums):
        result = []
        nums.sort()
        for a in range(0, len(nums) - 1):
            pointer = a + 1
            end = len(nums) - 1
            while(pointer < end):
                sum = nums[a] + nums[pointer] + nums[end]
                if (sum == 0):
                    if result.count([nums[a], nums[pointer], nums[end]]) != 1:
                        result.append([nums[a], nums[pointer], nums[end]])
                    pointer += 1
                    end -= 1
                elif sum < 0:
                    pointer += 1
                else:
                    end -= 1
        return result
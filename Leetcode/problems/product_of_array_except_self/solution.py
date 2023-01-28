class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = 1
        answer = [1]*len(nums)
        for i in range(len(nums)):
            answer[i] = left
            left = left*nums[i]
        right = 1
        for i in range(len(nums)-1, -1, -1):
            answer[i] = answer[i]*right
            right = right*nums[i]
        return answer
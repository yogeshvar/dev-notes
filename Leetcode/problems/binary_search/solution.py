class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        mid = (start + end) // 2
        while nums[mid] != target and start <= end:
            if target < nums[mid]: 
                end = mid - 1
            else: 
                start = mid + 1
            mid = (start + end) // 2
        return mid if nums[mid] == target else -1
            
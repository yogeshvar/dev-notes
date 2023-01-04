class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        mid = (start + end) // 2
        while nums[mid] != target and start <= end:
            if target < nums[mid]: 
                end = mid - 1
            else: 
                start = mid + 1
            mid = (start + end) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            return mid + 1
        else:
            return 0 if (mid - 1) < 0 else mid - 1
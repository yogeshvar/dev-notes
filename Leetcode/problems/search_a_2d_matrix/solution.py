class Solution:
    def binary_search(self, nums, target):
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

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        top, bottom = 0, rows - 1

        while top <= bottom:
            row = (top + bottom) // 2
            if target < matrix[row][0]:
                bottom = row - 1
            elif target > matrix[row][cols - 1]:
                top = row + 1
            else:
                break

        if top > bottom:
            print("Not found")

        row = (top + bottom) // 2
        col = self.binary_search(matrix[row], target)
        
        return True if col != -1 else False
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        counter = list(range(1, len(nums)+1))
        return list(set(counter) - set(nums))
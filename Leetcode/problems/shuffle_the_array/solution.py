class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        res = []
        for i in range(0, len(nums)):
            if(i+n == len(nums)):
                break
            res.append(nums[i])
            res.append(nums[i+n])
        return res
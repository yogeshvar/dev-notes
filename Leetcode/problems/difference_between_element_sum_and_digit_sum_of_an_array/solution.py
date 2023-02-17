class Solution(object):
    def differenceOfSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        digits_sum = 0
        for n in nums:
            for d in str(n):
                print(d)
                digits_sum += int(d)
            digits_sum -= n
        return abs(digits_sum)
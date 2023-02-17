class Solution(object):
    def maximumWealth(self, accounts):
        """
        :type accounts: List[List[int]]
        :rtype: int
        """
        large = 0
        for i in accounts:
            large = max(large, sum(i))
        return large
class Solution(object):
    def balancedStringSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = 0
        for i in range(len(s)):
            if s[:i].count("R") == s[:i].count("L"):
                count += 1
        return count
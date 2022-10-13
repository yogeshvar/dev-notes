class Solution(object):
    def isSubsequence(self, s, t):
        i, j, count = 0, 0, len(s)
        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
                j += 1
                count -= 1
            elif s[i] != t[j]:
                j += 1
            else: 
                i += 1
        if count == 0: 
            return True
        else:
            return False
class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        for i in range(0, len(s)):
            if s[-1] + s[:-1] == goal: 
                return True
            else:
                s = s[-1] + s[:-1]
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """        
        right = 0
        left = len(s) - 1

        while right <= left:
            s[right], s[left] = s[left], s[right]
            right = right + 1
            left = left - 1
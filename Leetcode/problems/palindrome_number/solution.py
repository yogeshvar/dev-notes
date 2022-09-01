class Solution:
    def isPalindrome(self, x: int) -> bool:
        org = x 
        rev = 0
        while (x != 0):
            rem = x % 10
            rev = rev * 10 + rem
            x = int(x / 10)
        if org == rev: 
            return True
        return False
    
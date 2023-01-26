class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-zA-Z0-9]', '', s)
        l = 0
        r = len(s) - 1
        while l <= r:
            if s[l] == s[r]:
                l = l + 1
                r = r - 1
            else:
                return False
        return True
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-zA-Z0-9]', '', s)
        return s == ''.join(reversed(s))
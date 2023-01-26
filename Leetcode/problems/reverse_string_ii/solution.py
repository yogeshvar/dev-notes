class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        s = list(s)
        for i in range(0, len(s), 2*k): 
            start, end = i, min(i+k, len(s))
            while start < end:
                s[start], s[end-1] = s[end-1], s[start]
                start += 1
                end -= 1
        return ''.join(s)
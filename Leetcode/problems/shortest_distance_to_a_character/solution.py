class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        idx_list = [i for i in range(len(s)) if s[i] == c[0]]
        ans = []
        for i in range(len(s)):
            tmp = []
            for j in idx_list:
                tmp.append(abs(i-j))
            ans.append(min(tmp))
        return ans
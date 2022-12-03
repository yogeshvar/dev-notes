class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = ""
        for w1, w2 in itertools.zip_longest(word1, word2):
            if w1:
                res += w1
            if w2:
                res += w2
        return res
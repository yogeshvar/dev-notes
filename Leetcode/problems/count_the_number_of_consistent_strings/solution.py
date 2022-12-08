class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        list = [0] * 26
        res = len(words)

        for i in allowed:
            list[ord(i) - ord('a')] += 1;

        for word in words: 
            for c in word:
                if(list[ord(c) - ord('a')] == 0): 
                    res -= 1;
                    break
        return res
class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        max_len = len(sentences[0].split(' '))
        for s in sentences:
            curr_len = len(s.split(' '))
            max_len = max(curr_len, max_len)
        return max_len
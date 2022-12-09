class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = re.sub(r'[^\w\s]',' ', paragraph)

        hash_table = {}
        for word in paragraph.lower().split():
            if word in banned:
                continue
            hash_table[word] = hash_table.get(word, 0) + 1
            max_value = max(hash_table, key=hash_table.get)
        return max_value
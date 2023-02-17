class Solution:
    def findWords(self, words: List[str]) -> List[str]:
            res = []
            for word in words:
                if is_one_row(word):
                    res.append(word)
            return res

def is_one_row(word):
    first_row = "qwertyuiop"
    second_row = "asdfghjkl"
    third_row = "zxcvbnm"
    word = word.lower()
    if word[0] in first_row:
        row = first_row
    elif word[0] in second_row:
        row = second_row
    else:
        row = third_row

    for letter in word:
        if letter not in row:
            return False
    return True
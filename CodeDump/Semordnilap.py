
def semordnilap(words):
    wordsSet = set(words)
    print(wordsSet)
    result = []
    for w in words:
        if w[::-1] in wordsSet and w != w[::-1]:
            result.append([w, w[::-1]])
            wordsSet.remove(w)
            wordsSet
    return result
    

semordnilap(["diaper", "abc", "test", "cba", "repaid"])

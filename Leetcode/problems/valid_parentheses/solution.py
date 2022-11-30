class Solution:
    def isValid(self, s: str) -> bool:        
        a = []
        d =  dict(('()', '[]', '{}'))

        for i in s:
            if i in "([{":
                a.append(i)
            elif len(a) == 0 or i != d[a.pop()]:
                return False
        return len(a) == 0
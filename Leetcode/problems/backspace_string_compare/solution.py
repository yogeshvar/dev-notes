class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        s_arr = []
        t_arr = []

        for c in s:
            if c == '#':
                if s_arr != []:
                    s_arr.pop()
            else:
                s_arr.append(c)
        for c in t:
            if c == '#':
                if t_arr != []:
                    t_arr.pop()
            else:
                t_arr.append(c)
        return s_arr == t_arr




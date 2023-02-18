class Solution(object):
    def cellsInRange(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        col, row = s.split(':')
        cols = [chr(i) for i in range(ord(col[0]), ord(row[0])+1)]
        cols = [c + col[1:] for c in cols]
        if len(row) > 1:
            rows = [str(i) for i in range(int(col[1:]), int(row[1:])+1)]
            cols = [c[:1] + r for c in cols for r in rows]
        return sorted(cols)
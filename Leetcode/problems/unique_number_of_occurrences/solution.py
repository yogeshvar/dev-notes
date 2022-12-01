class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        d, counts = {}, {}
        for n in arr:
            if n in d: d[n] += 1
            else: d[n] = 1
        
        for k in d:
            if d[k] in counts: return False
            else: counts[d[k]] = 0
                
        return True
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:        
        l, r = 1, max(piles)
        mid = (l + r) // 2
        while l < r:
            if sum([i // mid + (i % mid > 0) for i in piles]) > h:
                l = mid + 1
            else:
                r = mid
            mid = (l + r) // 2
        return mid
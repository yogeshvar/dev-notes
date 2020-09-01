class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        if(A == sorted(A, reverse=True) or A == sorted(A)):
            return True
        return False
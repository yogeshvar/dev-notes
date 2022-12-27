class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        s = ''.join([str(x) for x in digits])
        s = int(s) + 1
        s = [int(x) for x in str(s)]
        return s
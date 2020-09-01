class Solution:
    def arrangeCoins(self, n: int) -> int:
        result = 0
        if(n == 0):
            return 0
        for i in range(1, n+1):
            n = n - i
            result += 1
            if(n < 0):
                return result - 1
                break
            elif(n == 0):
                return result
                break
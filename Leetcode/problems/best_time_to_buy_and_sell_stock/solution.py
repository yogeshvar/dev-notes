class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        left = 0
        for right in range(len(prices)):
            if prices[left] > prices[right]:
                left = right
            else:
                profit = max(profit, prices[right] - prices[left])
        return profit
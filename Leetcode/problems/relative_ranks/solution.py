class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        rankings = []
        for i, val in enumerate(score):
            heapq.heappush(rankings, (-val, i))
        ans = [''] * len(score)
        r = 1
        rank = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        while len(rankings) != 0:
            _, i = heapq.heappop(rankings)
            if r <= 3:
                ans[i] = rank[r-1]
            else:
                ans[i] = f'{r}'
            r += 1
        return ans
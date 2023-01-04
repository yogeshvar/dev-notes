class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        count = collections.Counter(tasks)
        ans = 0
        for c in count.values():
            if c < 2:
                return -1
            if c % 3 == 0:
                ans += c // 3
            else:
                ans += (c // 3 + 1)
        return ans
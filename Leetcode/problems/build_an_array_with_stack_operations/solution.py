class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        new_n = n if n < target[len(target) - 1] else target[len(target) - 1]
        res = []
        for i in range(new_n):
            if i + 1 in target:
                res.append('Push')
            else:
                res.append('Push')
                res.append('Pop')
        return res
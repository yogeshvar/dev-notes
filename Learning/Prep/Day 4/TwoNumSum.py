"""
AlgoExpert Problem: Two Number Sum
Difficulty: Easy 🟢
"""

# Solution One: Classic Iteration to get all possible answers [O(n^2)]


def twoNumberSum_One(array, targetSum):
    for idx_i, i in enumerate(array):
        for idx_j, j in enumerate(array):
            # given constraint
            if idx_i == idx_j:
                continue
            elif i + j == targetSum:
                return [i, j]
    pass

# Solution Two: X + Y = TargetSum => X = TargetSum - Y


def twoNumberSum_Two(array, targetSum):
    for idx_i, i in enumerate(array):
        for idx_j, j in enumerate(array):
            if idx_i == idx_j:
                continue
            elif i == targetSum - j:
                return [i, j]

# Solution Three: Keep the X = TargetSum - Y in set


def twoNumberSum_Three(array, targetSum):
    seen = set()
    for y in array:
        if (targetSum - y) in seen:
            return [y, (targetSum - y)]
        seen.add(targetSum - y)
    return []

"""
AlgoExpert Problem: Three Number Sum
Difficulty: Medium 🔵
"""

# Solution 1: O(n^3)


def threeNumberSum(array, targetSum):
    result = []
    for a in range(0, len(array)):
        for b in range(a + 1, len(array) - 1):
            for c in range(b + 1, len(array)):
                pair = []
                if array[a] + array[b] + array[c] == targetSum:
                    pair = [array[a], array[b], array[c]]
                    result.append(sorted(pair))
    return sorted(result)


output = threeNumberSum([12, 3, 1, 2, -6, 5, -8, 6], 0)
print(output)

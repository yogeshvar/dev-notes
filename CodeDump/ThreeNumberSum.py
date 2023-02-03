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

# Solution 2: O(n^2)


def threeNumberSum(array, targetSum):
    result = []
    array.sort()
    for a in range(0, len(array) - 1):
        pointer = a + 1
        end = len(array) - 1
        while(pointer < end):
            sum = array[a] + array[pointer] + array[end]
            if (sum == targetSum):
                result.append([array[a], array[pointer], array[end]])
                pointer += 1
                end -= 1
            elif sum < targetSum:
                pointer += 1
            else:
                end -= 1
    return result

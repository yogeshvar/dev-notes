"""
AlgoExpert Problem: Sorted Square Array
Difficulty: Easy 🟢
"""


def isValidSubsequence(array: list, solution: int) -> list:
    if solution == 1:
        return sorted([x * x for x in array])
    elif solution == 2:
        outputArr = list()
        for i in array:
            outputArr.append(i * i)
        return sorted(outputArr)


output = isValidSubsequence([1, 2, 3, 11, 6, 8, 9], solution=2)
print(output)

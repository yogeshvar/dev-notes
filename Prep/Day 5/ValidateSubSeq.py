"""
AlgoExpert Problem: Validate SubSequence
Difficulty: Easy 🟢
"""


def isValidSubsequence(array: list, sequence: list) -> bool:
    checkIdx = 0
    for idx, _ in enumerate(array):
        if array[idx] is sequence[checkIdx]:
            checkIdx += 1
        if checkIdx == len(sequence):
            return True
        else:
            continue
    return False


array = [5, 1, 22, 25, 6, -1, 8, 10]
sequence = [22, 25, 6, 8]

output = isValidSubsequence(array, sequence)
print(output)

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

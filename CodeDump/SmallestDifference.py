"""
AlgoExpert Problem: Smallest Difference
Difficulty: Medium 🔵
"""

# O(N log N + M log M)


def smallestDifference(arrayOne, arrayTwo):
    arrayOne.sort()
    arrayTwo.sort()
    smallest = float("inf")
    pair = []
    i = 0
    j = 0
    while i < len(arrayOne) and j < len(arrayTwo):
        difference = abs(arrayOne[i] - arrayTwo[j])
        if difference < smallest:
            smallest = difference
            pair = [arrayOne[i], arrayTwo[j]]
        if arrayOne[i] > arrayTwo[j]:
            j += 1
        else:
            i += 1
    return pair


def smallestDifference_2(arrayOne, arrayTwo):
    arrayOne.sort()
    arrayTwo.sort()
    smallestValue = arrayOne[0] - arrayTwo[0]
    for i in arrayOne:
        pointer = 0
        end = len(arrayTwo)
        while(pointer < end):
            if i - arrayTwo[pointer] == 0:
                return [i, arrayTwo[pointer]]
            if i - arrayTwo[pointer] > smallestValue:
                if i - arrayTwo[pointer] < abs(smallestValue):
                    smallestValue = i - arrayTwo[pointer]
                    smallestPair = [i, arrayTwo[pointer]]
            elif smallestValue > abs(i - arrayTwo[pointer]):
                smallestValue = i - arrayTwo[pointer]
                smallestPair = [i, arrayTwo[pointer]]
            pointer += 1
    return smallestPair


# Worst Code: O(n^3)


def smallestDifference_1(arrayOne, arrayTwo):
    arrayOne.sort()
    arrayTwo.sort()
    smallestValue = arrayOne[0] - arrayTwo[0]
    for i in arrayOne:
        pointer = 0
        end = len(arrayTwo)
        while(pointer < end):
            if i - arrayTwo[pointer] == 0:
                smallestPair = [i, arrayTwo[pointer]]
                return smallestPair
            if (i - arrayTwo[pointer]) > smallestValue:
                if (i - arrayTwo[pointer]) < abs(smallestValue):
                    smallestValue = i - arrayTwo[pointer]
                    smallestPair = [i, arrayTwo[pointer]]
                else:
                    pointer += 1
            else:
                if abs(i - arrayTwo[pointer]) < smallestValue:
                    smallestValue = i - arrayTwo[pointer]
                    smallestPair = [i, arrayTwo[pointer]]
                pointer += 1
    return smallestPair


output = smallestDifference([-1, 5, 10, 20, 28, 3],
                            [26, 134, 135, 15, 17])
print(output)

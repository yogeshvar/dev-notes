"""
AlgoExpert Problem: Smallest Difference
Difficulty: Medium 🔵
"""


def smallestDifference(arrayOne, arrayTwo):
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
                if abs(i - arrayTwo[pointer]) < (smallestValue):
                    smallestValue = i - arrayTwo[pointer]
                    smallestPair = [i, arrayTwo[pointer]]
                pointer += 1
    return smallestPair


output = smallestDifference([10, 0, 20, 25, 2000],
                            [1005, 1006, 1014, 1032, 1031])

# Interview Preparation Kit - 1 week challenge problem - Day 1

def plusMinusLambda(arr):
    arr = list(map(lambda x: float(format(x/len(arr), '.6f')), arr))
    pos = sum(x for x in arr if x > 0)
    neg = sum(x for x in arr if x < 0)
    zero = sum(x for x in arr if x == 0)
    print("{0:.6f}\n{1:.6f}\n{2:.6f}".format(pos, neg, zero))


def plusMinus(a):
    pos = 0
    neg = 0
    zero = 0
    for item in a:
        if item < 0:
            neg += 1
        elif item > 0:
            pos += 1
        elif item == 0:
            zero += 1
    printRatio(pos, len(a))
    printRatio(neg, len(a))
    printRatio(zero, len(a))


def printRatio(num, n):
    # print with 6 decimal places
    print("{0:.6f}".format(num/n))


arr = [-4, 3, -9, 0, 4, 1]
plusMinus(arr)
# plusMinusLambda(arr)

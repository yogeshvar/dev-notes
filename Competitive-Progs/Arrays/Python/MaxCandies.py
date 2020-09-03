# Max Candies
def kid_with_candies(candies, extra_candies):
    maximum = max(candies)
    print [(candy + extra_candies) >= maximum for candy in candies]


candies = [2, 3, 5, 1, 3]
extra_candies = 3


kid_with_candies(candies, extra_candies)

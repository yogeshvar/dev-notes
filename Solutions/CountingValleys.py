steps = 8
path = "UDDDUDUU"

# Hacker Rank - Interview Preparation Kit - Warmup - Counting Valleys
def countingValleys(steps, path):
    level = 0
    valleys = 0
    for i in path:
        if i == "U":
            level += 1
        elif i == "D":
            level -= 1
        if level == 0 and i == "U":
            valleys += 1
    return valleys


ans = countingValleys(steps, path)
print(ans)

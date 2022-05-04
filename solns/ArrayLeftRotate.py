# Hacker Rank - Array Left Rotation
def leftRotate(a, d):
    s = list(range(1, a+1))
    if len(s) == d:
        return s
    else:
        all_combinations = []
        for i in range(len(s)):
            all_combinations.append(s[i:len(s)] + s[0:i])
    return all_combinations[d % len(s)]


ans = leftRotate(5, 11)
print(ans)

c = [0, 1, 0,  0, 0, 1, 0]

# Hacker Rank - Interview Preparation Kit - Warmup - Jumping on the Clouds
def jumpingOnClouds(c):
    jumps = 0
    i = 0
    while i < len(c) - 1:
        if i + 2 < len(c) and c[i + 2] == 0:
            i += 2
        else:
            i += 1
        jumps += 1
    return jumps


ans = jumpingOnClouds(c)
print(ans)

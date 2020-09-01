n = 5
start = 0
nums = [None] * n
value = 0
for i in range(n):
    value ^= start + 2 * i
print(value)
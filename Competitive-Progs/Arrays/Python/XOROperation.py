n = 5
start = 0
nums = [None] * n
value = 0
for i in range(0,n):
    value = value ^ start + 2 * i
print(value)
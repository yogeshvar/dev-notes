nums = [1, 4, 3, 2]
result = 0

nums.sort()
c = 0
for i in range(0, len(nums), 2):
    print(nums[i])
    c += nums[i]

print(c)

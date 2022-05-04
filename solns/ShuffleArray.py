nums = [1, 2, 3, 4, 4, 3, 2, 1]
n = 4
res = []

for i in range(0, len(nums)):
    if(i+n == len(nums)):
        break
    res.append(nums[i])
    res.append(nums[i+n])

print(res)

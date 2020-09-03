nums = [4, 3, 2, 7, 8, 2, 3, 1]

uniq = list(set(nums))
result = []
ans = {}
for i in uniq:
    ans[i] = nums.count(i)

for value in ans:
    if ans[value] >= 2:
        result.append(value)
print(result)

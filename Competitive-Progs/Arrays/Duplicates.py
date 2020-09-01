nums = [4, 3, 2, 7, 8, 2, 3, 1]

uniq = list(set(nums))
ans = {}
for i in uniq:
    ans[i] = nums.count(i)

result = [value for value, value_ in ans.items() if value_ >= 2]
print(result)

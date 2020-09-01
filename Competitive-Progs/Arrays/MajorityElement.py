# Majority Element in Array
nums = [2, 2, 1, 1, 1, 2, 2]

uniq = list(set(nums))
ans = {}
for i in uniq:
    ans[i] = nums.count(i)

for value, value_ in ans.items():
    if value_ > len(nums) / 2:
        print('Majority Value', value)

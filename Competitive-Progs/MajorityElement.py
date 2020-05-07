# Majority Element in Array
nums = [2, 2, 1, 1, 1, 2, 2]

uniq = list(set(nums))
ans = {}
for i in uniq:
    ans[i] = nums.count(i)

for value in ans:
    if ans[value] > len(nums) / 2:
        print 'Majority Value', value

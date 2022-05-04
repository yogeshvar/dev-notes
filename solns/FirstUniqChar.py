s = "loveleetcode"

# Solution 1
st = list(s)
for i in st:
    if st.count(i) == 1:
        print(st.index(i))
print -1

# Solution 2
frequency = {}
for i in s:
    if i not in frequency:
        frequency[i] = 1
    else:
        frequency[i] += 1

for i in range(len(s)):
    if frequency[s[i]] == 1:
        print i
print -1



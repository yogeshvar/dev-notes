def palindromeIndex(s):
    if s == s[::-1]:
        return -1
    for i in range(len(s)):
        print(s[i], s[-i-1])
        if s[i] != s[-i-1]:
            if s[i+1:-i] == s[i+1:-i][::-1]:
                return i
            else:
                return len(s)-i-1
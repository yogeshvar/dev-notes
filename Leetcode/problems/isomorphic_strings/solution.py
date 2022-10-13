class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        hash_map = {}
        for i in range(len(s)):
            if s[i] not in hash_map:
                hash_map[s[i]] = t[i]
            elif hash_map[s[i]] != t[i]:
                return False
        if (len(set(s)) == len(hash_map) and len(set(t)) == len(hash_map)): 
            return True
                
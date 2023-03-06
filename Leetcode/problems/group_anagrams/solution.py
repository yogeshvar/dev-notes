class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashset = {}
        for s in strs:
            key = "".join(sorted(s))
            if key in hashset:
                hashset[key].append(s)
            else:
                hashset[key] = [s]
        return hashset.values()
class Solution:
    def return_hash(self, arr):
            hash_table = {}
            for i in arr:
                hash_table[i] = hash_table.get(i, 0) + 1
            return hash_table    

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        a_hash = self.return_hash(nums1)
        ans = []
        for j in nums2:
            if a_hash.get(j, 0) > 0:
                ans.append(j)
            if a_hash.get(j, 0) == 0:
                a_hash[j] = -1
            else:
                a_hash[j] = a_hash.get(j, 0) - 1
        return ans

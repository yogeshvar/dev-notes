class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        alt = 0
        highest_alt = 0
        for i in gain: 
            alt = alt + i
            if alt > highest_alt:
                highest_alt = alt
        return highest_alt
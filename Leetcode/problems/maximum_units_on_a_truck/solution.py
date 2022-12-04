class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: x[1], reverse=True)

        maxUnits = 0
        boxesUsed = 0
        for boxes, units in boxTypes:
            if truckSize >= boxesUsed + boxes:
                boxesUsed += boxes
                maxUnits += boxes * units
            else: 
                diff = truckSize - boxesUsed
                maxUnits += diff * units
                boxesUsed += diff
        return maxUnits
nums = [1,2,3,4]

def decompressRLElist(nums):
    result = []
    for i in range(0,len(nums),2):
        result += nums[i]*[nums[i+1]]
    return result

x = decompressRLElist(nums)

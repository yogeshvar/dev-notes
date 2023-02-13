"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""


def minimalTree(self, nums: List[int]) -> Optional[TreeNode]:
    if not nums:
        return None
    mid = len(nums) // 2
    root = TreeNode(nums[mid])
    root.left = self.minimalTree(nums[:mid])
    root.right = self.minimalTree(nums[mid+1:])
    return root

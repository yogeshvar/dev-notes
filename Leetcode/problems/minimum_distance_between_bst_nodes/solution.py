# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        stack = []
        node = root
        prev = None
        min_diff = float('inf')
        while stack or node:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            if prev:
                min_diff = min(min_diff, node.val - prev.val)
            prev = node
            node = node.right
        return min_diff
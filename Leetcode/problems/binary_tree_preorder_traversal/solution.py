# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res, stack = [], []
        while True:
            while root:
                stack.append(root)
                res.append(root.val)
                root = root.left
            if not stack:
                return res
            node = stack.pop()
            root = node.right  
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [str(root.val)]
        left = self.binaryTreePaths(root.left)
        right = self.binaryTreePaths(root.right)
        return [str(root.val) + '->' + path for path in left + right]

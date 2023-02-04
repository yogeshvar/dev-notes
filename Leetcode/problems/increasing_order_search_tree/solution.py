# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        def inorder(node):
            return inorder(node.left) + [node.val] + inorder(node.right) if node else []
        
        nodes = inorder(root)
        new_tree = TreeNode(nodes[0])
        curr = new_tree
        for i in range(1, len(nodes)):
            curr.right = TreeNode(nodes[i])
            curr = curr.right
        return new_tree
class TreeNode(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def isValidBST(root):
    if root is None:
        return True
    if root.left is None and root.right is None:
        return True
    if root.left is None:
        return root.val < root.right.val and isValidBST(root.right)
    if root.right is None:
        return root.val > root.left.val and isValidBST(root.left)
    else:
        return root.val > root.left.val and root.val < root.right.val and isValidBST(root.left) and isValidBST(root.right)
    
        


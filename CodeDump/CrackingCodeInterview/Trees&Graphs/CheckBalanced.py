# balanced binary tree

def isBalanced(root):

    def height(root):
        if root is None:
            return 0
        return 1 + max(height(root.left), height(root.right))

    if root is None:
        return True
    if abs(height(root.left) - height(root.right)) > 1:
        return False
    return isBalanced(root.left) and isBalanced(root.right)

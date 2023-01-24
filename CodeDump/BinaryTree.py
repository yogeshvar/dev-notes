class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def bt_height(root):
    if root is None:
        return 0
    leftHeight = bt_height(root.l)
    rightHeight = bt_height(root.r)
    return max(leftHeight, rightHeight) + 1

def bt_min(root):
    if root is None:
        return 0
    if not root.left and not root.right:
        return 1
    if not root.left:
        return bt_min(root.right) + 1
    if not root.right:
        return bt_min(root.left) + 1
    return min(bt_min(root.left), bt_min(root.right)) + 1

def path_sum(root, target):
    if root is None:
        return False
    if not root.left and not root.right:
        return root.val == target
    target -= root.val
    return path_sum(root.left, target) or path_sum(root.right, target)

def add_leaf(root, leaf):
    if root is None:
        root = TreeNode(leaf)
        return root
    if leaf < root.val:
        root.left = add_leaf(root.left, leaf)
    else:
        root.right = add_leaf(root.right, leaf)
    return root

def get_min(root):
    while root.l is not None:
        root = root.l
    return root

def get_max(root):
    while root.r is not None:
        root = root.r
    return root

def search(root, find_val):
    if root.val == find_val:
        print('Found')
        return
    if find_val < root.val:
        if root.l:
            search(root.l, find_val)
        else:
            print('Empty Node')
    else:
        if root.r:
            search(root.r, find_val)
        else:
            print('Empty Node')

def delete(root, key):

    if root is None:
        return root
    
    if key < root.val:
        root.l = delete(root.l, key)
    elif key > root.val:
        root.r = delete(root.r, key)
    else:
        if root.l is None:
            tmp = root.r
            root = None
            return tmp
        elif root.r is None:
            tmp = root.l 
            root = None
            return tmp
        
        tmp = get_min(root.right)
        root.val = tmp.val

        root.r = delete(root.r, tmp.val)
    return root

def inorder(root):
    if root:
        inorder(root.left)
        print(root.val)
        inorder(root.right)

def preorder(root):
    if root:
        print(root.val)
        preorder(root.right)
        preorder(root.left)

def postorder(root):
    if root:
        postorder(root.right)
        postorder(root.left)
        print(root.val)

r = TreeNode(50)
r = add_leaf(r, 30)
r = add_leaf(r, 20)
r = add_leaf(r, 40)
r = add_leaf(r, 70)
r = add_leaf(r, 60)
r = add_leaf(r, 90)

inorder(r)
print('====')

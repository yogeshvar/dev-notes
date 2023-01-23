class TreeNode:
    def __init__(self, val):
        self.val = val
        self.l = None
        self.r = None

def add_leaf(root, leaf):
    if root is None:
        root = TreeNode(leaf)
        return root
    if leaf < root.val:
        root.l = add_leaf(root.l, leaf)
    else:
        root.r = add_leaf(root.r, leaf)
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

def display(root):
    if root:
        display(root.l)
        print(root.val)
        display(root.r)

r = TreeNode(50)
r = add_leaf(r, 30)
r = add_leaf(r, 20)
r = add_leaf(r, 40)
r = add_leaf(r, 70)
r = add_leaf(r, 60)
r = add_leaf(r, 90)

display(r)
print('====')

search(r, 30)

delete(r, 90)
print('====')
display(r)
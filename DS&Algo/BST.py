class Node(object):

    def __init__(self, value):
        self.value = value
        self.right = None
        self.left = None


class Tree(object):

    def __init__(self):
        self.root = None

    def search(self, root, value_to_search):
        if root is None or root.value is value_to_search:
            return root

        if root.value < value_to_search:
            return self.search(root.right, value_to_search)

        return self.search(root.left, value_to_search)

    def delete_tree(self):
        self.root = None

    @staticmethod
    def min_node_value(node):
        current = node
        while current.left is not None:
            current = current.left

        return current

    def insert(self, root, value_to_insert):
        node = Node(value_to_insert);
        if root is None:
            self.root = node
        else:
            if root.value < node.value:
                if root.right is None:
                    root.right = node
                else:
                    self.insert(root.right, value_to_insert)
            else:
                if root.left is None:
                    root.left = node
                else:
                    self.insert(root.left, value_to_insert)

    def delete(self, root, value_to_delete):
        if root is None:
            return root

        if value_to_delete < root.value:
            root.left = self.delete(root.left, value_to_delete)
        elif value_to_delete > root.value:
            root.right = self.delete(root.right, value_to_delete)
        else:

            if root.left is None:
                temp = root.right
                root = None
                return temp
            elif root.right is None:
                temp = root.left
                root = None
                return temp

            temp = self.min_node_value(root.right)
            root.value = temp.value
            root.right = self.delete(root.right, temp.value)
        return root

    def in_order(self, node):
        if node:
            self.in_order(node.left)
            print node.value,
            self.in_order(node.right)



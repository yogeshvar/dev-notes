class Node(object):

    def __init__(self, value):
        self.value = value
        self.right = None
        self.left = None

    def get_value(self):
        print self.value

    def set_value(self, value):
        self.value = value

    def get_left(self):
        return self.left

    def get_right(self):
        return self.right

    def set_left(self, left):
        self.left = left

    def set_right(self, right):
        self.right = right


class Tree(object):

    def __init__(self):
        self.root = None

    def min_node(self):
        while self.root.get_left():
            node = self.root.get_left()

        return node

    def delete_node(self, node_value):
        if not self.root:
            self.root = self.min_node(self.root)
        else:
            self.delete_node_from_tree(self.root, node_value)

    def delete_node_from_tree(self, root, value):
        parent = None
        curr = root
        while curr and curr.get_value() is not value:
            parent = curr
            if value < curr.get_value():
                curr = curr.get_left()
            else:
                curr = curr.get_right()
        if curr is None:
            return root
        # deleting the children node
        if curr.get_right() is None and curr.get_left() is None:
            if curr != root:
                if parent.get_left() == curr:
                    parent.set_left(None)
                else:
                    parent.set_left(None)
            else:
                root = None
        # delete two with 2 children
        elif curr.get_left() and curr.get_right():
            successor = self.min_node()
            val = successor.get_value()
            print val
        return root

    def insert_node(self, node_value):
        if not self.root:
            self.root = Node(node_value)
        else:
            self.insert_node_to_tree(self.root, node_value)

    def insert_node_to_tree(self, root, value):
        if value < root.value:
            if root.get_left():
                self.insert_node_to_tree(root.get_left(), value)
            else:
                root.set_left(Node(value))
        else:
            if root.get_right():
                self.insert_node_to_tree(root.get_right(), value)
            else:
                root.set_right(Node(value))

    def search_value(self, value):
        queue = []
        queue.insert(0, self.root)
        while queue is not None:
            present_node = queue.pop()
            if present_node.value is value:
                print 'Value found'
                return
            else:
                if present_node.get_left():
                    left_node = present_node.get_left()
                    queue.insert(0, left_node)
                if present_node.get_right():
                    right_node = present_node.get_right()
                    queue.insert(0, right_node)
        print 'Value not found'

    def traverse(self):
        if self.root:
            self.in_order(self.root)

    def in_order(self, node):
        if node.get_left():
            self.in_order(node.get_left())
        print node.get_value(),
        if node.get_right():
            self.in_order(node.get_right())

    def delete_tree(self):
        self.root = None

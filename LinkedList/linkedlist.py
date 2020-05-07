class Node(object):

    def __init__(self, data=None):
        self.data = data
        self.next_node = None

    def get_data(self):
        return self.data

    def get_next(self):
        return self.next_node


class Linked_list(object):

    def __init__(self):
        self.head = None

    def print_reverse(self):
        temp = self.head
        result = []
        while temp:
            result.append(temp.data)
            temp = temp.next_node
        result.reverse()
        for i in result:
            print i,

    # print len
    def print_len(self):
        temp = self.head
        index = 1
        while temp.next_node is not None:
            index += 1
            temp = temp.next_node
        print index

    # print Linked List
    def print_list(self):
        temp = self.head
        while temp:
            print temp.data,
            temp = temp.next_node

    # add node to head
    def prepend(self, value):
        temp = Node(value)
        temp.next_node = self.head
        self.head = temp

    # add node to tail
    def append(self, value):
        temp = self.head
        tail = Node(value)
        while temp:
            if temp.next_node is None:
                temp.next_node = tail
                break
            temp = temp.next_node

    def delete_node_by_value(self, value):
        temp = self.head
        while temp:
            if temp.next_node is not None and temp.next_node.data is value or temp.data is value:
                # check for head deletion
                if self.head.data is value:
                    self.head = self.head.next_node
                    break
                # check for tail deletion
                elif temp.next_node is None:
                    print temp.data
                    break
                else:
                    temp.next_node = temp.next_node.next_node
                    break
            temp = temp.next_node

    def delete_list(self):
        self.head = None

    def search_value(self, value):
        temp = self.head
        index = 1
        while temp:
            if temp.data is value:
                print 'Value', temp.data, 'is at index', index
            index += 1
            temp = temp.next_node

    def insert_node_by_value(self, value, position):
        temp = self.head
        node = Node(value)
        index = 1
        while temp:
            # check inserting at head.
            if index is position and index is 1:
                node.next_node = self.head
                self.head = node
                break
            # check inserting at tail.
            elif index is position and temp.next_node is None:
                temp.next_node = node
                break
            elif index is position:
                print temp.data
                node.next_node = temp.next_node
                temp.next_node = node
                break
            index += 1
            temp = temp.next_node

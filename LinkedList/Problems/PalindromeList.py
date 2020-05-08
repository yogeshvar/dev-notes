class Node(object):

    def __init__(self, data=None):
        self.data = data
        self.next_node = None


class Linked_list_without_tail(object):

    def __init__(self):
        self.head = None

    def check_palindrome(self):
        temp = self.head
        head = self.head
        while temp:
            if temp.next_node is None:
                if head.data is temp.data:
                    print 'It\'s a Palindrome'
                    break
                else:
                    print 'Not a Palindrome'
            temp = temp.next_node


class Linked_list(object):

    def __init__(self):
        self.head = None
        self.tail = None

    def check_palindrome(self):
        if self.head.data is self.tail.data:
            print 'Linked List is Palindrome'
        else:
            print 'Linked List is not Palindrome'

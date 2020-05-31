class Array(object):
    def __init__(self, size):
        self.size = size
        self.items = [0] * size

    def __len__(self):
        return len(self.items)

    def __setitem__(self, index, value):
        self.items[index] = value

    def __getitem__(self, index):
        return self.items[index]

    def search(self, value_to_search):
        for i in range(self.size):
            if self.item[i] == value_to_search:
                return i
        return -1

    def insert(self, index, value):
        if self.size > index:
            if self.items[index] is 0:
                self.items[index] = value
            else:
                print 'Value present'
        else:
            print 'Array size is: ', self.size

    def delete(self, value_to_delete, position):
        if self.size > position:
            if self.items[position] == value_to_delete:
                self.items[position] = 0
            print 'Value not found'
        print 'Array size is: ', self.size

    def print_array(self):
        for i in self.items:
            print i

    def print_reverse(self):
        for i in range(self.size, 0, -1):
            print self.items[i-1]

    def odd_values(self):
        for i in range(1, self.size, 2):
            print self.items[i-1]

    def sum_of_odd_nos(self):
        res = 0
        for i in range(1, self.size, 2):
            res += self.items[i-1]
        print res

    def even_values(self):
        for i in range(1, self.size):
            if i%2 is not 0:
                print i

    def sum_of_even_nos(self):
        res = 0
        for i in range(1, self.size):
            if i%2 is not 0:
                res += self.items[i]
        print res

    def find_duplicate(self):
        print set([x for x in self.items if self.items.count(x) > 1])


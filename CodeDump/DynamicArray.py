import ctypes
class DynamicArray(object):
    def __init__(self):
        self.size = 0
        self.capacity = 1
        self.items = self.resize(self.capacity)

    def __len__(self): 
        return self.size

    def __getitem__(self, key):
        if not 0 <= key < self.size:
            return IndexError('key not found')
        return self.items[key]
    
    def append(self, value):
        if(self.capacity == self.capacity):
            self.make_room(2 * self.capacity)
        self.items[self.size] = value
        self.size += 1
    
    def make_room(self, new_capacity):
        new_array = self.resize(new_capacity)
        for key in range(self.size):
            new_array[key] = self.items[key]
            self.items = new_array
            self.capacity = new_capacity
    
    def resize(self, new_capacity):
        return (new_capacity * ctypes.py_object)()

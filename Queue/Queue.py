class Queue(object):

    def __init__(self):
        self.queue = []

    def is_empty(self):
        if self.queue is []:
            print 'Empty Queue'

    def enqueue(self, value):
        self.queue.insert(0, value)

    def dequeue(self):
        self.queue.pop()

    def queue_size(self):
        print len(self.queue)

    def print_queue(self):
        for i in range(0,len(self.queue)):
            print '->', self.queue[i],

class Graph(object):

    def __init__(self, size):
        self.adj_matrix = []
        for _ in range(size):
            self.adj_matrix.append([0 for i in range(size)])
        self.size = size

    def add_edge(self, v1, v2):
        if v1 is v2:
            print "Same vertex"
        self.adj_matrix[v1][v2] = 1
        self.adj_matrix[v2][v1] = 1

    def remove_edges(self, v1, v2):
        if self.adj_matrix[v1][v2] is 0:
            print "No edge"
        self.adj_matrix[v1][v2] = 0
        self.adj_matrix[v2][v1] = 0

    def __len__(self):
        return self.size

    def print_graph(self):
        for r in self.adj_matrix:
            for v in r:
                print('{:4}'.format(v)),
            print


g = Graph(5)

g.add_edge(0, 1)
g.add_edge(0, 2)
g.add_edge(1, 2)
g.add_edge(2, 0)
g.add_edge(2, 3)
g.print_graph()

